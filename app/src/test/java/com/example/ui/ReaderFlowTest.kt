package com.example.ui

import com.github.takahirom.roborazzi.captureRoboImage
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
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
@Config(sdk = [35], qualifiers = "w411dp-h891dp-xxhdpi")
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

        waitForText("THE ZEUS TESTIMONY")
        rule.onNodeWithText("12 volumes", substring = true).assertExists()
        shot("1_home")

        rule.onNode(hasScrollAction()).performScrollToNode(hasText("The Firstborn"))
        rule.onAllNodesWithText("The Firstborn").onFirst().performClick()
        waitForText("VOLUME III")
        rule.onNodeWithText("CHAPTER 4").assertExists()
        shot("2_volume")

        rule.onNodeWithText("The Claiming of the First World").performClick()
        waitForText("Vol. III · Ch. 2")
        shot("3_chapter")

        rule.onNode(hasScrollAction()).performScrollToNode(hasText("Next:", substring = true))
        rule.onNodeWithText("Next: The Great Inhalation").performClick()
        waitForText("Vol. III · Ch. 3")
        rule.onNode(hasScrollAction()).performScrollToNode(hasText("SCIENCE"))
        shot("4_next_chapter_commentary")
    }
}
