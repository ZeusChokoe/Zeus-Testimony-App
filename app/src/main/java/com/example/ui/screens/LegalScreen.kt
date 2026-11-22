package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private const val EFFECTIVE = "Effective 22 November 2026"

private val privacy = listOf(
    "In short" to "The Zeus Testimony collects no personal data. It has no accounts, no advertising, no analytics, " +
        "no crash reporting service and no internet permission, so it cannot send anything about you anywhere.",
    "What is stored on your device" to "To make reading comfortable, the app remembers a few things in its own private " +
        "storage on your phone: the chapter and verse you last read, your text size, the chapters you have opened, your " +
        "bookmarks and highlights, and whether you have seen the introduction. This information never leaves your device " +
        "through the app.",
    "Device backups" to "If you have turned on Android's own backup, your phone may include these reading settings in " +
        "your personal backup, so they can be restored on a new phone. That backup is controlled by you and Google, not by us.",
    "Deleting your information" to "Uninstalling the app, or clearing its storage in your phone's settings, deletes " +
        "everything listed above. Removing a bookmark or highlight in My Library deletes it immediately.",
    "Permissions" to "The app requests no special permissions: no camera, microphone, location, contacts or files. " +
        "Sharing a verse uses Android's standard share window, and you choose where it goes.",
    "Children" to "The app is not directed at children under 13, and it collects no data from anyone.",
    "Changes" to "If this policy ever changes, the new version will appear here and on the app's store page with a new date.",
    "Contact" to "Questions can be sent to the developer email address shown on the app's Google Play page.",
)

private val terms = listOf(
    "Agreement" to "By using The Zeus Testimony you agree to these terms. If you do not agree, please uninstall the app.",
    "What this book is" to "The Zeus Testimony is a creative and inspirational work. It tells the history of how the " +
        "solar system and life came to be, written in an epic style. Science and History notes summarise published " +
        "research for general education; they are simplified and may be revised as knowledge grows. Statements about the " +
        "spirit and the meaning of life are the beliefs of the author, offered for reflection. Nothing in the app is " +
        "professional, medical, legal or financial advice.",
    "Your use" to "You may read the app for personal, non-commercial purposes and share individual verses using the " +
        "share button, with credit to The Zeus Testimony. You may not copy, sell or republish the book, its illustrations " +
        "or its design as your own.",
    "Ownership" to "The text and design of the app belong to Zeus Factor. The illustrations are used with the permission " +
        "of their artists and remain their property. The Cinzel and Lora typefaces are used under the SIL Open Font License 1.1.",
    "No warranty" to "The app is provided as it is. We work to keep it accurate and working, but we cannot promise it will " +
        "be free of errors, and we are not liable for losses arising from its use, to the extent the law allows.",
    "Changes" to "We may update the app and these terms. Continued use after an update means you accept the updated terms.",
    "Law" to "These terms are governed by the laws of the Republic of South Africa.",
    "Contact" to "Questions can be sent to the developer email address shown on the app's Google Play page.",
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LegalScreen(onBack: () -> Unit) {
    var tab by rememberSaveable { mutableIntStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Privacy and Terms", style = MaterialTheme.typography.titleSmall) },
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
                Tab(selected = tab == 0, onClick = { tab = 0 }, text = { Text("Privacy Policy") })
                Tab(selected = tab == 1, onClick = { tab = 1 }, text = { Text("Terms of Use") })
            }
            Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp)) {
                Text(EFFECTIVE, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
                Spacer(Modifier.height(16.dp))
                (if (tab == 0) privacy else terms).forEach { (heading, body) ->
                    Text(heading, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary)
                    Spacer(Modifier.height(6.dp))
                    Text(body, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground)
                    Spacer(Modifier.height(20.dp))
                }
            }
        }
    }
}
