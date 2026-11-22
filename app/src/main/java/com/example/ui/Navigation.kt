package com.example.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.data.Position
import com.example.data.ReadingPrefs
import com.example.data.Testimony
import com.example.data.TestimonyRepository
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.ChapterScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.VolumeScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val CHAPTER_ROUTE = "chapter/{volume}/{chapter}"

@Composable
fun AppNavigation() {
    val context = LocalContext.current
    val result by produceState<Result<Testimony>?>(initialValue = null) {
        value = withContext(Dispatchers.IO) { runCatching { TestimonyRepository.load(context) } }
    }

    when (val r = result) {
        null -> Centered { CircularProgressIndicator(color = MaterialTheme.colorScheme.primary) }
        else -> r.fold(
            onSuccess = { TestimonyNavHost(it) },
            onFailure = {
                Centered {
                    Text(
                        "The testimony could not be opened. Please reinstall the app.",
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center,
                    )
                }
            },
        )
    }
}

@Composable
private fun TestimonyNavHost(testimony: Testimony) {
    val context = LocalContext.current
    val prefs = remember { ReadingPrefs(context) }
    var lastRead by remember { mutableStateOf(prefs.lastRead?.takeIf { testimony.chapter(it) != null }) }
    var textScale by remember { mutableFloatStateOf(prefs.textScale) }
    val nav = rememberNavController()

    fun openChapter(p: Position, replaceCurrent: Boolean = false) {
        nav.navigate("chapter/${p.volume}/${p.chapter}") {
            if (replaceCurrent) popUpTo(CHAPTER_ROUTE) { inclusive = true }
        }
    }

    NavHost(navController = nav, startDestination = "home") {
        composable("home") {
            HomeScreen(
                testimony = testimony,
                lastRead = lastRead,
                onOpenVolume = { nav.navigate("volume/$it") },
                onOpenChapter = { openChapter(it) },
                onAbout = { nav.navigate("about") },
            )
        }
        composable(
            "volume/{volume}",
            arguments = listOf(navArgument("volume") { type = NavType.IntType }),
        ) { entry ->
            VolumeScreen(
                volume = testimony.volume(entry.arguments?.getInt("volume") ?: -1),
                onOpenChapter = { openChapter(it) },
                onBack = { nav.popBackStack() },
            )
        }
        composable(
            CHAPTER_ROUTE,
            arguments = listOf(
                navArgument("volume") { type = NavType.IntType },
                navArgument("chapter") { type = NavType.IntType },
            ),
        ) { entry ->
            val position = Position(
                entry.arguments?.getInt("volume") ?: -1,
                entry.arguments?.getInt("chapter") ?: -1,
            )
            ChapterScreen(
                testimony = testimony,
                position = position,
                textScale = textScale,
                onTextScaleChange = { textScale = it; prefs.textScale = it },
                onRead = { lastRead = it; prefs.lastRead = it },
                onNavigate = { openChapter(it, replaceCurrent = true) },
                onBack = { nav.popBackStack() },
            )
        }
        composable("about") {
            AboutScreen(testimony = testimony, onBack = { nav.popBackStack() })
        }
    }
}

@Composable
private fun Centered(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) { content() }
}
