package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.BuildConfig
import com.example.data.Testimony

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(testimony: Testimony, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About this book", style = MaterialTheme.typography.titleSmall) },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back") }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        Column(
            Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()).padding(24.dp),
        ) {
            Section(
                "What this is",
                "The Zeus Testimony is a work of speculative mythology and philosophy. It retells the formation of " +
                    "the Solar System as an epic, built around one idea: Jupiter formed first among the planets, so " +
                    "Zeus, whose name Jupiter carries, is presented as the first god of the solar realm to hold a world.",
            )
            Section(
                "Science, myth and wisdom",
                "The verses are creative writing. Commentary notes are labelled: SCIENCE notes summarise published " +
                    "research and say when an idea is a hypothesis; MYTH notes describe ancient stories; HISTORY notes " +
                    "describe real events; WISDOM notes are reflections for the reader. The book does not ask anyone " +
                    "to adopt a religion and does not claim that its narrative is scientifically proven.",
            )
            Section(
                "Key sources",
                "Kruijer et al., \"Age of Jupiter inferred from the distinct genetics and formation times of meteorites\", " +
                    "PNAS 114 (2017).\nWalsh et al., \"A low mass for Mars from Jupiter's early gas-driven migration\", " +
                    "Nature 475 (2011).\nHesiod, Theogony (c. 700 BCE).\nNASA Solar System Exploration: " +
                    "https://science.nasa.gov/jupiter/",
            )
            Section(
                "Credits",
                "Illustrations are used with the permission of their artists.\n" +
                    "Typefaces: Cinzel by Natanael Gama and Lora by Cyreal, both under the SIL Open Font License 1.1.",
            )
            Section(
                "Privacy",
                "This app collects no personal data. It has no accounts, no advertising, no analytics and no internet " +
                    "access. Your reading position, text size, bookmarks and highlights are stored only on this device.",
            )
            Text(
                "Version ${BuildConfig.VERSION_NAME} · ${testimony.volumes.size} volumes · ${testimony.chapterCount} chapters · ${testimony.verseCount} verses",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
            )
        }
    }
}

@Composable
private fun Section(title: String, body: String) {
    Text(title, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary)
    Spacer(Modifier.height(8.dp))
    Text(body, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground)
    Spacer(Modifier.height(24.dp))
}
