package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.Book
import com.example.data.Verse
import com.example.data.VerseRepository
import com.example.data.Volume

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderScreen(
    volumeId: String,
    onNavigateBack: () -> Unit
) {
    val volume = VerseRepository.volumes.find { it.id == volumeId }
    
    var selectedVerse by remember { mutableStateOf<Verse?>(null) }
    var showBottomSheet by remember { mutableStateOf(false) }

    if (volume == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Volume not found.", color = MaterialTheme.colorScheme.onBackground)
        }
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = "${volume.title}: ${volume.subtitle}", 
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack, 
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
            
            volume.books.forEach { book ->
                item {
                    Text(
                        text = book.title.uppercase(),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 40.dp)
                    )
                }
                
                book.chapters.forEach { chapter ->
                    item {
                        Text(
                            text = chapter.title,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 24.dp, top = 16.dp)
                        )
                    }
                    
                    items(chapter.verses) { verse ->
                        VerseItem(
                            verse = verse,
                            onClick = {
                                if (verse.scientificEquivalentId != null) {
                                    selectedVerse = VerseRepository.getVerse(verse.scientificEquivalentId)
                                    showBottomSheet = true
                                }
                            }
                        )
                    }
                    
                    item {
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                }
                
                item {
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f)
                    )
                }
            }
            
            item {
                Spacer(modifier = Modifier.height(64.dp))
            }
        }

        if (showBottomSheet && selectedVerse != null) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                ) {
                    Text(
                        text = "The Scientific Revelation",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Row(verticalAlignment = Alignment.Top) {
                        Text(
                            text = "${selectedVerse!!.verseNum}",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(end = 12.dp, top = 4.dp)
                        )
                        Text(
                            text = selectedVerse!!.text,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier.height(48.dp))
                }
            }
        }
    }
}

@Composable
fun VerseItem(verse: Verse, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = "${verse.verseNum}",
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(end = 16.dp, top = 8.dp)
        )
        Text(
            text = verse.text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
