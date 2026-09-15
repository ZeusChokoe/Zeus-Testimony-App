package com.example.data

data class Verse(
    val id: String,
    val book: String,
    val chapter: String,
    val verseNum: Int,
    val text: String,
    val scientificEquivalentId: String? = null
)

data class Chapter(
    val title: String,
    val verses: List<Verse>
)

data class Book(
    val title: String,
    val chapters: List<Chapter>
)

data class Volume(
    val id: String,
    val title: String,
    val subtitle: String,
    val description: String,
    val books: List<Book>
)

object VerseRepository {

    val allVerses = listOf(
        Verse(
            id = "vol_1_GenesisofChaos_Chapter1_1",
            book = "Genesis of Chaos",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "In the beginning, Chaos was the first of all, a dark and yawning void.",
            scientificEquivalentId = "vol_2_GenesisofChaos_Chapter1_1"
        ),
        Verse(
            id = "vol_1_GenesisofChaos_Chapter1_2",
            book = "Genesis of Chaos",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "Out of Chaos came forth Erebus and black Night, filling the abyss with shadows.",
            scientificEquivalentId = "vol_2_GenesisofChaos_Chapter1_2"
        ),
        Verse(
            id = "vol_1_GenesisofChaos_Chapter1_3",
            book = "Genesis of Chaos",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "Then Gaia, the broad-bosomed Earth, arose, a sure foundation for all things.",
            scientificEquivalentId = "vol_2_GenesisofChaos_Chapter1_3"
        ),
        Verse(
            id = "vol_1_GenesisofChaos_Chapter1_4",
            book = "Genesis of Chaos",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "And Uranus, the starry Heaven, covered her completely, equal to her in every way.",
            scientificEquivalentId = "vol_2_GenesisofChaos_Chapter1_4"
        ),
        Verse(
            id = "vol_1_TheSuccession_Chapter1_1",
            book = "The Succession",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "But Uranus hated his children, hiding them away in the dark places of Earth.",
            scientificEquivalentId = "vol_2_TheSuccession_Chapter1_1"
        ),
        Verse(
            id = "vol_1_TheSuccession_Chapter1_2",
            book = "The Succession",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "Cronus, the wily and terrible, arose to overthrow his father with a sickle of flint.",
            scientificEquivalentId = "vol_2_TheSuccession_Chapter1_2"
        ),
        Verse(
            id = "vol_1_TheSuccession_Chapter1_3",
            book = "The Succession",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "Yet Cronus too feared succession, swallowing his own children to maintain his rule.",
            scientificEquivalentId = "vol_2_TheSuccession_Chapter1_3"
        ),
        Verse(
            id = "vol_1_TheSuccession_Chapter1_4",
            book = "The Succession",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "Until Zeus, the thunderer, was born, hidden away to later claim the throne of the cosmos.",
            scientificEquivalentId = "vol_2_TheSuccession_Chapter1_4"
        ),
        Verse(
            id = "vol_2_TheSolarNebula_Chapter1_1",
            book = "The Solar Nebula",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "Following the ignition of the Sun, the residual elements formed a vast circumstellar disk.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_2_TheSolarNebula_Chapter1_2",
            book = "The Solar Nebula",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "Intense thermal radiation scorched the inner realms, leaving only refractory silicates and metals.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_2_TheSolarNebula_Chapter1_3",
            book = "The Solar Nebula",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "But beyond the frost line, where the void was cold, volatile waters and methanes froze into solid ice.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_2_TheSolarNebula_Chapter1_4",
            book = "The Solar Nebula",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "It was in this mass-rich crucible that the core of the Firstborn began to coalesce.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_2_ThePebbleAccretion_Chapter1_1",
            book = "The Pebble Accretion",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "Aerodynamic drag forced centimeter-sized pebbles to spiral inward toward the central star.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_2_ThePebbleAccretion_Chapter1_2",
            book = "The Pebble Accretion",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "The nascent Jovian embryo captured them effortlessly, initiating an exponential runaway growth.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_2_ThePebbleAccretion_Chapter1_3",
            book = "The Pebble Accretion",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "Upon reaching isolation mass, the protoplanet severed the gas disk, starving the core but awakening the envelope.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_2_ThePebbleAccretion_Chapter1_4",
            book = "The Pebble Accretion",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "Thus began the violent consumption of hydrogen and helium, swelling to three hundred and eighteen times the mass of Earth.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_3_TheInwardMigration_Chapter1_1",
            book = "The Inward Migration",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "The Firstborn did not remain static; embedded in the gas nebula, he migrated inward.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_3_TheInwardMigration_Chapter1_2",
            book = "The Inward Migration",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "His overwhelming gravity captured early Super-Earths into deadly mean-motion resonances.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_3_TheInwardMigration_Chapter1_3",
            book = "The Inward Migration",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "A violent collisional cascade shattered these primordial Titans, grinding them to dust.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_3_TheInwardMigration_Chapter1_4",
            book = "The Inward Migration",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "Zeus swept the inner system clean, casting the debris into the fiery abyss of the Sun.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_3_TheResonanceandReversal_Chapter1_1",
            book = "The Resonance and Reversal",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "Then came Saturn, migrating swiftly to catch the Firstborn, locking into a divine 3:2 resonance.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_3_TheResonanceandReversal_Chapter1_2",
            book = "The Resonance and Reversal",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "This mathematical perfection reversed the tidal torques, halting their inward death spiral.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_3_TheResonanceandReversal_Chapter1_3",
            book = "The Resonance and Reversal",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "They tacked outward together, sculpting the inner disk and leaving an annulus of debris.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_3_TheResonanceandReversal_Chapter1_4",
            book = "The Resonance and Reversal",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "From this carefully truncated ring of dust, the terrestrial worlds—and humanity—were permitted to form.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_4_TheInvisibleMantle_Chapter1_1",
            book = "The Invisible Mantle",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "Deep within the Patriarch, a dynamo of liquid metallic hydrogen roared with eternal convection.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_4_TheInvisibleMantle_Chapter1_2",
            book = "The Invisible Mantle",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "It generated a magnetic field twenty thousand times mightier than that of the Earth.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_4_TheInvisibleMantle_Chapter1_3",
            book = "The Invisible Mantle",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "This is the true Aegis: an immense, invisible mantle extending millions of kilometers toward the Sun.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_4_TheInvisibleMantle_Chapter1_4",
            book = "The Invisible Mantle",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "Any unshielded entity entering this realm is subjected to lethal radiation, obliterated by the god's aura.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_4_TheArbiterofImpacts_Chapter1_1",
            book = "The Arbiter of Impacts",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "The Patriarch stands as the cosmic shield, deflecting long-period comets from the Oort Cloud.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_4_TheArbiterofImpacts_Chapter1_2",
            book = "The Arbiter of Impacts",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "He absorbs massive kinetic strikes, bearing the scars so the inner worlds may thrive.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_4_TheArbiterofImpacts_Chapter1_3",
            book = "The Arbiter of Impacts",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "Yet, his immense gravity also hurls asteroidal thunderbolts toward the terrestrial spheres.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_4_TheArbiterofImpacts_Chapter1_4",
            book = "The Arbiter of Impacts",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "By modulating the impact rate, he commands evolution, dictating the rise and fall of life itself.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_5_TheDemiurgicHarmony_Chapter1_1",
            book = "The Demiurgic Harmony",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "To look upon the Jovian system is to witness the Demiurge's gift of absolute proportion.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_5_TheDemiurgicHarmony_Chapter1_2",
            book = "The Demiurgic Harmony",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "Io, Europa, and Ganymede are bound in a flawless mathematical ballet, the Laplace resonance.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_5_TheDemiurgicHarmony_Chapter1_3",
            book = "The Demiurgic Harmony",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "For every single orbit of Ganymede, Europa completes two, and fiery Io completes four.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_5_TheDemiurgicHarmony_Chapter1_4",
            book = "The Demiurgic Harmony",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "This synchronized worship generates immense tidal heat, melting subsurface oceans and igniting volcanoes.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_5_TheBoundServants_Chapter1_1",
            book = "The Bound Servants",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "Io burns with eternal sulfurous devotion, bleeding plasma into the Patriarch's magnetosphere.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_5_TheBoundServants_Chapter1_2",
            book = "The Bound Servants",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "Europa hides a deep, dark ocean beneath her icy crust, warmed by the gravitational pulse of the Firstborn.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_5_TheBoundServants_Chapter1_3",
            book = "The Bound Servants",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "Ganymede, the largest of all moons, wields his own magnetic field, a lesser king in the court of Zeus.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_5_TheBoundServants_Chapter1_4",
            book = "The Bound Servants",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "Callisto remains at the threshold, an ancient, cratered witness to the eternal dance of the inner court.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_6_TheGreatRedEye_Chapter1_1",
            book = "The Great Red Eye",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "Upon the face of the Firstborn rages an eternal storm, an anticyclonic eye wider than the Earth.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_6_TheGreatRedEye_Chapter1_2",
            book = "The Great Red Eye",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "The Great Red Spot has churned for centuries, a testament to the unyielding atmospheric chaos.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_6_TheGreatRedEye_Chapter1_3",
            book = "The Great Red Eye",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "Winds scream at hundreds of kilometers per hour, driven by the intense internal heat of the planet.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_6_TheGreatRedEye_Chapter1_4",
            book = "The Great Red Eye",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "It is the watchful eye of the sovereign, gazing out into the dark expanse of the solar system.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_6_TheDiluteCore_Chapter1_1",
            book = "The Dilute Core",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "Beneath the swirling clouds of ammonia and hydrosulfide lies a mystery of creation.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_6_TheDiluteCore_Chapter1_2",
            book = "The Dilute Core",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "There is no solid, compact center, but a dilute core, dissolved into the metallic hydrogen envelope.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_6_TheDiluteCore_Chapter1_3",
            book = "The Dilute Core",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "Just as Zeus swallowed Wisdom herself, the Patriarch assimilated the primordial planetesimals.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_6_TheDiluteCore_Chapter1_4",
            book = "The Dilute Core",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "He incorporated their essence throughout his vast interior, securing his eternal and undisputed reign.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_7_TheRedGiantPhase_Chapter1_1",
            book = "The Red Giant Phase",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "In the distant future, the Sun will exhaust its fuel, swelling into a monstrous Red Giant.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_7_TheRedGiantPhase_Chapter1_2",
            book = "The Red Giant Phase",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "The oceans of Earth will boil away, and the inner terrestrial worlds will be swallowed in fire.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_7_TheRedGiantPhase_Chapter1_3",
            book = "The Red Giant Phase",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "Yet, the Patriarch will remain, his massive gravity indifferent to the dying spasms of the star.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_7_TheRedGiantPhase_Chapter1_4",
            book = "The Red Giant Phase",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "The frost line will be pushed outward, but Jupiter's immense bulk will endure the searing heat.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_7_TheLoneSovereign_Chapter1_1",
            book = "The Lone Sovereign",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "When the Sun finally collapses into a dim White Dwarf, the solar system will be cast into twilight.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_7_TheLoneSovereign_Chapter1_2",
            book = "The Lone Sovereign",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "Zeus will stand as the largest and most massive body in the frozen graveyard of the cosmos.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_7_TheLoneSovereign_Chapter1_3",
            book = "The Lone Sovereign",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "He will be the final anchor, holding the surviving outer worlds in his unwavering gravitational grasp.",
            scientificEquivalentId = null
        ),
        Verse(
            id = "vol_7_TheLoneSovereign_Chapter1_4",
            book = "The Lone Sovereign",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "From the birth of the nebula to the death of the star, the Firstborn's reign is absolute and eternal.",
            scientificEquivalentId = null
        )
    )

    val volumes = listOf(
        Volume(
            id = "vol_1",
            title = "VOLUME I",
            subtitle = "The Legacy Myths",
            description = "The ancient Hellenic framework and the Hesiodic error.",
            books = listOf(
                Book(
                    title = "Genesis of Chaos",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "Genesis of Chaos" && it.chapter == "Chapter 1" }
                    )
                    )
                ),
                Book(
                    title = "The Succession",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Succession" && it.chapter == "Chapter 1" }
                    )
                    )
                )
            )
        ),
        Volume(
            id = "vol_2",
            title = "VOLUME II",
            subtitle = "The Astrochemical Genesis",
            description = "The true birth of Jupiter from the primordial solar nebula.",
            books = listOf(
                Book(
                    title = "The Solar Nebula",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Solar Nebula" && it.chapter == "Chapter 1" }
                    )
                    )
                ),
                Book(
                    title = "The Pebble Accretion",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Pebble Accretion" && it.chapter == "Chapter 1" }
                    )
                    )
                )
            )
        ),
        Volume(
            id = "vol_3",
            title = "VOLUME III",
            subtitle = "The Gravitational Architect",
            description = "The Grand Tack and the structuring of the terrestrial worlds.",
            books = listOf(
                Book(
                    title = "The Inward Migration",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Inward Migration" && it.chapter == "Chapter 1" }
                    )
                    )
                ),
                Book(
                    title = "The Resonance and Reversal",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Resonance and Reversal" && it.chapter == "Chapter 1" }
                    )
                    )
                )
            )
        ),
        Volume(
            id = "vol_4",
            title = "VOLUME IV",
            subtitle = "The Cosmic Aegis",
            description = "The magnetosphere and the shielding of the inner planets.",
            books = listOf(
                Book(
                    title = "The Invisible Mantle",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Invisible Mantle" && it.chapter == "Chapter 1" }
                    )
                    )
                ),
                Book(
                    title = "The Arbiter of Impacts",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Arbiter of Impacts" && it.chapter == "Chapter 1" }
                    )
                    )
                )
            )
        ),
        Volume(
            id = "vol_5",
            title = "VOLUME V",
            subtitle = "The Galilean Court",
            description = "The Laplace resonance and the perfection of the Jovian system.",
            books = listOf(
                Book(
                    title = "The Demiurgic Harmony",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Demiurgic Harmony" && it.chapter == "Chapter 1" }
                    )
                    )
                ),
                Book(
                    title = "The Bound Servants",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Bound Servants" && it.chapter == "Chapter 1" }
                    )
                    )
                )
            )
        ),
        Volume(
            id = "vol_6",
            title = "VOLUME VI",
            subtitle = "The Storms of the Patriarch",
            description = "The atmospheric synthesis and the eternal cyclones.",
            books = listOf(
                Book(
                    title = "The Great Red Eye",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Great Red Eye" && it.chapter == "Chapter 1" }
                    )
                    )
                ),
                Book(
                    title = "The Dilute Core",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Dilute Core" && it.chapter == "Chapter 1" }
                    )
                    )
                )
            )
        ),
        Volume(
            id = "vol_7",
            title = "VOLUME VII",
            subtitle = "The Final Anchor",
            description = "The future epoch and the ultimate survival of Zeus.",
            books = listOf(
                Book(
                    title = "The Red Giant Phase",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Red Giant Phase" && it.chapter == "Chapter 1" }
                    )
                    )
                ),
                Book(
                    title = "The Lone Sovereign",
                    chapters = listOf(
                    Chapter(
                        title = "Chapter 1",
                        verses = allVerses.filter { it.book == "The Lone Sovereign" && it.chapter == "Chapter 1" }
                    )
                    )
                )
            )
        )
    )

    fun getVerse(id: String?): Verse? {
        return allVerses.find { it.id == id }
    }
}
