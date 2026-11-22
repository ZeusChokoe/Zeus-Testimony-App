package com.example.ui

import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import com.example.ui.theme.AppTheme
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [35], qualifiers = "w360dp-h640dp-xxhdpi")
/** Light theme: home volume cards and a chapter with commentary render correctly. */
class LightModeTest {
    @get:Rule val rule = createComposeRule()
    private fun wait(t: String) = rule.waitUntil(10_000) { rule.onAllNodesWithText(t, substring = true).fetchSemanticsNodes().isNotEmpty() }
    @Test fun light() {
        rule.setContent { AppTheme(darkTheme = false) { AppNavigation() } }
        wait("THE ZEUS TESTIMONY")
        rule.onNode(hasScrollAction()).performScrollToNode(hasText("The Disk of Becoming"))
        rule.onRoot().captureRoboImage("build/screens/light_home.png")
        rule.onAllNodesWithText("The Disk of Becoming").onFirst().performClick()
        wait("VOLUME II")
        rule.onNode(hasScrollAction()).performScrollToNode(hasText("The Line of Frost"))
        rule.onNodeWithText("The Line of Frost").performClick()
        wait("Vol. II")
        rule.onNode(hasScrollAction()).performScrollToNode(hasText("SCIENCE"))
        rule.onRoot().captureRoboImage("build/screens/light_chapter.png")
    }
}
