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

const val SUPPORT_EMAIL = "thezeustower@gmail.com"

private val privacy = listOf(
    "In short" to "The Zeus Testimony collects no personal data. It has no accounts, no advertising, no analytics, " +
        "no crash reporting service and no internet permission, so it cannot send anything about you anywhere.",
    "Who we are" to "The app is published by Zeus Factor, South Africa. Contact: $SUPPORT_EMAIL.",
    "What is stored on your device" to "To make reading comfortable, the app remembers a few things in its own private " +
        "storage on your phone: the chapter and verse you last read, your text size, the chapters you have opened, your " +
        "bookmarks and highlights, and whether you have seen the introduction. This information never leaves your device " +
        "through the app, and we cannot see it.",
    "What we do not collect" to "We do not collect your name, email address, phone number, location, contacts, photos, " +
        "device identifiers, advertising identifiers, usage statistics or any other information about you.",
    "Device backups" to "If you have turned on Android's own backup, your phone may include these reading settings in " +
        "your personal backup, so they can be restored on a new phone. That backup is controlled by you and Google, not by us.",
    "Deleting your information" to "Uninstalling the app, or clearing its storage in your phone's settings, deletes " +
        "everything listed above. Removing a bookmark or highlight in My Library deletes it immediately.",
    "Permissions" to "The app requests no special permissions: no camera, microphone, location, contacts or files. " +
        "Sharing a verse, as text or as an image, uses Android's standard share window, and you choose where it goes. " +
        "A shared image is made on your phone and kept only in the app's private cache.",
    "Listen mode" to "Reading aloud uses the text-to-speech voice already installed on your phone. The app sends the " +
        "chapter text to that voice on your device and records nothing.",
    "Third parties" to "The app contains no third-party advertising, analytics or tracking code. Google Play, which " +
        "delivers the app, has its own privacy policy.",
    "Children" to "The app is not directed at children under 13, and it collects no data from anyone.",
    "Your rights" to "Because we hold no personal information about you, there is nothing for us to access, correct or " +
        "delete on your behalf. South Africa's Protection of Personal Information Act (POPIA) and similar laws are " +
        "respected by design: no personal information is processed.",
    "Changes" to "If this policy ever changes, the new version will appear here and on the app's store page with a new date.",
    "Contact" to "Questions about privacy: $SUPPORT_EMAIL.",
)

private val terms = listOf(
    "1. Agreement" to "These Terms of Use are an agreement between you and Zeus Factor, the publisher of The Zeus " +
        "Testimony (the \"app\"). By installing or using the app you accept these terms. If you do not accept them, " +
        "please uninstall the app.",
    "2. Who may use the app" to "The app is intended for readers aged 13 and older. If you are under the age of " +
        "majority where you live, use it with the permission of a parent or guardian.",
    "3. What this book is" to "The Zeus Testimony is a literary, poetic and educational work. It tells the history of " +
        "how the solar system, the Earth and life came to be, in the voice of an ancient testimony. It draws on published " +
        "science, recorded history and the myths and sacred stories of many peoples.",
    "4. Science and history notes" to "Science and History notes summarise research and historical sources for general " +
        "education. They are simplified, may be incomplete, and may be revised as knowledge grows. They are not a " +
        "substitute for the original sources, which are listed in the About screen where relevant.",
    "5. Faith, myth and meaning" to "The app speaks of gods, of the Sky Father and of the spirit. These passages express " +
        "the author's beliefs and the traditions of the peoples they come from, offered for reflection and study. They " +
        "are not presented as scientific findings, and the app does not require any reader to adopt any belief or " +
        "religion. Readers of every faith and of none are welcome.",
    "6. Not professional advice" to "Nothing in the app is medical, psychological, legal, financial or other " +
        "professional advice. Seek a qualified professional for such matters.",
    "7. Your licence" to "Zeus Factor grants you a personal, non-exclusive, non-transferable, revocable licence to " +
        "install the app on devices you own or control and to read it for personal, non-commercial purposes.",
    "8. Sharing" to "You may share individual verses using the app's share and copy buttons for personal, non-commercial " +
        "purposes, provided you credit \"The Zeus Testimony\" and do not alter the words in a way that changes their meaning.",
    "9. What you may not do" to "You may not copy, publish, sell, rent or distribute the book as a whole or in substantial " +
        "parts; extract, reuse or resell its illustrations; decompile, modify or create derivative versions of the app; " +
        "remove credits or notices; or use the app in any way that breaks the law.",
    "10. Ownership" to "The text, structure and design of the app are owned by Zeus Factor. The illustrations are used " +
        "with the permission of their artists and remain their property. The Cinzel and Lora typefaces are used under the " +
        "SIL Open Font License 1.1. Names of gods, peoples and historical figures belong to the common heritage of humanity.",
    "11. Your data" to "The app collects no personal data. Everything it remembers is stored only on your device. See " +
        "the Privacy Policy tab for details.",
    "12. Availability and changes" to "We may update, change, add to or remove content or features of the app at any " +
        "time, and we may stop offering the app. Updates are delivered through Google Play.",
    "13. No warranty" to "The app is provided \"as is\" and \"as available\". To the fullest extent the law allows, " +
        "we make no promise that it will be free of errors or interruptions, or that its content is complete or current.",
    "14. Limitation of liability" to "To the fullest extent the law allows, Zeus Factor is not liable for any indirect, " +
        "incidental or consequential loss arising from your use of the app. Nothing in these terms limits any rights you " +
        "have that cannot be limited by law, including your rights under South Africa's Consumer Protection Act where it applies.",
    "15. Google Play" to "Your download of the app is also subject to the Google Play Terms of Service. Google is not " +
        "responsible for the app or its content.",
    "16. Ending these terms" to "You may stop using the app at any time by uninstalling it. Your licence ends " +
        "automatically if you break these terms.",
    "17. General" to "If any part of these terms is found unenforceable, the rest remains in effect. These terms are " +
        "the whole agreement between you and us about the app.",
    "18. Governing law" to "These terms are governed by the laws of the Republic of South Africa, and the courts of " +
        "South Africa have jurisdiction over any dispute.",
    "19. Contact" to "Questions about these terms: $SUPPORT_EMAIL.",
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
