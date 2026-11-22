package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.LibraryStore
import com.example.data.Testimony
import com.example.data.VerseRef

private data class Entry(val ref: VerseRef, val reference: String, val text: String, val accent: Color?, val sortKey: Long)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(
    testimony: Testimony,
    library: LibraryStore,
    onOpenVerse: (VerseRef) -> Unit,
    onBack: () -> Unit,
) {
    var tab by rememberSaveable { mutableIntStateOf(0) }

    fun resolve(key: String, accent: Color?, sortKey: Long): Entry? {
        val ref = VerseRef.parse(key) ?: return null
        val vol = testimony.volume(ref.volume) ?: return null
        val ch = vol.chapters.getOrNull(ref.chapter) ?: return null
        val verse = ch.verses.getOrNull(ref.verse - 1) ?: return null
        return Entry(ref, "Vol. ${vol.numeral} · Ch. ${ch.number} · Verse ${verse.number} · ${ch.title}", verse.text, accent, sortKey)
    }

    val bookmarks = library.bookmarks.entries.mapNotNull { resolve(it.key, null, it.value) }.sortedByDescending { it.sortKey }
    val highlights = library.highlights.entries
        .mapNotNull { (k, c) -> VerseRef.parse(k)?.let { r -> resolve(k, Color(c.argb), -(r.volume * 1_000_000L + r.chapter * 1_000L + r.verse)) } }
        .sortedByDescending { it.sortKey }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Library", style = MaterialTheme.typography.titleSmall) },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back") }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
            TabRow(selectedTabIndex = tab, containerColor = MaterialTheme.colorScheme.background) {
                Tab(selected = tab == 0, onClick = { tab = 0 }, text = { Text("Bookmarks (${bookmarks.size})") })
                Tab(selected = tab == 1, onClick = { tab = 1 }, text = { Text("Highlights (${highlights.size})") })
            }
            val entries = if (tab == 0) bookmarks else highlights
            if (entries.isEmpty()) {
                Box(Modifier.fillMaxSize().padding(32.dp), contentAlignment = Alignment.Center) {
                    Text(
                        if (tab == 0) "No bookmarks yet.\nTap any verse while reading and choose \"Bookmark for later\"."
                        else "No highlights yet.\nTap any verse while reading and pick a colour.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                        textAlign = TextAlign.Center,
                    )
                }
            } else {
                LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(entries, key = { it.ref.key }) { e ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(MaterialTheme.colorScheme.surface)
                                .clickable { onOpenVerse(e.ref) }
                                .height(IntrinsicSize.Min),
                        ) {
                            Box(Modifier.width(5.dp).fillMaxHeight().background(e.accent ?: MaterialTheme.colorScheme.primary))
                            Column(Modifier.weight(1f).padding(14.dp)) {
                                Text(e.reference, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary, maxLines = 2, overflow = TextOverflow.Ellipsis)
                                Spacer(Modifier.height(6.dp))
                                Text(e.text, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface, maxLines = 4, overflow = TextOverflow.Ellipsis)
                            }
                            IconButton(onClick = {
                                if (tab == 0) library.toggleBookmark(e.ref) else library.setHighlight(e.ref, null)
                            }) {
                                Icon(Icons.Filled.Close, contentDescription = "Remove", tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                            }
                        }
                    }
                }
            }
        }
    }
}
