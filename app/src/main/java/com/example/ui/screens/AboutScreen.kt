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
fun AboutScreen(testimony: Testimony, onShowIntro: () -> Unit, onLegal: () -> Unit, onGlossary: () -> Unit = {}, onBack: () -> Unit) {
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
                "The Zeus Testimony is an epic history of how everything around you became: the first light, the cloud " +
                    "before the Sun, Jupiter the first and undying world, the forging of the Earth, the rise of life, and " +
                    "finally you, made of the same star-forged elements. It is written in the voice of a testimony, to " +
                    "inspire as well as to teach.",
            )
            Section(
                "Science, history and wisdom",
                "The verses are creative writing. Beneath them, SCIENCE notes summarise published research and say when an " +
                    "idea is still debated; HISTORY notes describe real people and events; WISDOM notes are reflections for " +
                    "your own life. Statements about the spirit are the author's beliefs, offered for reflection.",
            )
            Section(
                "Key sources",
                "Kruijer et al., \"Age of Jupiter inferred from the distinct genetics and formation times of meteorites\", " +
                    "PNAS 114 (2017).\nWalsh et al., \"A low mass for Mars from Jupiter's early gas-driven migration\", " +
                    "Nature 475 (2011).\nLaskar and Gastineau, \"Existence of collisional trajectories of Mercury, Mars and " +
                    "Venus with the Earth\", Nature 459 (2009).\nNASA Solar System Exploration: https://science.nasa.gov/jupiter/",
            )
            Section(
                "Credits",
                "Published by Zeus Factor, South Africa. Contact: $SUPPORT_EMAIL\n" +
                    "Illustrations are used with the permission of their artists.\n" +
                    "Typefaces: Cinzel by Natanael Gama and Lora by Cyreal, both under the SIL Open Font License 1.1.",
            )
            Section(
                "Privacy",
                "This app collects no personal data. It has no accounts, no advertising, no analytics and no internet " +
                    "access. Your reading position, text size, bookmarks, highlights and reading history are stored only " +
                    "on this device, and are deleted when you uninstall the app.",
            )
            OutlinedButton(onClick = onGlossary) { Text("Glossary of names") }
            Spacer(Modifier.height(8.dp))
            OutlinedButton(onClick = onLegal) { Text("Privacy Policy and Terms of Use") }
            Spacer(Modifier.height(8.dp))
            OutlinedButton(onClick = onShowIntro) { Text("Show the introduction again") }
            Spacer(Modifier.height(24.dp))
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
