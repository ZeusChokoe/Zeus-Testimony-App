package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.TextDecrease
import androidx.compose.material.icons.filled.TextIncrease
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.data.Note
import com.example.data.NoteKind
import com.example.data.Position
import com.example.data.ReadingPrefs
import com.example.data.Testimony
import com.example.data.Verse
import com.example.ui.components.AssetImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterScreen(
    testimony: Testimony,
    position: Position,
    textScale: Float,
    onTextScaleChange: (Float) -> Unit,
    onRead: (Position) -> Unit,
    onNavigate: (Position) -> Unit,
    onBack: () -> Unit,
) {
    val volume = testimony.volume(position.volume)
    val chapter = testimony.chapter(position)
    if (chapter != null) LaunchedEffect(position) { onRead(position) }

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

        LazyColumn(Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(bottom = 32.dp)) {
            item {
                AssetImage(
                    path = chapter.image ?: volume.image,
                    contentDescription = "Illustration for ${chapter.title}",
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                ) {
                    Text("${volume.numeral} · ${chapter.number}", style = MaterialTheme.typography.titleLarge, color = Color.White)
                }
            }
            item {
                Column(Modifier.fillMaxWidth().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "${volume.title.uppercase()} · CHAPTER ${chapter.number}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(chapter.title, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onBackground, textAlign = TextAlign.Center)
                }
            }
            items(chapter.verses, key = { it.number }) { verse ->
                VerseBlock(verse, verseStyle, noteStyle)
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
    }
}

private fun TextStyle.scaled(scale: Float) = copy(
    fontSize = if (fontSize != TextUnit.Unspecified) fontSize * scale else fontSize,
    lineHeight = if (lineHeight != TextUnit.Unspecified) lineHeight * scale else lineHeight,
)

@Composable
private fun VerseBlock(verse: Verse, verseStyle: TextStyle, noteStyle: TextStyle) {
    Column(Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 6.dp)) {
        Row(verticalAlignment = Alignment.Top) {
            Text(
                "${verse.number}",
                style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.width(28.dp).padding(top = 6.dp),
            )
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
            .padding(start = 28.dp, top = 8.dp, bottom = 8.dp)
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
