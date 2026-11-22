package com.example.ui

import com.github.takahirom.roborazzi.captureRoboImage
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.espresso.Espresso
import androidx.compose.ui.test.onAllNodesWithText
import com.example.ui.theme.AppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

/** Drives the real app: Home -> Volume III -> Chapter 2 -> Next chapter. Saves screenshots to build/screens. */
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [35], qualifiers = "w360dp-h640dp-xxhdpi")
class ReaderFlowTest {

    @get:Rule val rule = createComposeRule()

    /** Best effort: Robolectric's redraw hook can time out on later captures; that is not an app failure. */
    private fun shot(name: String) {
        runCatching { rule.onRoot().captureRoboImage("build/screens/$name.png") }.onFailure { println("screenshot $name skipped: ${it.javaClass.simpleName}") }
    }

    private fun waitForText(text: String) =
        rule.waitUntil(10_000) { rule.onAllNodesWithText(text, substring = true).fetchSemanticsNodes().isNotEmpty() }

    @Test
    fun readThroughAVolume() {
        rule.setContent { AppTheme(darkTheme = true) { AppNavigation() } }

        // First launch shows the introduction.
        waitForText("There was a king.")
        shot("0_intro")
        rule.onNodeWithText("Next").performClick()
        waitForText("You are part of this story.")
        rule.onNodeWithText("Skip").performClick()
        waitForText("THE ZEUS TESTIMONY")
        rule.onNodeWithText("13 volumes", substring = true).assertExists()
        shot("1_home")

        rule.onNode(hasScrollAction()).performScrollToNode(hasText("The Firstborn"))
        rule.onAllNodesWithText("The Firstborn").onFirst().performClick()
        waitForText("VOLUME III")
        shot("2_volume")
        rule.onNode(hasScrollAction()).performScrollToNode(hasText("CHAPTER 4"))
        rule.onNodeWithText("CHAPTER 4").assertExists()

        rule.onNodeWithText("The Claiming of the First World").performClick()
        waitForText("Vol. III · Ch. 2")
        shot("3_chapter")

        rule.onNode(hasScrollAction()).performScrollToNode(hasText("Next:", substring = true))
        rule.onNodeWithText("Next: The Great Inhalation").performClick()
        waitForText("Vol. III · Ch. 3")
        rule.onNode(hasScrollAction()).performScrollToNode(hasText("SCIENCE"))
        shot("4_next_chapter_commentary")

        // Bookmark and highlight verse 1, then find both in My Library.
        rule.onNode(hasScrollAction()).performScrollToNode(hasText("When the core of the Firstborn", substring = true))
        rule.onNodeWithContentDescription("Verse 1").performClick()
        waitForText("Bookmark for later")
        rule.onNodeWithText("Bookmark for later").performClick()
        rule.onNodeWithContentDescription("Highlight Gold").performClick()
        waitForText("Remove bookmark")
        shot("5_verse_actions")
        Espresso.pressBack()
        rule.waitUntil(10_000) { rule.onAllNodesWithText("Remove bookmark").fetchSemanticsNodes().isEmpty() }
        rule.waitForIdle()
        rule.onNodeWithContentDescription("Back").performClick()
        waitForText("VOLUME III")
        rule.waitForIdle()
        rule.onNodeWithContentDescription("Back").performClick()
        rule.waitForIdle()
        rule.onNode(hasScrollAction()).performScrollToIndex(0)
        waitForText("THE ZEUS TESTIMONY")
        rule.onNodeWithContentDescription("My Library").performClick()
        waitForText("Bookmarks (1)")
        rule.onNodeWithText("Ch. 3 · Verse 1", substring = true).assertExists()
        rule.onNodeWithText("Highlights (1)").assertExists()
        shot("6_library")

        // Search finds the new Trojan chapter.
        rule.waitForIdle()
        rule.onNodeWithContentDescription("Back").performClick()
        waitForText("THE ZEUS TESTIMONY")
        rule.waitForIdle()
        rule.onNodeWithContentDescription("Search").performClick()
        rule.onNode(hasSetTextAction()).performTextInput("Achilles")
        waitForText("The Camps of the Trojan War")
        shot("7_search")
    }
}
