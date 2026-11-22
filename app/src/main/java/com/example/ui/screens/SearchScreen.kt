package com.example.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.data.Testimony
import com.example.data.VerseRef

private data class Hit(val ref: VerseRef, val reference: String, val text: String)

private const val MAX_RESULTS = 150

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(testimony: Testimony, onOpenVerse: (VerseRef) -> Unit, onBack: () -> Unit) {
    var query by rememberSaveable { mutableStateOf("") }
    val focus = remember { FocusRequester() }
    LaunchedEffect(Unit) { runCatching { focus.requestFocus() } }

    val q = query.trim()
    val hits = remember(q) {
        if (q.length < 2) emptyList()
        else buildList {
            for (vol in testimony.volumes) for (ch in vol.chapters) for (verse in ch.verses) {
                val inNotes = verse.notes.any { it.text.contains(q, ignoreCase = true) }
                if (verse.text.contains(q, ignoreCase = true) || ch.title.contains(q, ignoreCase = true) || inNotes) {
                    add(Hit(VerseRef(vol.index, ch.index, verse.number), "Vol. ${vol.numeral} · Ch. ${ch.number} · ${ch.title} · Verse ${verse.number}", verse.text))
                    if (size >= MAX_RESULTS) return@buildList
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Search the Testimony", style = MaterialTheme.typography.titleSmall) },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back") }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it.take(80) },
                singleLine = true,
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
                placeholder = { Text("Try Europa, lightning, Kronos, wisdom...") },
                modifier = Modifier.fillMaxWidth().padding(16.dp).focusRequester(focus),
            )
            if (q.length >= 2) {
                Text(
                    if (hits.size >= MAX_RESULTS) "Showing the first $MAX_RESULTS results" else "${hits.size} results",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                    modifier = Modifier.padding(horizontal = 20.dp),
                )
            }
            LazyColumn(contentPadding = PaddingValues(vertical = 8.dp)) {
                items(hits, key = { it.ref.key }) { hit ->
                    Column(Modifier.fillMaxWidth().clickable { onOpenVerse(hit.ref) }.padding(horizontal = 20.dp, vertical = 12.dp)) {
                        Text(hit.reference, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary, maxLines = 1, overflow = TextOverflow.Ellipsis)
                        Spacer(Modifier.height(4.dp))
                        Text(emphasise(hit.text, q), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground, maxLines = 3, overflow = TextOverflow.Ellipsis)
                    }
                    HorizontalDivider(Modifier.padding(horizontal = 20.dp), color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.08f))
                }
            }
        }
    }
}

@Composable
private fun emphasise(text: String, q: String) = buildAnnotatedString {
    var start = 0
    val color = MaterialTheme.colorScheme.primary
    while (true) {
        val i = text.indexOf(q, start, ignoreCase = true)
        if (i < 0) { append(text.substring(start)); break }
        append(text.substring(start, i))
        withStyle(SpanStyle(color = color, fontWeight = FontWeight.Bold)) { append(text.substring(i, i + q.length)) }
        start = i + q.length
    }
}
