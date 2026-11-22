package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.FormatColorReset
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.TextDecrease
import androidx.compose.material.icons.filled.TextIncrease
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.Chapter
import com.example.data.HighlightColor
import com.example.data.LibraryStore
import com.example.data.Note
import com.example.data.NoteKind
import com.example.data.Position
import com.example.data.ReadingPrefs
import com.example.data.Testimony
import com.example.data.Verse
import com.example.data.VerseRef
import com.example.data.Volume
import com.example.ui.components.AssetImage

/** LazyColumn items before the first verse: illustration, then title block. */
private const val HEADER_ITEMS = 2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterScreen(
    testimony: Testimony,
    library: LibraryStore,
    position: Position,
    focusVerse: Int,
    textScale: Float,
    onTextScaleChange: (Float) -> Unit,
    onRead: (Position) -> Unit,
    onNavigate: (Position) -> Unit,
    onBack: () -> Unit,
) {
    val volume = testimony.volume(position.volume)
    val chapter = testimony.chapter(position)
    val listState = rememberLazyListState()
    var selected by remember { mutableStateOf<Verse?>(null) }

    if (chapter != null) {
        LaunchedEffect(position) { onRead(position) }
        LaunchedEffect(position, focusVerse) {
            if (focusVerse in 1..chapter.verses.size) listState.scrollToItem(HEADER_ITEMS + focusVerse - 1)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (volume != null && chapter != null) "Vol. ${volume.numeral} · Ch. ${chapter.number}" else "",
                        style = MaterialTheme.typography.titleSmall,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back") }
                },
                actions = {
                    IconButton(
                        onClick = { onTextScaleChange(textScale - 0.1f) },
                        enabled = textScale > ReadingPrefs.MIN_SCALE + 0.01f,
                    ) { Icon(Icons.Filled.TextDecrease, contentDescription = "Smaller text") }
                    IconButton(
                        onClick = { onTextScaleChange(textScale + 0.1f) },
                        enabled = textScale < ReadingPrefs.MAX_SCALE - 0.01f,
                    ) { Icon(Icons.Filled.TextIncrease, contentDescription = "Larger text") }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        if (volume == null || chapter == null) {
            NotFound(Modifier.padding(padding))
            return@Scaffold
        }
        val verseStyle = MaterialTheme.typography.bodyLarge.scaled(textScale)
        val noteStyle = MaterialTheme.typography.bodyMedium.scaled(textScale)

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(bottom = 32.dp),
        ) {
            item {
                AssetImage(
                    path = chapter.image ?: volume.image,
                    contentDescription = "Illustration for ${chapter.title}",
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                ) {
                    Text("${volume.numeral} · ${chapter.number}", style = MaterialTheme.typography.titleLarge, color = Color.White)
                }
            }
            item { ChapterTitle(volume, chapter) }
            items(chapter.verses, key = { it.number }) { verse ->
                val ref = VerseRef(position.volume, position.chapter, verse.number)
                VerseBlock(
                    verse = verse,
                    highlight = library.highlight(ref),
                    bookmarked = library.isBookmarked(ref),
                    focused = verse.number == focusVerse,
                    verseStyle = verseStyle,
                    noteStyle = noteStyle,
                    onClick = { selected = verse },
                )
            }
            item {
                ChapterNav(
                    previous = testimony.previous(position),
                    next = testimony.next(position),
                    labelFor = { p -> testimony.chapter(p)?.title.orEmpty() },
                    onNavigate = onNavigate,
                )
            }
        }

        selected?.let { verse ->
            VerseActionsSheet(
                ref = VerseRef(position.volume, position.chapter, verse.number),
                verse = verse,
                reference = "${volume.title}, Chapter ${chapter.number}, Verse ${verse.number}",
                library = library,
                onDismiss = { selected = null },
            )
        }
    }
}

@Composable
private fun ChapterTitle(volume: Volume, chapter: Chapter) {
    Column(Modifier.fillMaxWidth().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            "${volume.title.uppercase()} · CHAPTER ${chapter.number}",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(8.dp))
        Text(chapter.title, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onBackground, textAlign = TextAlign.Center)
        chapter.epigraph?.let {
            Spacer(Modifier.height(12.dp))
            Text(
                it,
                style = MaterialTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic),
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                textAlign = TextAlign.Center,
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(
            "Tap any verse to bookmark, highlight or share it.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.45f),
            textAlign = TextAlign.Center,
        )
    }
}

private fun TextStyle.scaled(scale: Float) = copy(
    fontSize = if (fontSize != TextUnit.Unspecified) fontSize * scale else fontSize,
    lineHeight = if (lineHeight != TextUnit.Unspecified) lineHeight * scale else lineHeight,
)

@Composable
private fun VerseBlock(
    verse: Verse,
    highlight: HighlightColor?,
    bookmarked: Boolean,
    focused: Boolean,
    verseStyle: TextStyle,
    noteStyle: TextStyle,
    onClick: () -> Unit,
) {
    val wash = highlight?.let { Color(it.argb).copy(alpha = 0.22f) } ?: Color.Transparent
    Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 2.dp)) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(wash)
                .then(if (focused) Modifier.border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp)) else Modifier)
                .clickable(onClick = onClick)
                .semantics { contentDescription = "Verse ${verse.number}" }
                .padding(horizontal = 8.dp, vertical = 6.dp),
        ) {
            Column(Modifier.width(28.dp).padding(top = 6.dp), horizontalAlignment = Alignment.Start) {
                Text("${verse.number}", style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp), color = MaterialTheme.colorScheme.primary)
                if (bookmarked) {
                    Icon(Icons.Filled.Bookmark, contentDescription = "Bookmarked", tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(14.dp))
                }
            }
            Text(verse.text, style = verseStyle, color = MaterialTheme.colorScheme.onBackground)
        }
        verse.notes.forEach { NoteBlock(it, noteStyle) }
    }
}

@Composable
private fun NoteBlock(note: Note, style: TextStyle) {
    val accent = when (note.kind) {
        NoteKind.SCIENCE -> Color(0xFF3D7BD9)
        NoteKind.WISDOM -> Color(0xFFC9A227)
        NoteKind.MYTH -> MaterialTheme.colorScheme.primary
        NoteKind.HISTORY -> Color(0xFF7A9A5B)
        NoteKind.NOTE -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    }
    Row(
        Modifier
            .padding(start = 36.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .height(IntrinsicSize.Min),
    ) {
        Box(Modifier.width(4.dp).fillMaxHeight().background(accent))
        Column(Modifier.padding(12.dp)) {
            Text(note.kind.label.uppercase(), style = MaterialTheme.typography.labelSmall, color = accent)
            Spacer(Modifier.height(4.dp))
            Text(note.text, style = style, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun VerseActionsSheet(
    ref: VerseRef,
    verse: Verse,
    reference: String,
    library: LibraryStore,
    onDismiss: () -> Unit,
) {
    val context = LocalContext.current
    val shareText = "\"${verse.text}\"\n$reference\nThe Zeus Testimony"
    ModalBottomSheet(onDismissRequest = onDismiss, containerColor = MaterialTheme.colorScheme.surface) {
        Column(Modifier.fillMaxWidth().padding(horizontal = 24.dp).padding(bottom = 32.dp)) {
            Text(reference.uppercase(), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.height(8.dp))
            Text(verse.text, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface)
            Spacer(Modifier.height(20.dp))

            val bookmarked = library.isBookmarked(ref)
            FilledTonalButton(onClick = { library.toggleBookmark(ref) }, modifier = Modifier.fillMaxWidth()) {
                Icon(if (bookmarked) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text(if (bookmarked) "Remove bookmark" else "Bookmark for later")
            }

            Spacer(Modifier.height(20.dp))
            Text("HIGHLIGHT", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f))
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(14.dp), verticalAlignment = Alignment.CenterVertically) {
                val current = library.highlight(ref)
                HighlightColor.entries.forEach { color ->
                    Box(
                        Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(color.argb))
                            .then(if (current == color) Modifier.border(3.dp, MaterialTheme.colorScheme.onSurface, CircleShape) else Modifier)
                            .clickable { library.setHighlight(ref, color) }
                            .semantics { contentDescription = "Highlight ${color.label}" },
                    )
                }
                if (current != null) {
                    IconButton(onClick = { library.setHighlight(ref, null) }) {
                        Icon(Icons.Filled.FormatColorReset, contentDescription = "Remove highlight")
                    }
                }
            }

            Spacer(Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedButton(onClick = { copy(context, shareText); onDismiss() }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Filled.ContentCopy, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Copy")
                }
                OutlinedButton(onClick = { share(context, shareText); onDismiss() }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Filled.Share, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Share")
                }
            }
        }
    }
}

private fun copy(context: Context, text: String) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager ?: return
    clipboard.setPrimaryClip(ClipData.newPlainText("Zeus Testimony verse", text))
    Toast.makeText(context, "Verse copied", Toast.LENGTH_SHORT).show()
}

private fun share(context: Context, text: String) {
    val send = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    runCatching { context.startActivity(Intent.createChooser(send, "Share verse").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)) }
}

@Composable
private fun ChapterNav(
    previous: Position?,
    next: Position?,
    labelFor: (Position) -> String,
    onNavigate: (Position) -> Unit,
) {
    Column(Modifier.fillMaxWidth().padding(24.dp)) {
        HorizontalDivider(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f))
        Spacer(Modifier.height(16.dp))
        if (next != null) {
            Button(onClick = { onNavigate(next) }, modifier = Modifier.fillMaxWidth()) {
                Text("Next: ${labelFor(next)}", maxLines = 1)
            }
        } else {
            Text(
                "Here ends the Zeus Testimony.",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        if (previous != null) {
            Spacer(Modifier.height(8.dp))
            OutlinedButton(onClick = { onNavigate(previous) }, modifier = Modifier.fillMaxWidth()) {
                Text("Previous: ${labelFor(previous)}", maxLines = 1)
            }
        }
    }
}
