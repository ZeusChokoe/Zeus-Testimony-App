package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ui.components.AssetImage
import kotlinx.coroutines.launch

private data class IntroPage(val image: String, val kicker: String, val title: String, val body: String)

private val pages = listOf(
    IntroPage(
        "v03_c01.webp",
        "BEFORE THE EARTH",
        "There was a king.",
        "Four and a half billion years ago, before the Earth existed, one world grew faster than all the rest. " +
            "Within a million years Jupiter was already standing. It was the first planet of our solar system.",
    ),
    IntroPage(
        "v03_c02.webp",
        "THE TESTIMONY",
        "The first god to hold a world.",
        "Jupiter carries the name of Zeus, the Sky Father. If Jupiter was the first world, then Zeus is the first god " +
            "of the solar realm to hold one. Above him stands the Source, unnamed. This is his story.",
    ),
    IntroPage(
        "v09_c01.webp",
        "SCIENCE, MYTH AND WISDOM",
        "Read with open eyes.",
        "The verses are an epic. Beneath them, notes marked Science, History and Myth tell you what is proven, " +
            "what is still debated, and what the ancients sang. Wisdom notes are for your own life.",
    ),
    IntroPage(
        "v12_c08.webp",
        "MAKE IT YOURS",
        "Tap any verse.",
        "Bookmark it for later, highlight it in gold, crimson, sky or olive, or share it. " +
            "Your library, search and a new verse every day are waiting. Everything stays on your device.",
    ),
)

@Composable
fun IntroScreen(onFinish: () -> Unit) {
    val pager = rememberPagerState { pages.size }
    val scope = rememberCoroutineScope()
    Box(Modifier.fillMaxSize().background(Color.Black)) {
        HorizontalPager(state = pager, modifier = Modifier.fillMaxSize()) { index ->
            val page = pages[index]
            Box(Modifier.fillMaxSize()) {
                AssetImage(path = page.image, contentDescription = null, modifier = Modifier.fillMaxSize())
                Box(
                    Modifier.fillMaxSize().background(
                        Brush.verticalGradient(
                            0f to Color.Black.copy(alpha = 0.15f),
                            0.45f to Color.Black.copy(alpha = 0.35f),
                            1f to Color.Black.copy(alpha = 0.95f),
                        ),
                    ),
                )
                Column(
                    Modifier.align(Alignment.BottomCenter).fillMaxWidth().padding(horizontal = 28.dp).padding(bottom = 150.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(page.kicker, style = MaterialTheme.typography.labelSmall, color = Color(0xFFC9A227), textAlign = TextAlign.Center)
                    Spacer(Modifier.height(12.dp))
                    Text(page.title, style = MaterialTheme.typography.titleLarge, color = Color.White, textAlign = TextAlign.Center)
                    Spacer(Modifier.height(16.dp))
                    Text(
                        page.body,
                        style = MaterialTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic),
                        color = Color.White.copy(alpha = 0.88f),
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

        Column(
            Modifier.align(Alignment.BottomCenter).fillMaxWidth().navigationBarsPadding().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                repeat(pages.size) { i ->
                    Box(
                        Modifier
                            .size(if (i == pager.currentPage) 10.dp else 7.dp)
                            .clip(CircleShape)
                            .background(if (i == pager.currentPage) Color(0xFFC9A227) else Color.White.copy(alpha = 0.4f)),
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
            val last = pager.currentPage == pages.lastIndex
            Button(
                onClick = { if (last) onFinish() else scope.launch { pager.animateScrollToPage(pager.currentPage + 1) } },
                modifier = Modifier.fillMaxWidth(),
            ) { Text(if (last) "Begin the Testimony" else "Next") }
        }

        TextButton(
            onClick = onFinish,
            modifier = Modifier.align(Alignment.TopEnd).statusBarsPadding().padding(8.dp),
        ) { Text("Skip", color = Color.White) }
    }
}
