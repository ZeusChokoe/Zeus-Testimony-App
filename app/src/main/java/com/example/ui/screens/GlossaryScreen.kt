package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** The book's own names, explained plainly. */
val GLOSSARY = listOf(
    "The Firstborn" to "Jupiter, the largest planet and, by the evidence of meteorites, the first planet to form in our solar system. Also called the king.",
    "Zeus, the Sky Father" to "The chief god of the Greeks, whose name Jupiter carries. Romans called him Iuppiter, Jupiter. Sky Father is the meaning of the ancient root of his name.",
    "The Source" to "The unnamed origin above all things, before the first light. The book does not name or describe it.",
    "Helios, the hearth" to "The Sun. Helios was the Greek god of the Sun; the book also calls the Sun a hearth, the fire around which the house of planets was built.",
    "The disk" to "The flat, spinning cloud of gas and dust around the young Sun, from which all the planets formed.",
    "The frost line" to "The distance from the young Sun beyond which water froze into ice. Planets could gather more material beyond it.",
    "The wall, the two treasuries" to "Young Jupiter kept the inner and outer parts of the disk apart. Meteorites still show two families of material, one from each side.",
    "The court, the daughters" to "Jupiter's moons, especially the four large ones found by Galileo: Io, Europa, Ganymede and Callisto.",
    "The crown" to "Jupiter's magnetic field and magnetosphere, the largest structure in the solar system.",
    "The red eye" to "The Great Red Spot, a giant storm on Jupiter watched since 1831.",
    "The shield, the Aegis" to "Jupiter's gravity, which captures or flings away many comets and asteroids. The Aegis was the shield of Zeus in Greek myth.",
    "Gaia" to "The Earth. Gaia was the Greek goddess of the Earth.",
    "Theia" to "The Mars-sized world thought to have struck the young Earth, forming the Moon.",
    "The watchers" to "Astronomers, professional and amateur, from Babylon to today.",
    "The messengers" to "Spacecraft such as Pioneer, Voyager, Galileo, Juno, JUICE and Europa Clipper.",
    "The seals" to "One hidden verse per volume, revealed when every chapter of that volume has been read.",
    "Science, History and Wisdom notes" to "Science notes summarise research and say when an idea is debated. History notes describe real people and events. Wisdom notes are reflections for the reader.",
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GlossaryScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Glossary", style = MaterialTheme.typography.titleSmall) },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back") }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        LazyColumn(Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(24.dp)) {
            items(GLOSSARY, key = { it.first }) { (term, meaning) ->
                Text(term, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary)
                Spacer(Modifier.height(4.dp))
                Text(meaning, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground)
                Spacer(Modifier.height(20.dp))
            }
        }
    }
}
