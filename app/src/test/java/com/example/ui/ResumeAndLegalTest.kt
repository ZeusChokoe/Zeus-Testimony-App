package com.example.ui

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.hasText
import androidx.test.core.app.ApplicationProvider
import com.example.data.Position
import com.example.data.ReadingPrefs
import com.example.ui.theme.AppTheme
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

/** A returning reader is offered to continue at the exact verse, and Privacy and Terms are reachable. */
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [35], qualifiers = "w360dp-h640dp-xxhdpi")
class ResumeAndLegalTest {
    @get:Rule val rule = createComposeRule()

    private fun waitFor(text: String) =
        rule.waitUntil(10_000) { rule.onAllNodesWithText(text, substring = true).fetchSemanticsNodes().isNotEmpty() }

    @Test
    fun resumePromptOpensSavedVerse() {
        ReadingPrefs(ApplicationProvider.getApplicationContext<Context>()).apply {
            introSeen = true
            lastRead = Position(2, 1)
            lastVerse = 5
        }
        rule.setContent { AppTheme(darkTheme = true) { AppNavigation() } }
        waitFor("Pick up where you paused")
        rule.onNodeWithText("Vol. III · Ch. 2, verse 5", substring = true).assertExists()
        rule.onRoot().captureRoboImage("build/screens/8_resume_prompt.png")
        rule.onNodeWithText("Continue").performClick()
        waitFor("Vol. III · Ch. 2")
    }

    @Test
    fun privacyAndTermsAreReadable() {
        ReadingPrefs(ApplicationProvider.getApplicationContext<Context>()).introSeen = true
        rule.setContent { AppTheme(darkTheme = true) { AppNavigation() } }
        waitFor("THE ZEUS TESTIMONY")
        rule.onNode(hasScrollAction()).performScrollToNode(hasText("Privacy and Terms"))
        rule.onNodeWithText("Privacy and Terms").performClick()
        waitFor("collects no personal data")
        rule.onRoot().captureRoboImage("build/screens/9_privacy.png")
        rule.onNodeWithText("Terms of Use").performClick()
        waitFor("Republic of South Africa")
    }
}
