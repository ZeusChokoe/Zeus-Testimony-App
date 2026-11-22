package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.data.LibraryStore
import com.example.data.Position
import com.example.data.Volume
import com.example.ui.components.AssetImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolumeScreen(volume: Volume?, library: LibraryStore, onOpenChapter: (Position) -> Unit, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(volume?.let { "Volume ${it.numeral}" } ?: "", style = MaterialTheme.typography.titleSmall) },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back") }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        if (volume == null) {
            NotFound(Modifier.padding(padding))
            return@Scaffold
        }
        LazyColumn(Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(bottom = 32.dp)) {
            item {
                AssetImage(
                    path = volume.image,
                    contentDescription = "Illustration for ${volume.title}",
                    modifier = Modifier.fillMaxWidth().height(420.dp),
                    framed = true,
                ) {
                    Text(volume.numeral, style = MaterialTheme.typography.displaySmall, color = Color.White)
                }
            }
            item {
                Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("VOLUME ${volume.numeral}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                    Spacer(Modifier.height(8.dp))
                    Text(volume.title, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onBackground, textAlign = TextAlign.Center)
                    Spacer(Modifier.height(4.dp))
                    Text(volume.subtitle, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75f), textAlign = TextAlign.Center)
                    Spacer(Modifier.height(16.dp))
                    Text(volume.summary, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground, textAlign = TextAlign.Center)
                }
                HorizontalDivider(Modifier.padding(horizontal = 24.dp), color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f))
            }
            items(volume.chapters, key = { it.index }) { chapter ->
                ListItem(
                    modifier = Modifier
                        .clickable { onOpenChapter(Position(volume.index, chapter.index)) }
                        .padding(horizontal = 8.dp),
                    overlineContent = {
                        val read = "${volume.index}.${chapter.index}" in library.readChapters
                        Text(
                            "CHAPTER ${chapter.number}" + if (read) "  ·  READ" else "",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    },
                    headlineContent = { Text(chapter.title, style = MaterialTheme.typography.titleSmall) },
                    supportingContent = {
                        Text(
                            chapter.epigraph ?: "${chapter.verses.size} verses",
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 2,
                        )
                    },
                    colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.background),
                    trailingContent = {
                        TextButton(onClick = { onOpenChapter(Position(volume.index, chapter.index)) }) { Text("Read") }
                    },
                )
            }
            volume.seal?.let { seal ->
                item { SealCard(seal, read = library.readCount(volume), total = volume.chapters.size) }
            }
        }
    }
}

/** The volume's hidden verse: locked until every chapter has been opened. */
@Composable
private fun SealCard(seal: String, read: Int, total: Int) {
    val open = read >= total
    val gold = Color(0xFFC9A227)
    Column(
        Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, gold.copy(alpha = if (open) 0.9f else 0.35f), RoundedCornerShape(16.dp))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            if (open) Icons.Filled.LockOpen else Icons.Filled.Lock,
            contentDescription = null,
            tint = gold,
        )
        Spacer(Modifier.height(10.dp))
        Text(if (open) "THE SEAL IS BROKEN" else "A SEAL RESTS ON THIS VOLUME", style = MaterialTheme.typography.labelSmall, color = gold)
        Spacer(Modifier.height(12.dp))
        if (open) {
            Text(
                seal,
                style = MaterialTheme.typography.titleSmall.copy(fontStyle = FontStyle.Italic),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        } else {
            Text(
                "Read every chapter of this volume to break the seal ($read of $total).",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
internal fun NotFound(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("This passage could not be found.", color = MaterialTheme.colorScheme.onBackground)
    }
}
