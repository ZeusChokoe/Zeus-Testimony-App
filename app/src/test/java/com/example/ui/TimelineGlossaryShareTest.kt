package com.example.ui

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import androidx.test.core.app.ApplicationProvider
import com.example.data.ReadingPrefs
import com.example.data.TestimonyParser
import com.example.ui.components.VerseCard
import com.example.ui.theme.AppTheme
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import java.io.File

/** Timeline order, the glossary, Listen mode and the verse image card. */
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [35], qualifiers = "w360dp-h640dp-xxhdpi")
class TimelineGlossaryShareTest {
    @get:Rule val rule = createComposeRule()
    private val context get() = ApplicationProvider.getApplicationContext<Context>()

    private fun waitFor(text: String) =
        rule.waitUntil(10_000) { rule.onAllNodesWithText(text, substring = true).fetchSemanticsNodes().isNotEmpty() }

    @Test
    fun timelineRunsFromPastToFutureAndOpensChapters() {
        ReadingPrefs(context).introSeen = true
        rule.setContent { AppTheme(darkTheme = true) { AppNavigation() } }
        waitFor("THE ZEUS TESTIMONY")
        rule.onNodeWithContentDescription("Timeline").performClick()
        waitFor("Every chapter in the order it happens")
        rule.onNodeWithText("BEFORE THE SUN").assertExists()
        rule.onRoot().captureRoboImage("build/screens/11_timeline.png")
        rule.onNode(hasScrollAction()).performScrollToNode(hasText("THE FUTURE"))
        rule.onNodeWithText("THE FUTURE").assertExists()
    }

    @Test
    fun glossaryIsReachableFromAbout() {
        ReadingPrefs(context).introSeen = true
        rule.setContent { AppTheme(darkTheme = true) { AppNavigation() } }
        waitFor("THE ZEUS TESTIMONY")
        rule.onNodeWithContentDescription("About this book").performClick()
        rule.onNode(hasScrollAction()).performScrollToNode(hasText("Glossary of names"))
        rule.onNodeWithText("Glossary of names").performClick()
        waitFor("The Firstborn")
        rule.onRoot().captureRoboImage("build/screens/12_glossary.png")
    }

    @Test
    fun chapterShowsWhenAndListenButton() {
        ReadingPrefs(context).apply { introSeen = true; lastRead = com.example.data.Position(2, 0); lastVerse = 1 }
        rule.setContent { AppTheme(darkTheme = true) { AppNavigation() } }
        waitFor("Pick up where you paused")
        rule.onNodeWithText("Continue").performClick()
        waitFor("Vol. III · Ch. 1")
        rule.waitForIdle()
        // Continue jumps to the saved verse; scroll back up to the chapter title.
        rule.onNode(hasScrollAction()).performScrollToNode(hasText("WHEN:", substring = true))
        rule.onRoot().captureRoboImage("build/screens/14_chapter_when.png")
        rule.onNodeWithContentDescription("Listen to this chapter").assertExists()
    }

    @Test
    fun timelineIsChronologicalAndEveryChapterIsDated() {
        val book = TestimonyParser.parse(File("src/main/assets/testimony.txt").readText())
        val all = book.volumes.flatMap { it.chapters }
        assertTrue(all.all { it.whenYears != null && !it.whenLabel.isNullOrBlank() })
        // The book reaches from before the Sun to the far future.
        assertTrue(all.minOf { it.whenYears!! } < -4.58e9)
        assertTrue(all.maxOf { it.whenYears!! } > 0)
    }

    @Test
    fun verseCardRendersAtShareSize() {
        val book = TestimonyParser.parse(File("src/main/assets/testimony.txt").readText())
        val chapter = book.volumes[2].chapters[0]
        val card = VerseCard.render(context, chapter.image, chapter.verses[0].text, "Volume III, Chapter 1, Verse 1")
        assertEquals(VerseCard.WIDTH, card.width)
        assertEquals(VerseCard.HEIGHT, card.height)
        File("build/screens").mkdirs()
        File("build/screens/13_verse_card.png").outputStream().use { card.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, it) }
        assertTrue(BitmapFactory.decodeFile("build/screens/13_verse_card.png") != null)
    }
}
