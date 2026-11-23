package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.Chapter
import com.example.data.Position
import com.example.data.Testimony

/** Eras of the timeline, by years from now (negative = past). */
private val ERAS = listOf(
    -4.58e9 to "Before the Sun",
    -4.5e9 to "The Birth of the Solar System",
    -3.0e9 to "The Young Earth",
    -10_000.0 to "The Long Ages of Life",
    -1.0 to "The Human Story",
    1.0 to "The Present",
    Double.MAX_VALUE to "The Future",
)

private fun eraOf(years: Double): String = ERAS.first { years < it.first }.second

private sealed interface Row {
    data class Era(val name: String) : Row
    data class Item(val chapter: Chapter, val volumeNumeral: String) : Row
}

/** Every chapter of the book placed on one line of time, from the first light to the last. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimelineScreen(testimony: Testimony, onOpenChapter: (Position) -> Unit, onBack: () -> Unit) {
    val rows = remember(testimony) {
        val sorted = testimony.volumes.flatMap { v -> v.chapters.map { it to v.numeral } }
            .filter { it.first.whenYears != null }
            .sortedWith(compareBy({ it.first.whenYears }, { it.first.volumeIndex }, { it.first.index }))
        buildList {
            var era: String? = null
            for ((chapter, numeral) in sorted) {
                val e = eraOf(chapter.whenYears!!)
                if (e != era) { add(Row.Era(e)); era = e }
                add(Row.Item(chapter, numeral))
            }
        }
    }
    val gold = Color(0xFFC9A227)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Timeline", style = MaterialTheme.typography.titleSmall) },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back") }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        LazyColumn(Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(bottom = 32.dp)) {
            item {
                Text(
                    "Every chapter in the order it happens, from the first light of the universe to the last.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
                )
            }
            items(rows, key = { r -> if (r is Row.Item) "c${r.chapter.volumeIndex}.${r.chapter.index}" else "e${(r as Row.Era).name}" }) { row ->
                when (row) {
                    is Row.Era -> Text(
                        row.name.uppercase(),
                        style = MaterialTheme.typography.labelSmall,
                        color = gold,
                        modifier = Modifier.padding(start = 24.dp, top = 24.dp, bottom = 8.dp),
                    )
                    is Row.Item -> Row(
                        Modifier
                            .fillMaxWidth()
                            .clickable { onOpenChapter(Position(row.chapter.volumeIndex, row.chapter.index)) }
                            .padding(horizontal = 24.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.Top,
                    ) {
                        Box(
                            Modifier.padding(top = 6.dp).size(10.dp).clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary),
                        )
                        Spacer(Modifier.width(16.dp))
                        Column(Modifier.weight(1f)) {
                            Text(row.chapter.whenLabel.orEmpty(), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                            Text(row.chapter.title, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground, maxLines = 2, overflow = TextOverflow.Ellipsis)
                            Text(
                                "Volume ${row.volumeNumeral} · Chapter ${row.chapter.number}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.55f),
                            )
                        }
                    }
                }
            }
        }
    }
}
