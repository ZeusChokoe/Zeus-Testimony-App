package com.example.ui.screens

import androidx.compose.foundation.clickable
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
import com.example.data.Position
import com.example.data.Volume
import com.example.ui.components.AssetImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolumeScreen(volume: Volume?, onOpenChapter: (Position) -> Unit, onBack: () -> Unit) {
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
                    modifier = Modifier.fillMaxWidth().height(220.dp),
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
                    overlineContent = { Text("CHAPTER ${chapter.number}", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.labelSmall) },
                    headlineContent = { Text(chapter.title, style = MaterialTheme.typography.titleSmall) },
                    supportingContent = { Text("${chapter.verses.size} verses", style = MaterialTheme.typography.bodySmall) },
                    colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.background),
                    trailingContent = {
                        TextButton(onClick = { onOpenChapter(Position(volume.index, chapter.index)) }) { Text("Read") }
                    },
                )
            }
        }
    }
}

@Composable
internal fun NotFound(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("This passage could not be found.", color = MaterialTheme.colorScheme.onBackground)
    }
}
