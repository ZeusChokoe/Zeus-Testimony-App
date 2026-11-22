package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.remember
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.LibraryStore
import com.example.data.NoteKind
import com.example.data.Position
import com.example.data.VerseRef
import com.example.data.Testimony
import com.example.data.Volume
import com.example.ui.components.AssetImage

@Composable
fun HomeScreen(
    testimony: Testimony,
    library: LibraryStore,
    lastRead: Position?,
    onOpenVerse: (VerseRef) -> Unit,
    onSearch: () -> Unit,
    onLibrary: () -> Unit,
    onOpenVolume: (Int) -> Unit,
    onOpenChapter: (Position) -> Unit,
    onAbout: () -> Unit,
) {
    Scaffold(containerColor = MaterialTheme.colorScheme.background) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = padding.calculateBottomPadding() + 32.dp),
        ) {
            item { Hero(testimony, topInset = padding.calculateTopPadding(), onSearch = onSearch, onLibrary = onLibrary, onAbout = onAbout) }

            val resume = lastRead?.let { p -> testimony.chapter(p)?.let { p to it } }
            item {
                val (position, chapter) = resume ?: (Position(0, 0) to testimony.chapter(Position(0, 0)))
                if (chapter != null) {
                    val vol = testimony.volumes[position.volume]
                    Card(
                        onClick = { onOpenChapter(position) },
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 16.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
                    ) {
                        Row(Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = null, tint = Color.White)
                            Spacer(Modifier.width(16.dp))
                            Column {
                                Text(
                                    if (resume != null) "CONTINUE READING" else "BEGIN THE TESTIMONY",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White.copy(alpha = 0.85f),
                                )
                                Text(
                                    "Volume ${vol.numeral} · Chapter ${chapter.number}: ${chapter.title}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.White,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                        }
                    }
                }
            }

            item { VerseOfTheDay(testimony, onOpenVerse) }

            item {
                Text(
                    "The Volumes",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                )
            }
            items(testimony.volumes, key = { it.index }) { volume ->
                VolumeCard(volume, read = library.readCount(volume), onClick = { onOpenVolume(volume.index) })
            }
            item {
                Text(
                    "A work of speculative mythology inspired by real planetary science. " +
                        "Commentary notes mark what is established science, what is hypothesis, and what is myth.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(24.dp),
                )
            }
        }
    }
}

@Composable
private fun Hero(
    testimony: Testimony,
    topInset: androidx.compose.ui.unit.Dp,
    onSearch: () -> Unit,
    onLibrary: () -> Unit,
    onAbout: () -> Unit,
) {
    Box(Modifier.fillMaxWidth().height(320.dp + topInset)) {
        AssetImage(path = "hero.webp", contentDescription = null, modifier = Modifier.fillMaxSize())
        Box(
            Modifier.fillMaxSize().background(
                Brush.verticalGradient(listOf(Color.Black.copy(alpha = 0.25f), Color.Black.copy(alpha = 0.55f), MaterialTheme.colorScheme.background)),
            ),
        )
        Row(Modifier.align(Alignment.TopEnd).padding(top = topInset, end = 8.dp)) {
            IconButton(onClick = onSearch) { Icon(Icons.Outlined.Search, contentDescription = "Search", tint = Color.White) }
            IconButton(onClick = onLibrary) { Icon(Icons.Outlined.Bookmarks, contentDescription = "My Library", tint = Color.White) }
            IconButton(onClick = onAbout) { Icon(Icons.Outlined.Info, contentDescription = "About this book", tint = Color.White) }
        }
        Column(
            Modifier.fillMaxSize().padding(top = topInset).padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.zeus_icon_transparent),
                contentDescription = null,
                modifier = Modifier.size(72.dp),
            )
            Spacer(Modifier.height(16.dp))
            Text("THE ZEUS TESTIMONY", style = MaterialTheme.typography.titleLarge, color = Color.White, textAlign = TextAlign.Center)
            Spacer(Modifier.height(8.dp))
            Text(
                "THE FIRSTBORN OF THE SOLAR REALM",
                style = MaterialTheme.typography.labelSmall,
                color = Color.White.copy(alpha = 0.85f),
            )
            Spacer(Modifier.height(12.dp))
            Text(
                "${testimony.volumes.size} volumes · ${testimony.chapterCount} chapters · ${testimony.verseCount} verses",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White.copy(alpha = 0.75f),
            )
        }
    }
}

@Composable
private fun VolumeCard(volume: Volume, read: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    ) {
        Row(Modifier.height(IntrinsicSize.Min)) {
            AssetImage(
                path = volume.image,
                contentDescription = null,
                modifier = Modifier.width(104.dp).fillMaxHeight().defaultMinSize(minHeight = 124.dp),
            ) {
                Text(volume.numeral, style = MaterialTheme.typography.titleLarge, color = Color.White)
            }
            Column(Modifier.weight(1f).padding(16.dp)) {
                Text(
                    "VOLUME ${volume.numeral} · ${volume.chapters.size} CHAPTERS",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(4.dp))
                Text(volume.title, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.onSurface)
                Spacer(Modifier.height(4.dp))
                Text(
                    volume.subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                if (read > 0) {
                    Spacer(Modifier.height(10.dp))
                    LinearProgressIndicator(
                        progress = { read.toFloat() / volume.chapters.size },
                        modifier = Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(2.dp)),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        if (read == volume.chapters.size) "Completed" else "$read of ${volume.chapters.size} chapters read",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    )
                }
            }
        }
    }
}

/** One verse that carries a Wisdom note, chosen by the date so it changes every day. */
@Composable
private fun VerseOfTheDay(testimony: Testimony, onOpenVerse: (VerseRef) -> Unit) {
    val pick = remember(testimony) {
        val pool = testimony.volumes.flatMap { v ->
            v.chapters.flatMap { c ->
                c.verses.filter { verse -> verse.notes.any { it.kind == NoteKind.WISDOM } }
                    .map { Triple(VerseRef(v.index, c.index, it.number), it, "Volume ${v.numeral} · ${c.title}") }
            }
        }
        if (pool.isEmpty()) null else pool[((System.currentTimeMillis() / 86_400_000L) % pool.size).toInt()]
    } ?: return
    val (ref, verse, where) = pick
    val wisdom = verse.notes.first { it.kind == NoteKind.WISDOM }.text
    Card(
        onClick = { onOpenVerse(ref) },
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    ) {
        Column(Modifier.padding(20.dp)) {
            Text("VERSE OF THE DAY", style = MaterialTheme.typography.labelSmall, color = Color(0xFFC9A227))
            Spacer(Modifier.height(10.dp))
            Text("\u201C${verse.text}\u201D", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface)
            Spacer(Modifier.height(10.dp))
            Text(wisdom, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f))
            Spacer(Modifier.height(10.dp))
            Text(where, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
        }
    }
}
