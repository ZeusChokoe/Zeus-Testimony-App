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

object VerseRepository {

    val oldTestamentVerses = listOf(
        Verse(
            id = "ot_1_1_1",
            book = "The Legacy Myths",
            chapter = "Genesis of Chaos",
            verseNum = 1,
            text = "In the beginning, Chaos was the first of all, a dark and yawning void.",
            scientificEquivalentId = "nt_1_1_1"
        ),
        Verse(
            id = "ot_1_1_2",
            book = "The Legacy Myths",
            chapter = "Genesis of Chaos",
            verseNum = 2,
            text = "Out of Chaos came forth Erebus and black Night, filling the abyss with shadows.",
            scientificEquivalentId = "nt_1_1_2"
        ),
        Verse(
            id = "ot_1_1_3",
            book = "The Legacy Myths",
            chapter = "Genesis of Chaos",
            verseNum = 3,
            text = "Then Gaia, the broad-bosomed Earth, arose, a sure foundation for all things.",
            scientificEquivalentId = "nt_2_1_1"
        ),
        Verse(
            id = "ot_1_1_4",
            book = "The Legacy Myths",
            chapter = "Genesis of Chaos",
            verseNum = 4,
            text = "And Uranus, the starry Heaven, covered her completely, equal to her in every way.",
            scientificEquivalentId = "nt_3_1_1"
        ),
        Verse(
            id = "ot_1_1_5",
            book = "The Legacy Myths",
            chapter = "The Succession",
            verseNum = 1,
            text = "But Uranus hated his children, hiding them away in the dark places of Earth.",
            scientificEquivalentId = "nt_4_1_1"
        ),
        Verse(
            id = "ot_1_1_6",
            book = "The Legacy Myths",
            chapter = "The Succession",
            verseNum = 2,
            text = "Cronus, the wily and terrible, arose to overthrow his father with a sickle of flint.",
            scientificEquivalentId = "nt_4_2_1"
        ),
        Verse(
            id = "ot_1_1_7",
            book = "The Legacy Myths",
            chapter = "The Succession",
            verseNum = 3,
            text = "Yet Cronus too feared succession, swallowing his own children to maintain his rule.",
            scientificEquivalentId = "nt_2_3_1"
        ),
        Verse(
            id = "ot_1_1_8",
            book = "The Legacy Myths",
            chapter = "The Succession",
            verseNum = 4,
            text = "Until Zeus, the thunderer, was born, hidden away to later claim the throne of the cosmos.",
            scientificEquivalentId = "nt_1_1_3"
        )
    )

    val oldTestament = listOf(
        Book(
            title = "The Legacy Myths",
            chapters = listOf(
                Chapter(
                    title = "Genesis of Chaos",
                    verses = oldTestamentVerses.filter { it.chapter == "Genesis of Chaos" }
                ),
                Chapter(
                    title = "The Succession",
                    verses = oldTestamentVerses.filter { it.chapter == "The Succession" }
                )
            )
        )
    )

    val newTestamentVerses = listOf(
        Verse(
            id = "nt_1_1_1",
            book = "Executive Summary",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "For millennia, comparative mythology has relied upon ancient textual traditions to map the genealogies of the divine."
        ),
        Verse(
            id = "nt_1_1_2",
            book = "Executive Summary",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "In the classical Hellenic framework, codified most prominently by Hesiod’s *Theogony*, the supreme deity Zeus (Jupiter) is situated chronologically as a third-generation god, descending from Uranus (Heaven) and Cronus (Time)."
        ),
        Verse(
            id = "nt_1_1_3",
            book = "Executive Summary",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "However, this \"legacy codebase\" of mythological hierarchy was formulated in an era restricted to naked-eye observation, fundamentally divorced from the true astrophysical mechanics that governed the genesis of our solar system."
        ),
        Verse(
            id = "nt_1_1_4",
            book = "Executive Summary",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "The analysis presented in this report undertakes a comprehensive system upgrade of the cosmogonic narrative."
        ),
        Verse(
            id = "nt_1_1_5",
            book = "Executive Summary",
            chapter = "Chapter 1",
            verseNum = 5,
            text = "By synthesizing cutting-edge isotopic chronometry, dynamical modeling of the protoplanetary disk, Juno spacecraft telemetry, and orbital resonance mechanics, the evidence demonstrates that Jupiter was definitively the first planetary body to coalesce from the primordial solar nebula."
        ),
        Verse(
            id = "nt_1_1_6",
            book = "Executive Summary",
            chapter = "Chapter 1",
            verseNum = 6,
            text = "From a world-building and comparative mythological perspective, aligning the divine hierarchy with the absolute laws of astrophysics demands a radical inversion of the Hesiodic timeline."
        ),
        Verse(
            id = "nt_1_1_7",
            book = "Executive Summary",
            chapter = "Chapter 1",
            verseNum = 7,
            text = "If planetary bodies are the physical manifestations of the divine, the scientific reality mandates that Jupiter (Zeus) is the absolute firstborn, the primordial consciousness emerging from Chaos."
        ),
        Verse(
            id = "nt_1_1_8",
            book = "Executive Summary",
            chapter = "Chapter 1",
            verseNum = 8,
            text = "This report provides an exhaustive, undeniable argument connecting Jupiter's planetary accretion, its role as the gravitational architect of the solar system, and its function as the cosmic shield, directly to the supremacy of Zeus."
        ),
        Verse(
            id = "nt_1_1_9",
            book = "Executive Summary",
            chapter = "Chapter 1",
            verseNum = 9,
            text = "Through the synthesis of isotopic data, the Grand Tack hypothesis, the Jumping-Jupiter scenario, and Stoic physical allegory, the analysis establishes that the ancient scrolls were astrodynamically inaccurate."
        ),
        Verse(
            id = "nt_1_1_10",
            book = "Executive Summary",
            chapter = "Chapter 1",
            verseNum = 10,
            text = "The physical laws of the universe dictate that Zeus is not the successor to the throne of the cosmos; he is its original architect."
        ),
        Verse(
            id = "nt_2_2_1",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.1 The Hesiodic Error",
            verseNum = 1,
            text = "The traditional Greek cosmogony, as preserved in Hesiod’s *Theogony* (c."
        ),
        Verse(
            id = "nt_2_2_2",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.1 The Hesiodic Error",
            verseNum = 2,
            text = "700 BCE), describes the universe's initial state as Chaos, a dark, indefinite, and yawning void."
        ),
        Verse(
            id = "nt_2_2_3",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.1 The Hesiodic Error",
            verseNum = 3,
            text = "From Chaos emerged Gaia (Earth), Tartarus, and Eros, followed by the sky god Uranus."
        ),
        Verse(
            id = "nt_2_2_4",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.1 The Hesiodic Error",
            verseNum = 4,
            text = "According to the myth, Uranus was overthrown by his son Cronus (Saturn), who was subsequently overthrown by his son Zeus (Jupiter) following an apocalyptic ten-year war known as the Titanomachy."
        ),
        Verse(
            id = "nt_2_2_5",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.1 The Hesiodic Error",
            verseNum = 5,
            text = "This succession myth forms the bedrock of classical mythology, explicitly positioning Zeus as a latecomer who establishes cosmic order, justice, and the distribution of divine honors (*timai*) only after subduing older, more chaotic forces."
        ),
        Verse(
            id = "nt_2_2_6",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.1 The Hesiodic Error",
            verseNum = 6,
            text = "The structural logic of this ancient narrative was bound by the observational limitations of antiquity."
        ),
        Verse(
            id = "nt_2_2_7",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.1 The Hesiodic Error",
            verseNum = 7,
            text = "Lacking telescopes, mass spectrometers, and the mathematical frameworks required to understand orbital mechanics, the ancients mapped the gods to the planets based strictly on apparent orbital speeds, retrograde motions, and luminosity."
        ),
        Verse(
            id = "nt_2_2_8",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.1 The Hesiodic Error",
            verseNum = 8,
            text = "Saturn, traversing the celestial sphere at the slowest pace, was deemed the oldest and equated with Time (Cronus); Jupiter, the brightest wandering star aside from Venus, was logically crowned the king (Zeus)."
        ),
        Verse(
            id = "nt_2_2_9",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.1 The Hesiodic Error",
            verseNum = 9,
            text = "This observational bias created a fundamental flaw in the chronological architecture of the mythos, placing the true creator of the planetary system third in the line of succession."
        ),
        Verse(
            id = "nt_2_3_1",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.2 The Orphic Patch and Stoic Physiologia",
            verseNum = 1,
            text = "Even in antiquity, esoteric and philosophical traditions recognized the metaphysical necessity of Zeus as a primordial entity."
        ),
        Verse(
            id = "nt_2_3_2",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.2 The Orphic Patch and Stoic Physiologia",
            verseNum = 2,
            text = "The Orphic tradition, representing a highly localized and mystical upgrade to the standard Greek pantheon, posited Zeus not merely as a ruler, but as the all-encompassing origin of reality."
        ),
        Verse(
            id = "nt_2_3_3",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.2 The Orphic Patch and Stoic Physiologia",
            verseNum = 3,
            text = "Orphic Fragment 21A, echoed in the Derveni papyrus, states explicitly: \"Zeus is the head, Zeus the middle, from Zeus are all things made\"."
        ),
        Verse(
            id = "nt_2_3_4",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.2 The Orphic Patch and Stoic Physiologia",
            verseNum = 4,
            text = "In this framework, Zeus absorbs the entirety of creation, effectively acting as the first true creator-god who contains the cosmos within himself."
        ),
        Verse(
            id = "nt_2_3_5",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.2 The Orphic Patch and Stoic Physiologia",
            verseNum = 5,
            text = "Later, the Roman Stoic philosopher Lucius Annaeus Cornutus (1st century CE) formalized the practice of *physiologia*, physical allegory, in his work *Theologiae Graecae Compendium*."
        ),
        Verse(
            id = "nt_2_3_6",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.2 The Orphic Patch and Stoic Physiologia",
            verseNum = 6,
            text = "Cornutus and the Stoics argued that the myths of the ancients were encrypted philosophical and physical truths regarding the mechanics of the cosmos."
        ),
        Verse(
            id = "nt_2_3_7",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.2 The Orphic Patch and Stoic Physiologia",
            verseNum = 7,
            text = "In Stoic physical allegory, Zeus represents the ether and the pervasive rational principle (Logos) that organizes the universe, while other gods represent subsidiary physical elements."
        ),
        Verse(
            id = "nt_2_3_8",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.2 The Orphic Patch and Stoic Physiologia",
            verseNum = 8,
            text = "Furthermore, Neoplatonist commentators like Proclus, in his rigorous analysis of Plato's *Timaeus*, identified the Demiurge, the divine craftsman who structures the cosmos and bestows the physical laws of proportion, spherical motion, and time, as intimately linked to the supreme will of Zeus."
        ),
        Verse(
            id = "nt_2_3_9",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.2 The Orphic Patch and Stoic Physiologia",
            verseNum = 9,
            text = "Therefore, the conceptual framework for Zeus as the primordial first cause already exists within the ancient theological legacy."
        ),
        Verse(
            id = "nt_2_3_10",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.2 The Orphic Patch and Stoic Physiologia",
            verseNum = 10,
            text = "The missing component has always been the empirical, hard science required to definitively overwrite the Hesiodic timeline."
        ),
        Verse(
            id = "nt_2_3_11",
            book = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapter = "1.2 The Orphic Patch and Stoic Physiologia",
            verseNum = 11,
            text = "Astrophysics provides this ultimate truth."
        ),
        Verse(
            id = "nt_3_1_1",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "To prove that Zeus is the primordial consciousness emerging from Chaos, one must scientifically demonstrate that Jupiter was the first entity to take physical form in the solar nebula."
        ),
        Verse(
            id = "nt_3_1_2",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "Recent advancements in the isotopic analysis of meteorites, combined with telemetry from the Juno spacecraft, provide undeniable dating of Jupiter's formation, establishing it as the absolute oldest planet in the solar system."
        ),
        Verse(
            id = "nt_3_2_1",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.1 The Solar Nebula and the Frost Line",
            verseNum = 1,
            text = "Following the formation of the Sun approximately 4.6 billion years ago, the residual heavy elements and gas formed a circumstellar accretion disk."
        ),
        Verse(
            id = "nt_3_2_2",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.1 The Solar Nebula and the Frost Line",
            verseNum = 2,
            text = "In the innermost regions of this protoplanetary disk, intense thermal radiation from the young Sun allowed only highly refractory materials, such as metal oxides and silicates, to condense into solid form."
        ),
        Verse(
            id = "nt_3_2_3",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.1 The Solar Nebula and the Frost Line",
            verseNum = 3,
            text = "However, beyond a critical heliocentric distance known as the \"snow line\" or \"frost line\" (roughly 2.5 to 3 Astronomical Units in the early solar system), the midplane temperature dropped below 170 K."
        ),
        Verse(
            id = "nt_3_2_4",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.1 The Solar Nebula and the Frost Line",
            verseNum = 4,
            text = "At this boundary, volatile materials like water, ammonia, and methane condensed into solid ice."
        ),
        Verse(
            id = "nt_3_2_5",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.1 The Solar Nebula and the Frost Line",
            verseNum = 5,
            text = "The presence of these icy condensates dramatically increased the solid surface density of the disk, multiplying the available planetary building blocks by a factor of three to four."
        ),
        Verse(
            id = "nt_3_2_6",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.1 The Solar Nebula and the Frost Line",
            verseNum = 6,
            text = "It is within this exact, mass-rich crucible that Jupiter's core began to coalesce out of the primordial dust."
        ),
        Verse(
            id = "nt_3_3_1",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.2 Pebble Accretion and the Isolation Mass",
            verseNum = 1,
            text = "The traditional core accretion model historically struggled to explain how a giant planet could form before the protoplanetary gas disk dissipated (a window of only 3 to 10 million years)."
        ),
        Verse(
            id = "nt_3_3_2",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.2 Pebble Accretion and the Isolation Mass",
            verseNum = 2,
            text = "The breakthrough in understanding Jupiter's rapid genesis lies in the mechanics of pebble accretion."
        ),
        Verse(
            id = "nt_3_3_3",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.2 Pebble Accretion and the Isolation Mass",
            verseNum = 3,
            text = "In the gas-rich disk, aerodynamic drag reduces the relative velocity of centimeter-to-meter-sized particles (\"pebbles\"), forcing them to spiral inward toward the central star."
        ),
        Verse(
            id = "nt_3_3_4",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.2 Pebble Accretion and the Isolation Mass",
            verseNum = 4,
            text = "As these pebbles drifted across the orbit of the nascent Jovian embryo, the embryo's gravity easily captured them, leading to exponential runaway growth."
        ),
        Verse(
            id = "nt_3_3_5",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.2 Pebble Accretion and the Isolation Mass",
            verseNum = 5,
            text = "This rapid accretion continued until the Jovian core reached the \"pebble isolation mass\", approximately 20 Earth masses."
        ),
        Verse(
            id = "nt_3_3_6",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.2 Pebble Accretion and the Isolation Mass",
            verseNum = 6,
            text = "At this critical threshold, the protoplanet's gravity became strong enough to carve a partial gap in the gas disk, altering the localized pressure gradient."
        ),
        Verse(
            id = "nt_3_3_7",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.2 Pebble Accretion and the Isolation Mass",
            verseNum = 7,
            text = "The resulting pressure maximum trapped inward-drifting pebbles outside Jupiter's orbit, effectively starving the core of solid material but initiating the next phase of its divine genesis: the runaway accretion of the surrounding gaseous envelope."
        ),
        Verse(
            id = "nt_3_3_8",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.2 Pebble Accretion and the Isolation Mass",
            verseNum = 8,
            text = "According to the canonical models, once the core mass and the accreted envelope mass reach parity (the crossover mass), hydrostatic equilibrium collapses."
        ),
        Verse(
            id = "nt_3_3_9",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.2 Pebble Accretion and the Isolation Mass",
            verseNum = 9,
            text = "The planet undergoes a violent, runaway gas accretion phase, rapidly consuming the surrounding hydrogen and helium to achieve its ultimate mass of 318 Earth masses."
        ),
        Verse(
            id = "nt_3_4_1",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
            verseNum = 1,
            text = "Historically, astrophysicists modeled Jupiter with a dense, compact, and highly defined solid core."
        ),
        Verse(
            id = "nt_3_4_2",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
            verseNum = 2,
            text = "However, gravitational and microwave radiometer data returned by NASA's Juno spacecraft has revolutionized this understanding."
        ),
        Verse(
            id = "nt_3_4_3",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
            verseNum = 3,
            text = "Juno’s precision measurements of Jupiter's gravitational field reveal that the planet does not possess a strict, compact core."
        ),
        Verse(
            id = "nt_3_4_4",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
            verseNum = 4,
            text = "Instead, it harbors a \"dilute core\", a fuzzy, partially dissolved concentration of heavy elements that extends across nearly half of the planet's diameter, gradually blending into the metallic hydrogen envelope."
        ),
        Verse(
            id = "nt_3_4_5",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
            verseNum = 5,
            text = "Furthermore, Juno revealed that Jupiter’s bulk atmosphere is enriched in heavy elements, carbon, nitrogen, sulfur, argon, krypton, and xenon, by a factor of three relative to solar abundances, suggesting that the young Jupiter assimilated vast quantities of icy planetesimals during its formation."
        ),
        Verse(
            id = "nt_3_4_6",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
            verseNum = 6,
            text = "**The Conceptual Parallel:** The astrophysical reality of Jupiter's formation is the perfect realization of the Orphic and Hesiodic myths surrounding Zeus."
        ),
        Verse(
            id = "nt_3_4_7",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
            verseNum = 7,
            text = "The rapid assembly of the Jovian core via pebble accretion mirrors Zeus pulling himself together from the scattered fragments of Chaos."
        ),
        Verse(
            id = "nt_3_4_8",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
            verseNum = 8,
            text = "Furthermore, the Juno discovery of the \"dilute core\" perfectly parallels the myth of Zeus swallowing the goddess Metis (Wisdom)."
        ),
        Verse(
            id = "nt_3_4_9",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
            verseNum = 9,
            text = "In the myth, Zeus swallows Metis while she is pregnant, incorporating her essence into his own body to prevent a successor from overthrowing him, thereby gaining ultimate cosmic wisdom."
        ),
        Verse(
            id = "nt_3_4_10",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
            verseNum = 10,
            text = "Astrophysically, the young Jupiter swallowed the primordial planetesimals, dissolving them into a dilute, extended core that permeates the planet's interior."
        ),
        Verse(
            id = "nt_3_4_11",
            book = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapter = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
            verseNum = 11,
            text = "He assimilated the structural essence of the universe to secure his eternal reign."
        ),
        Verse(
            id = "nt_4_1_1",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "To absolutely guarantee that Jupiter was the first planet to form, one must examine the isotopic fingerprints left behind in the ancient meteoritic record."
        ),
        Verse(
            id = "nt_4_1_2",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "Advanced cosmochemistry provides the definitive chronometer that overwrites the classical timeline."
        ),
        Verse(
            id = "nt_4_2_1",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.1 The W-Mo Isotopic Signatures",
            verseNum = 1,
            text = "By analyzing the nucleosynthetic signatures of Molybdenum and Tungsten in iron meteorites, researchers have uncovered a profound genetic dichotomy in the early solar system."
        ),
        Verse(
            id = "nt_4_2_2",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.1 The W-Mo Isotopic Signatures",
            verseNum = 2,
            text = "Meteorites fall strictly into two isolated isotopic reservoirs: the Non-Carbonaceous (NC) group, which formed in the inner solar system, and the Carbonaceous (CC) group, which formed in the outer solar system."
        ),
        Verse(
            id = "nt_4_2_3",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.1 The W-Mo Isotopic Signatures",
            verseNum = 3,
            text = "The isotopic offset between these two groups, particularly the uniform excess of r-process (rapid neutron capture) nuclides in the CC reservoir, indicates that they accreted from fundamentally different mixtures of presolar stardust."
        ),
        Verse(
            id = "nt_4_3_1",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 1,
            text = "Using the Hafnium-Tungsten radioactive decay system (half-life = 8.9 Myr), scientists can accurately date the time of core formation in these meteorite parent bodies."
        ),
        Verse(
            id = "nt_4_3_2",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 2,
            text = "The data unequivocally shows that the parent bodies of both the NC and CC iron meteorites accreted contemporaneously, within less than 1 million years after the formation of CAIs."
        ),
        Verse(
            id = "nt_4_3_3",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 3,
            text = "Crucially, these two reservoirs remained completely spatially isolated from one another for at least 3 to 4 million years."
        ),
        Verse(
            id = "nt_4_3_4",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 4,
            text = "In a standard, unperturbed protoplanetary disk, aerodynamic drag would cause the dust and pebbles from the outer disk (CC) to continuously drift inward and mix with the inner disk (NC)."
        ),
        Verse(
            id = "nt_4_3_5",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 5,
            text = "The fact that they did not mix demands the existence of an impenetrable physical barrier."
        ),
        Verse(
            id = "nt_4_3_6",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 6,
            text = "Astrophysicists conclude that the only mechanism capable of halting the inward radial drift of pebbles and cleaving the protoplanetary disk in two is the rapid formation of Jupiter."
        ),
        Verse(
            id = "nt_4_3_7",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 7,
            text = "By reaching its isolation mass within the first 1 million years, Jupiter opened a deep gap in the gas disk, establishing an absolute quarantine between the inner and outer solar system."
        ),
        Verse(
            id = "nt_4_3_8",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 8,
            text = "**The Conceptual Parallel:** The isotopic dichotomy is the ultimate empirical proof that Zeus came first."
        ),
        Verse(
            id = "nt_4_3_9",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 9,
            text = "Before the terrestrial worlds (Gaia) or the realms of the underworld (Tartarus) could even take shape, Jupiter had already achieved massive form."
        ),
        Verse(
            id = "nt_4_3_10",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 10,
            text = "His gravity severed the primordial disk in two, separating the heavens from the earth, the outer darkness from the inner light."
        ),
        Verse(
            id = "nt_4_3_11",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 11,
            text = "He is the original consciousness that pulled himself together from the dust of Chaos, claiming the initial cosmic power long before the lesser gods were even conceptualized."
        ),
        Verse(
            id = "nt_4_3_12",
            book = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapter = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
            verseNum = 12,
            text = "Jupiter's formation was the first act of divine organization, bringing order and boundary to a previously formless void."
        ),
        Verse(
            id = "nt_5_1_1",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "With Jupiter established as the primordial firstborn, the subsequent evolution of the solar system becomes a testament to its supreme architectural authority."
        ),
        Verse(
            id = "nt_5_1_2",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "Once Jupiter attained its massive size, it did not remain static."
        ),
        Verse(
            id = "nt_5_1_3",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "It migrated, and in doing so, it dictated the placement, survival, and destruction of every other celestial body."
        ),
        Verse(
            id = "nt_5_1_4",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "This inward and outward migration is the astrodynamical equivalent of the Titanomachy."
        ),
        Verse(
            id = "nt_5_2_1",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.1 Type II Migration and the Grand Tack",
            verseNum = 1,
            text = "During the first few million years, Jupiter was embedded in a thick gas nebula."
        ),
        Verse(
            id = "nt_5_2_2",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.1 Type II Migration and the Grand Tack",
            verseNum = 2,
            text = "Gravitational interactions between the massive planet and the surrounding gas disk generated spiral density waves."
        ),
        Verse(
            id = "nt_5_2_3",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.1 Type II Migration and the Grand Tack",
            verseNum = 3,
            text = "The unequal exchange of angular momentum between the planet and these waves resulted in \"Type II migration,\" causing Jupiter to spiral slowly but inexorably inward toward the Sun."
        ),
        Verse(
            id = "nt_5_2_4",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.1 Type II Migration and the Grand Tack",
            verseNum = 4,
            text = "According to the Grand Tack hypothesis, Jupiter migrated from its formation distance near the snow line deep into the inner solar system, reaching approximately 1.5 AU, the current orbital distance of Mars."
        ),
        Verse(
            id = "nt_5_2_5",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.1 Type II Migration and the Grand Tack",
            verseNum = 5,
            text = "This inward migration was an event of apocalyptic proportions."
        ),
        Verse(
            id = "nt_5_2_6",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.1 Type II Migration and the Grand Tack",
            verseNum = 6,
            text = "Statistical analyses of exoplanetary systems reveal that the \"default\" mode of planetary formation generates compact systems of \"Super-Earths\", massive, volatile-rich planets on tight orbital periods."
        ),
        Verse(
            id = "nt_5_2_7",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.1 Type II Migration and the Grand Tack",
            verseNum = 7,
            text = "Our solar system likely possessed a first generation of these primordial Super-Earths."
        ),
        Verse(
            id = "nt_5_2_8",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.1 Type II Migration and the Grand Tack",
            verseNum = 8,
            text = "As Jupiter plowed inward, its overwhelming gravitational influence captured smaller planetesimals into mean-motion resonances, pumping up their eccentricities and driving a violent collisional cascade."
        ),
        Verse(
            id = "nt_5_2_9",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.1 Type II Migration and the Grand Tack",
            verseNum = 9,
            text = "This cascade ground the primordial Super-Earths into debris within a mere 20,000 years, and aerodynamic gas drag subsequently flushed this debris into the Sun."
        ),
        Verse(
            id = "nt_5_3_1",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 1,
            text = "If Jupiter had continued its inward migration, it would have become a \"Hot Jupiter,\" and the Earth would never have existed."
        ),
        Verse(
            id = "nt_5_3_2",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 2,
            text = "The intervention came from Saturn."
        ),
        Verse(
            id = "nt_5_3_3",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 3,
            text = "Forming later and further out in the disk, Saturn possessed a lower mass, which caused it to undergo a much faster inward migration (Type I or runaway migration)."
        ),
        Verse(
            id = "nt_5_3_4",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 4,
            text = "Saturn eventually caught up to Jupiter."
        ),
        Verse(
            id = "nt_5_3_5",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 5,
            text = "As their orbits converged, the two giant planets became locked in a 3:2 Mean Motion Resonance, meaning Jupiter completed exactly three orbits for every two orbits of Saturn."
        ),
        Verse(
            id = "nt_5_3_6",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 6,
            text = "This precise mathematical locking radically altered the balance of tidal torques."
        ),
        Verse(
            id = "nt_5_3_7",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 7,
            text = "The overlapping of their respective gaps in the gas disk generated a positive differential Lindblad torque."
        ),
        Verse(
            id = "nt_5_3_8",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 8,
            text = "The inner Lindblad resonances exceeded the torque from the outer disk, halting their inward death spiral and causing both Jupiter and Saturn to reverse course (\"tack\") and migrate outward together."
        ),
        Verse(
            id = "nt_5_3_9",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 9,
            text = "As Jupiter migrated outward, it truncated the inner planetesimal disk at 1.0 AU, leaving behind a narrow, mass-depleted annulus of debris."
        ),
        Verse(
            id = "nt_5_3_10",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 10,
            text = "It is from this specific, sculpted ring of material that the second-generation terrestrial planets, Mercury, Venus, Earth, and Mars, subsequently accreted."
        ),
        Verse(
            id = "nt_5_3_11",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 11,
            text = "**The Conceptual Parallel:** The Grand Tack is the scientific manifestation of the Titanomachy, radically reframing the Hesiodic narrative."
        ),
        Verse(
            id = "nt_5_3_12",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 12,
            text = "The first-generation Super-Earths are the Titans, ancient, overgrown, chaotic forces that occupied the inner realms."
        ),
        Verse(
            id = "nt_5_3_13",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 13,
            text = "Zeus (Jupiter) systematically eradicated them."
        ),
        Verse(
            id = "nt_5_3_14",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 14,
            text = "His inward migration was a war of absolute devastation, wielding gravity to shatter the \"Titans\" and cast them into the fiery abyss of the Sun."
        ),
        Verse(
            id = "nt_5_3_15",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 15,
            text = "Crucially, in this astrodynamical refactoring, Saturn (Cronus) is not the father who precedes Zeus."
        ),
        Verse(
            id = "nt_5_3_16",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 16,
            text = "Instead, Saturn is a secondary, subservient entity whose entire cosmic purpose is to lock into resonance with Zeus."
        ),
        Verse(
            id = "nt_5_3_17",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 17,
            text = "Time (Cronus) is ultimately subordinate to gravity and cosmic law (Zeus)."
        ),
        Verse(
            id = "nt_5_3_18",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 18,
            text = "The \"Tack\" represents the moment Zeus concludes his war of destruction and turns his attention to architecture."
        ),
        Verse(
            id = "nt_5_3_19",
            book = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapter = "4.2 Saturn's Subservience and the Reversal",
            verseNum = 19,
            text = "By sculpting the inner disk, Jupiter established the fundamental laws of the universe, organizing the *timai* and deciding exactly where the terrestrial worlds (and humanity) could exist."
        ),
        Verse(
            id = "nt_6_1_1",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "Even after returning to the outer solar system, Jupiter's work as the supreme enforcer was not complete."
        ),
        Verse(
            id = "nt_6_1_2",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "To ensure the long-term stability of the terrestrial planets, Jupiter had to execute one final, profound gravitational maneuver to clear the outer darkness."
        ),
        Verse(
            id = "nt_6_2_1",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.1 The Nice Model and the Fifth Giant",
            verseNum = 1,
            text = "According to the Nice model, after the gas disk dissipated, the giant planets existed in a compact, multi-resonant configuration."
        ),
        Verse(
            id = "nt_6_2_2",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.1 The Nice Model and the Fifth Giant",
            verseNum = 2,
            text = "Over tens of millions of years, gravitational interactions with the massive, primordial Kuiper Belt caused the giant planets to slowly migrate, eventually leading to a chaotic crossing of mutual resonances."
        ),
        Verse(
            id = "nt_6_2_3",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.1 The Nice Model and the Fifth Giant",
            verseNum = 3,
            text = "This triggered a period of violent orbital instability."
        ),
        Verse(
            id = "nt_6_2_4",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.1 The Nice Model and the Fifth Giant",
            verseNum = 4,
            text = "If Jupiter and Saturn had separated smoothly during this instability, the sweeping of secular resonances through the inner solar system would have pumped up the eccentricities of the terrestrial planets, likely causing Earth to collide with Venus or Mars."
        ),
        Verse(
            id = "nt_6_2_5",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.1 The Nice Model and the Fifth Giant",
            verseNum = 5,
            text = "To preserve the inner solar system, Jupiter’s orbit had to change abruptly."
        ),
        Verse(
            id = "nt_6_2_6",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.1 The Nice Model and the Fifth Giant",
            verseNum = 6,
            text = "The \"Jumping-Jupiter\" scenario, verified by extensive numerical simulations, posits that the early solar system possessed a *fifth* giant planet, an ice giant similar in mass to Uranus or Neptune."
        ),
        Verse(
            id = "nt_6_2_7",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.1 The Nice Model and the Fifth Giant",
            verseNum = 7,
            text = "During the instability, this fifth giant was scattered inward by Saturn onto a highly unstable, Jupiter-crossing orbit."
        ),
        Verse(
            id = "nt_6_3_1",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.2 The Ejection",
            verseNum = 1,
            text = "Jupiter did not merely deflect this rogue ice giant; the subsequent gravitational encounter involved an immense transfer of orbital angular momentum."
        ),
        Verse(
            id = "nt_6_3_2",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.2 The Ejection",
            verseNum = 2,
            text = "This interaction caused Jupiter's semi-major axis to \"jump\" discretely, separating its orbit from Saturn's instantaneously and preventing the destruction of the terrestrial planets."
        ),
        Verse(
            id = "nt_6_3_3",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.2 The Ejection",
            verseNum = 3,
            text = "The consequence for the fifth giant planet was absolute: it was violently ejected from the solar system entirely, achieving escape velocity and being banished to the interstellar void as a free-floating rogue planet."
        ),
        Verse(
            id = "nt_6_3_4",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.2 The Ejection",
            verseNum = 4,
            text = "**The Conceptual Parallel:** This event is the supreme display of Jovian authority, perfectly mirroring the myth of Zeus defeating the monstrous Typhon."
        ),
        Verse(
            id = "nt_6_3_5",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.2 The Ejection",
            verseNum = 5,
            text = "When a massive, chaotic deity threatened the delicate stability of the inner realm, Zeus executed a decisive, forceful ejection."
        ),
        Verse(
            id = "nt_6_3_6",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.2 The Ejection",
            verseNum = 6,
            text = "Banishing a massive planet to the cold, lightless expanse of interstellar space is the literal equivalent of casting a primordial monstrosity into the deepest, inescapable pits of Tartarus."
        ),
        Verse(
            id = "nt_6_3_7",
            book = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapter = "5.2 The Ejection",
            verseNum = 7,
            text = "The inner solar system remained pristine solely because Zeus possessed the absolute gravitational mass to expel existential threats permanently."
        ),
        Verse(
            id = "nt_7_1_1",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "The localized environment of Jupiter further reinforces its status as the supreme architect."
        ),
        Verse(
            id = "nt_7_1_2",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "Proclus, in his Neoplatonic commentary on Plato's *Timaeus*, outlines the Demiurge's gifts to the cosmos."
        ),
        Verse(
            id = "nt_7_1_3",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "The Demiurge establishes the universe as a perfect, living entity governed by proportion, spherical shape, and divine, cyclical time."
        ),
        Verse(
            id = "nt_7_1_4",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "Jupiter operates as this Demiurge not just on a macro-solar scale, but perfectly within its own localized satellite system."
        ),
        Verse(
            id = "nt_7_2_1",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "6.1 The Laplace Resonance",
            verseNum = 1,
            text = "Jupiter’s three inner Galilean moons, Io, Europa, and Ganymede, are locked in a magnificent 4:2:1 mean-motion resonance, universally known as the Laplace resonance."
        ),
        Verse(
            id = "nt_7_2_2",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "6.1 The Laplace Resonance",
            verseNum = 2,
            text = "This relationship is governed by strict mathematical laws."
        ),
        Verse(
            id = "nt_7_2_3",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "6.1 The Laplace Resonance",
            verseNum = 3,
            text = "For every one orbit completed by Ganymede, Europa completes exactly two, and Io completes exactly four."
        ),
        Verse(
            id = "nt_7_2_4",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "6.1 The Laplace Resonance",
            verseNum = 4,
            text = "This creates a self-correcting, perfectly synchronized gravitational ballet."
        ),
        Verse(
            id = "nt_7_2_5",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "6.1 The Laplace Resonance",
            verseNum = 5,
            text = "The periodic alignments ensure that the moons exert regular gravitational tugs on one another, forcing their orbits to remain slightly eccentric."
        ),
        Verse(
            id = "nt_7_2_6",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "6.1 The Laplace Resonance",
            verseNum = 6,
            text = "This forced eccentricity, combined with Jupiter's immense gravity, generates immense tidal friction within the moons, melting Europa's subsurface ocean and powering the extreme, continuous volcanism on Io."
        ),
        Verse(
            id = "nt_7_2_7",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "6.1 The Laplace Resonance",
            verseNum = 7,
            text = "**The Conceptual Parallel:** The Jovian system is a microcosm of divine perfection."
        ),
        Verse(
            id = "nt_7_2_8",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "6.1 The Laplace Resonance",
            verseNum = 8,
            text = "Zeus does not merely rule blindly; he structures his immediate court through strict mathematical harmony."
        ),
        Verse(
            id = "nt_7_2_9",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "6.1 The Laplace Resonance",
            verseNum = 9,
            text = "The Laplace resonance is the physical embodiment of the Demiurgic gift of proportion."
        ),
        Verse(
            id = "nt_7_2_10",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "6.1 The Laplace Resonance",
            verseNum = 10,
            text = "It proves that the closer an entity is to Zeus, the more strictly it is bound by his divine laws."
        ),
        Verse(
            id = "nt_7_2_11",
            book = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapter = "6.1 The Laplace Resonance",
            verseNum = 11,
            text = "The moons exist in perpetual, orchestrated worship, their orbits maintained indefinitely by the supreme gravitational resonance of their creator, their very internal heat generated by his proximity."
        ),
        Verse(
            id = "nt_8_1_1",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "With the architecture of the solar system complete, the supreme deity assumes the role of ultimate protector and enforcer."
        ),
        Verse(
            id = "nt_8_1_2",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "In mythology, this role is symbolized by the Aegis, a divine, terror-inducing shield or breastplate wielded by Zeus."
        ),
        Verse(
            id = "nt_8_1_3",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "The Aegis is described as an impenetrable supernatural mantle capable of summoning storms, providing invincible defense, and striking paralyzing fear into the hearts of enemies."
        ),
        Verse(
            id = "nt_8_1_4",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "In astrophysics, the Aegis is not metaphorical; it is the most massive physical structure in the solar system: Jupiter's magnetosphere."
        ),
        Verse(
            id = "nt_8_2_1",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.1 The Invisible Mantle",
            verseNum = 1,
            text = "Jupiter possesses an internal dynamo powered by the rapid convection of liquid metallic hydrogen deep within its envelope."
        ),
        Verse(
            id = "nt_8_2_2",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.1 The Invisible Mantle",
            verseNum = 2,
            text = "This dynamo generates a magnetic field approximately 20,000 times stronger than Earth’s in terms of magnetic dipole moment."
        ),
        Verse(
            id = "nt_8_2_3",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.1 The Invisible Mantle",
            verseNum = 3,
            text = "The resulting magnetosphere is an immense, tear-shaped cavity carved out of the solar wind."
        ),
        Verse(
            id = "nt_8_2_4",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.1 The Invisible Mantle",
            verseNum = 4,
            text = "It extends up to 7 million kilometers towards the Sun, and its magnetotail is swept outward by the solar wind all the way to the orbit of Saturn, over 4 Astronomical Units away."
        ),
        Verse(
            id = "nt_8_2_5",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.1 The Invisible Mantle",
            verseNum = 5,
            text = "If it were visible to the naked eye from Earth, Jupiter's magnetosphere would appear five times larger than the full moon."
        ),
        Verse(
            id = "nt_8_2_6",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.1 The Invisible Mantle",
            verseNum = 6,
            text = "It is a highly active, lethal zone of trapped, high-energy charged particles."
        ),
        Verse(
            id = "nt_8_2_7",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.1 The Invisible Mantle",
            verseNum = 7,
            text = "Volcanic emissions from Io continually pump heavy sulfur and oxygen ions into the inner magnetosphere, creating the Io plasma torus and generating equatorial azimuthal currents exceeding 160 million amperes."
        ),
        Verse(
            id = "nt_8_2_8",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.1 The Invisible Mantle",
            verseNum = 8,
            text = "Any unshielded entity entering this realm is subjected to lethal doses of ionizing radiation, effectively destroying spacecraft electronics and biological matter in a matter of hours."
        ),
        Verse(
            id = "nt_8_3_1",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 1,
            text = "Astronomically, Jupiter has long been hailed as the \"shield\" of the Earth, using its massive gravity to capture or deflect incoming Long-Period Comets originating from the Oort Cloud."
        ),
        Verse(
            id = "nt_8_3_2",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 2,
            text = "It is a well-documented fact that Jupiter absorbs massive kinetic strikes that might otherwise threaten the inner solar system, famously demonstrated by its capture and destruction of Comet Shoemaker-Levy 9 in 1994."
        ),
        Verse(
            id = "nt_8_3_3",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 3,
            text = "However, advanced dynamical simulations have revealed a more complex and terrifying reality regarding Jupiter's role."
        ),
        Verse(
            id = "nt_8_3_4",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 4,
            text = "While Jupiter effectively shields the Earth from outer Oort cloud comets, its massive gravity also perturbs the orbits of Centaurs and Main Belt asteroids, actively driving some of these objects onto Earth-crossing collision courses."
        ),
        Verse(
            id = "nt_8_3_5",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 5,
            text = "The simulations demonstrate that if Jupiter were smaller, the impact rate on Earth would actually increase; but if Jupiter did not exist at all, the impact rate from asteroids would be significantly lower."
        ),
        Verse(
            id = "nt_8_3_6",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 6,
            text = "**The Conceptual Parallel:** This dual nature perfectly encapsulates the mythology of Zeus."
        ),
        Verse(
            id = "nt_8_3_7",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 7,
            text = "Zeus is the protector of mortals, but he is also the god of the thunderbolt."
        ),
        Verse(
            id = "nt_8_3_8",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 8,
            text = "The Magnetosphere is the literal Aegis, an immense, invisible mantle of power that envelops the god, radiating deadly energy that destroys any foreign body that dares approach."
        ),
        Verse(
            id = "nt_8_3_9",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 9,
            text = "Simultaneously, Jupiter clears the cosmic void of existential threats (Oort comets), but it actively hurls thunderbolts (asteroids) toward the inner worlds."
        ),
        Verse(
            id = "nt_8_3_10",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 10,
            text = "This ensures that the terrestrial planets are never entirely safe from the wrath of the heavens."
        ),
        Verse(
            id = "nt_8_3_11",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 11,
            text = "By modulating the impact rate, Jupiter dictates the evolutionary pressure on Earth."
        ),
        Verse(
            id = "nt_8_3_12",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 12,
            text = "It destroys, but in doing so, it creates the ecological niches necessary for new life to evolve following mass extinctions."
        ),
        Verse(
            id = "nt_8_3_13",
            book = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapter = "7.2 The Deflector and the Menace: Governing the Impact Rate",
            verseNum = 13,
            text = "The god protects, but demands absolute reverence under the perpetual threat of his gravitational thunderbolts."
        ),
        Verse(
            id = "nt_9_1_1",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 1,
            text = "The ancient Greek texts, acting as the foundational source code for Western mythological hierarchy, posited a linear succession: Uranus, then Cronus, then Zeus."
        ),
        Verse(
            id = "nt_9_1_2",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 2,
            text = "But this text was written in the dark."
        ),
        Verse(
            id = "nt_9_1_3",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 3,
            text = "It was written by observers who could track the slow transit of Saturn and the brightness of Jupiter, but who could not perceive the isotopic decay of Tungsten-182, the orbital mechanics of the Grand Tack, the composition of the dilute core, or the invisible, lethal expanse of the Jovian magnetosphere."
        ),
        Verse(
            id = "nt_9_1_4",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 4,
            text = "By upgrading the mythology to align strictly with the laws of astrophysics, cosmochemistry, and planetary dynamics, a new, logically unassailable narrative emerges."
        ),
        Verse(
            id = "nt_9_1_5",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 5,
            text = "1."
        ),
        Verse(
            id = "nt_9_1_6",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 6,
            text = "Primacy over Succession: Jupiter did not overthrow a predecessor; it was the absolute first planetary body to form."
        ),
        Verse(
            id = "nt_9_1_7",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 7,
            text = "Its core achieved pebble isolation mass and triggered runaway gas accretion within the first 1 million years of the solar system."
        ),
        Verse(
            id = "nt_9_1_8",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 8,
            text = "It split the solar nebula into two distinct isotopic reservoirs, separating the cosmos."
        ),
        Verse(
            id = "nt_9_1_9",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 9,
            text = "Therefore, Zeus is the primordial consciousness, the firstborn of Chaos, the original singularity of order."
        ),
        Verse(
            id = "nt_9_1_10",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 10,
            text = "2."
        ),
        Verse(
            id = "nt_9_1_11",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 11,
            text = "Assimilation over Lineage: The Juno data proves Jupiter possesses a dilute core, enriched with the heavy elements of the early solar system."
        ),
        Verse(
            id = "nt_9_1_12",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 12,
            text = "Just as Zeus swallowed Metis to absorb her wisdom and prevent succession, Jupiter swallowed the foundational building blocks of the solar nebula, dissolving them into itself to secure eternal dominance."
        ),
        Verse(
            id = "nt_9_1_13",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 13,
            text = "3."
        ),
        Verse(
            id = "nt_9_1_14",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 14,
            text = "Architect over Usurper: Jupiter did not simply inherit the universe; it built it."
        ),
        Verse(
            id = "nt_9_1_15",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 15,
            text = "Through its inward and outward migration (the Grand Tack), it annihilated the chaotic first-generation planets (the Titans), truncated the building blocks of the inner solar system, and defined the domains of the terrestrial worlds."
        ),
        Verse(
            id = "nt_9_1_16",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 16,
            text = "It used Saturn not as a father, but as a subordinate gravitational anchor to execute its design."
        ),
        Verse(
            id = "nt_9_1_17",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 17,
            text = "4."
        ),
        Verse(
            id = "nt_9_1_18",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 18,
            text = "Executioner over Diplomat: When the stability of the system was threatened by a fifth giant, Jupiter did not negotiate; it ejected the planet into the interstellar void (the Jumping-Jupiter scenario)."
        ),
        Verse(
            id = "nt_9_1_19",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 19,
            text = "This is the absolute power of Tartarus manifested in orbital mechanics."
        ),
        Verse(
            id = "nt_9_1_20",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 20,
            text = "5."
        ),
        Verse(
            id = "nt_9_1_21",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 21,
            text = "The Aegis over the Heavens: Jupiter cloaks itself in the largest continuous structure in the solar system, a lethal magnetosphere."
        ),
        Verse(
            id = "nt_9_1_22",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 22,
            text = "It protects the inner worlds from deep-space comets while simultaneously wielding the power to hurl asteroids toward Earth, acting as the ultimate arbiter of life and extinction."
        ),
        Verse(
            id = "nt_9_1_23",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 23,
            text = "The synthesis of these domains demonstrates an undeniable conceptual parallel."
        ),
        Verse(
            id = "nt_9_1_24",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 24,
            text = "If we are to map the divine to the celestial, the science is absolute: the entity of Jupiter is the supreme architect, the firstborn force, and the unwavering shield of our solar system."
        ),
        Verse(
            id = "nt_9_1_25",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 25,
            text = "The old scrolls were wrong, limited by the technology of their era."
        ),
        Verse(
            id = "nt_9_1_26",
            book = "Part VIII: Synthesis and Conclusion",
            chapter = "Chapter 1",
            verseNum = 26,
            text = "The astrophysical reality proves that Zeus (Jupiter) reigns supreme, not by right of succession, but by the absolute, incontrovertible laws of astrophysics."
        )
    )

    val newTestament = listOf(
        Book(
            title = "Executive Summary",
            chapters = listOf(
                Chapter(
                    title = "Chapter 1",
                    verses = newTestamentVerses.filter { it.book == "Executive Summary" && it.chapter == "Chapter 1" }
                )
            )
        ),
        Book(
            title = "Part I: The Legacy Codebase and the Limits of Antiquity",
            chapters = listOf(
                Chapter(
                    title = "Chapter 1",
                    verses = newTestamentVerses.filter { it.book == "Part I: The Legacy Codebase and the Limits of Antiquity" && it.chapter == "Chapter 1" }
                ),
                Chapter(
                    title = "1.1 The Hesiodic Error",
                    verses = newTestamentVerses.filter { it.book == "Part I: The Legacy Codebase and the Limits of Antiquity" && it.chapter == "1.1 The Hesiodic Error" }
                ),
                Chapter(
                    title = "1.2 The Orphic Patch and Stoic Physiologia",
                    verses = newTestamentVerses.filter { it.book == "Part I: The Legacy Codebase and the Limits of Antiquity" && it.chapter == "1.2 The Orphic Patch and Stoic Physiologia" }
                )
            )
        ),
        Book(
            title = "Part II: The Firstborn of Chaos: The Astrochemical Genesis",
            chapters = listOf(
                Chapter(
                    title = "Chapter 1",
                    verses = newTestamentVerses.filter { it.book == "Part II: The Firstborn of Chaos: The Astrochemical Genesis" && it.chapter == "Chapter 1" }
                ),
                Chapter(
                    title = "2.1 The Solar Nebula and the Frost Line",
                    verses = newTestamentVerses.filter { it.book == "Part II: The Firstborn of Chaos: The Astrochemical Genesis" && it.chapter == "2.1 The Solar Nebula and the Frost Line" }
                ),
                Chapter(
                    title = "2.2 Pebble Accretion and the Isolation Mass",
                    verses = newTestamentVerses.filter { it.book == "Part II: The Firstborn of Chaos: The Astrochemical Genesis" && it.chapter == "2.2 Pebble Accretion and the Isolation Mass" }
                ),
                Chapter(
                    title = "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom",
                    verses = newTestamentVerses.filter { it.book == "Part II: The Firstborn of Chaos: The Astrochemical Genesis" && it.chapter == "2.3 Juno Telemetry: The Dilute Core and the Assimilation of Wisdom" }
                )
            )
        ),
        Book(
            title = "Part III: The Isotopic Dichotomy: Cleaving the Cosmos",
            chapters = listOf(
                Chapter(
                    title = "Chapter 1",
                    verses = newTestamentVerses.filter { it.book == "Part III: The Isotopic Dichotomy: Cleaving the Cosmos" && it.chapter == "Chapter 1" }
                ),
                Chapter(
                    title = "3.1 The W-Mo Isotopic Signatures",
                    verses = newTestamentVerses.filter { it.book == "Part III: The Isotopic Dichotomy: Cleaving the Cosmos" && it.chapter == "3.1 The W-Mo Isotopic Signatures" }
                ),
                Chapter(
                    title = "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier",
                    verses = newTestamentVerses.filter { it.book == "Part III: The Isotopic Dichotomy: Cleaving the Cosmos" && it.chapter == "3.2 Hafnium-Tungsten Chronometry and the Jovian Barrier" }
                )
            )
        ),
        Book(
            title = "Part IV: The Gravitational Architect: The True Titanomachy",
            chapters = listOf(
                Chapter(
                    title = "Chapter 1",
                    verses = newTestamentVerses.filter { it.book == "Part IV: The Gravitational Architect: The True Titanomachy" && it.chapter == "Chapter 1" }
                ),
                Chapter(
                    title = "4.1 Type II Migration and the Grand Tack",
                    verses = newTestamentVerses.filter { it.book == "Part IV: The Gravitational Architect: The True Titanomachy" && it.chapter == "4.1 Type II Migration and the Grand Tack" }
                ),
                Chapter(
                    title = "4.2 Saturn's Subservience and the Reversal",
                    verses = newTestamentVerses.filter { it.book == "Part IV: The Gravitational Architect: The True Titanomachy" && it.chapter == "4.2 Saturn's Subservience and the Reversal" }
                )
            )
        ),
        Book(
            title = "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats",
            chapters = listOf(
                Chapter(
                    title = "Chapter 1",
                    verses = newTestamentVerses.filter { it.book == "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats" && it.chapter == "Chapter 1" }
                ),
                Chapter(
                    title = "5.1 The Nice Model and the Fifth Giant",
                    verses = newTestamentVerses.filter { it.book == "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats" && it.chapter == "5.1 The Nice Model and the Fifth Giant" }
                ),
                Chapter(
                    title = "5.2 The Ejection",
                    verses = newTestamentVerses.filter { it.book == "Part V: The Jumping-Jupiter Protocol: Banishing the Primordial Threats" && it.chapter == "5.2 The Ejection" }
                )
            )
        ),
        Book(
            title = "Part VI: The Galilean Court: Demiurgic Harmonies",
            chapters = listOf(
                Chapter(
                    title = "Chapter 1",
                    verses = newTestamentVerses.filter { it.book == "Part VI: The Galilean Court: Demiurgic Harmonies" && it.chapter == "Chapter 1" }
                ),
                Chapter(
                    title = "6.1 The Laplace Resonance",
                    verses = newTestamentVerses.filter { it.book == "Part VI: The Galilean Court: Demiurgic Harmonies" && it.chapter == "6.1 The Laplace Resonance" }
                )
            )
        ),
        Book(
            title = "Part VII: The Cosmic Aegis: Magnetospheric Supremacy",
            chapters = listOf(
                Chapter(
                    title = "Chapter 1",
                    verses = newTestamentVerses.filter { it.book == "Part VII: The Cosmic Aegis: Magnetospheric Supremacy" && it.chapter == "Chapter 1" }
                ),
                Chapter(
                    title = "7.1 The Invisible Mantle",
                    verses = newTestamentVerses.filter { it.book == "Part VII: The Cosmic Aegis: Magnetospheric Supremacy" && it.chapter == "7.1 The Invisible Mantle" }
                ),
                Chapter(
                    title = "7.2 The Deflector and the Menace: Governing the Impact Rate",
                    verses = newTestamentVerses.filter { it.book == "Part VII: The Cosmic Aegis: Magnetospheric Supremacy" && it.chapter == "7.2 The Deflector and the Menace: Governing the Impact Rate" }
                )
            )
        ),
        Book(
            title = "Part VIII: Synthesis and Conclusion",
            chapters = listOf(
                Chapter(
                    title = "Chapter 1",
                    verses = newTestamentVerses.filter { it.book == "Part VIII: Synthesis and Conclusion" && it.chapter == "Chapter 1" }
                )
            )
        )
    )

    fun getNewTestamentEquivalent(id: String?): Verse? {
        return newTestamentVerses.find { it.id == id }
    }
}
