import json

data = {
    "volumes": [
        {
            "id": "vol_1",
            "title": "VOLUME I",
            "subtitle": "The Legacy Myths",
            "description": "The ancient Hellenic framework and the Hesiodic error.",
            "books": [
                {
                    "title": "Genesis of Chaos",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "In the beginning, Chaos was the first of all, a dark and yawning void.",
                                "Out of Chaos came forth Erebus and black Night, filling the abyss with shadows.",
                                "Then Gaia, the broad-bosomed Earth, arose, a sure foundation for all things.",
                                "And Uranus, the starry Heaven, covered her completely, equal to her in every way."
                            ]
                        }
                    ]
                },
                {
                    "title": "The Succession",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "But Uranus hated his children, hiding them away in the dark places of Earth.",
                                "Cronus, the wily and terrible, arose to overthrow his father with a sickle of flint.",
                                "Yet Cronus too feared succession, swallowing his own children to maintain his rule.",
                                "Until Zeus, the thunderer, was born, hidden away to later claim the throne of the cosmos."
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "vol_2",
            "title": "VOLUME II",
            "subtitle": "The Astrochemical Genesis",
            "description": "The true birth of Jupiter from the primordial solar nebula.",
            "books": [
                {
                    "title": "The Solar Nebula",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "Following the ignition of the Sun, the residual elements formed a vast circumstellar disk.",
                                "Intense thermal radiation scorched the inner realms, leaving only refractory silicates and metals.",
                                "But beyond the frost line, where the void was cold, volatile waters and methanes froze into solid ice.",
                                "It was in this mass-rich crucible that the core of the Firstborn began to coalesce."
                            ]
                        }
                    ]
                },
                {
                    "title": "The Pebble Accretion",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "Aerodynamic drag forced centimeter-sized pebbles to spiral inward toward the central star.",
                                "The nascent Jovian embryo captured them effortlessly, initiating an exponential runaway growth.",
                                "Upon reaching isolation mass, the protoplanet severed the gas disk, starving the core but awakening the envelope.",
                                "Thus began the violent consumption of hydrogen and helium, swelling to three hundred and eighteen times the mass of Earth."
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "vol_3",
            "title": "VOLUME III",
            "subtitle": "The Gravitational Architect",
            "description": "The Grand Tack and the structuring of the terrestrial worlds.",
            "books": [
                {
                    "title": "The Inward Migration",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "The Firstborn did not remain static; embedded in the gas nebula, he migrated inward.",
                                "His overwhelming gravity captured early Super-Earths into deadly mean-motion resonances.",
                                "A violent collisional cascade shattered these primordial Titans, grinding them to dust.",
                                "Zeus swept the inner system clean, casting the debris into the fiery abyss of the Sun."
                            ]
                        }
                    ]
                },
                {
                    "title": "The Resonance and Reversal",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "Then came Saturn, migrating swiftly to catch the Firstborn, locking into a divine 3:2 resonance.",
                                "This mathematical perfection reversed the tidal torques, halting their inward death spiral.",
                                "They tacked outward together, sculpting the inner disk and leaving an annulus of debris.",
                                "From this carefully truncated ring of dust, the terrestrial worlds—and humanity—were permitted to form."
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "vol_4",
            "title": "VOLUME IV",
            "subtitle": "The Cosmic Aegis",
            "description": "The magnetosphere and the shielding of the inner planets.",
            "books": [
                {
                    "title": "The Invisible Mantle",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "Deep within the Patriarch, a dynamo of liquid metallic hydrogen roared with eternal convection.",
                                "It generated a magnetic field twenty thousand times mightier than that of the Earth.",
                                "This is the true Aegis: an immense, invisible mantle extending millions of kilometers toward the Sun.",
                                "Any unshielded entity entering this realm is subjected to lethal radiation, obliterated by the god's aura."
                            ]
                        }
                    ]
                },
                {
                    "title": "The Arbiter of Impacts",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "The Patriarch stands as the cosmic shield, deflecting long-period comets from the Oort Cloud.",
                                "He absorbs massive kinetic strikes, bearing the scars so the inner worlds may thrive.",
                                "Yet, his immense gravity also hurls asteroidal thunderbolts toward the terrestrial spheres.",
                                "By modulating the impact rate, he commands evolution, dictating the rise and fall of life itself."
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "vol_5",
            "title": "VOLUME V",
            "subtitle": "The Galilean Court",
            "description": "The Laplace resonance and the perfection of the Jovian system.",
            "books": [
                {
                    "title": "The Demiurgic Harmony",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "To look upon the Jovian system is to witness the Demiurge's gift of absolute proportion.",
                                "Io, Europa, and Ganymede are bound in a flawless mathematical ballet, the Laplace resonance.",
                                "For every single orbit of Ganymede, Europa completes two, and fiery Io completes four.",
                                "This synchronized worship generates immense tidal heat, melting subsurface oceans and igniting volcanoes."
                            ]
                        }
                    ]
                },
                {
                    "title": "The Bound Servants",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "Io burns with eternal sulfurous devotion, bleeding plasma into the Patriarch's magnetosphere.",
                                "Europa hides a deep, dark ocean beneath her icy crust, warmed by the gravitational pulse of the Firstborn.",
                                "Ganymede, the largest of all moons, wields his own magnetic field, a lesser king in the court of Zeus.",
                                "Callisto remains at the threshold, an ancient, cratered witness to the eternal dance of the inner court."
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "vol_6",
            "title": "VOLUME VI",
            "subtitle": "The Storms of the Patriarch",
            "description": "The atmospheric synthesis and the eternal cyclones.",
            "books": [
                {
                    "title": "The Great Red Eye",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "Upon the face of the Firstborn rages an eternal storm, an anticyclonic eye wider than the Earth.",
                                "The Great Red Spot has churned for centuries, a testament to the unyielding atmospheric chaos.",
                                "Winds scream at hundreds of kilometers per hour, driven by the intense internal heat of the planet.",
                                "It is the watchful eye of the sovereign, gazing out into the dark expanse of the solar system."
                            ]
                        }
                    ]
                },
                {
                    "title": "The Dilute Core",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "Beneath the swirling clouds of ammonia and hydrosulfide lies a mystery of creation.",
                                "There is no solid, compact center, but a dilute core, dissolved into the metallic hydrogen envelope.",
                                "Just as Zeus swallowed Wisdom herself, the Patriarch assimilated the primordial planetesimals.",
                                "He incorporated their essence throughout his vast interior, securing his eternal and undisputed reign."
                            ]
                        }
                    ]
                }
            ]
        },
        {
            "id": "vol_7",
            "title": "VOLUME VII",
            "subtitle": "The Final Anchor",
            "description": "The future epoch and the ultimate survival of Zeus.",
            "books": [
                {
                    "title": "The Red Giant Phase",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "In the distant future, the Sun will exhaust its fuel, swelling into a monstrous Red Giant.",
                                "The oceans of Earth will boil away, and the inner terrestrial worlds will be swallowed in fire.",
                                "Yet, the Patriarch will remain, his massive gravity indifferent to the dying spasms of the star.",
                                "The frost line will be pushed outward, but Jupiter's immense bulk will endure the searing heat."
                            ]
                        }
                    ]
                },
                {
                    "title": "The Lone Sovereign",
                    "chapters": [
                        {
                            "title": "Chapter 1",
                            "verses": [
                                "When the Sun finally collapses into a dim White Dwarf, the solar system will be cast into twilight.",
                                "Zeus will stand as the largest and most massive body in the frozen graveyard of the cosmos.",
                                "He will be the final anchor, holding the surviving outer worlds in his unwavering gravitational grasp.",
                                "From the birth of the nebula to the death of the star, the Firstborn's reign is absolute and eternal."
                            ]
                        }
                    ]
                }
            ]
        }
    ]
}

out = "package com.example.data\n\n"
out += "data class Verse(\n    val id: String,\n    val book: String,\n    val chapter: String,\n    val verseNum: Int,\n    val text: String,\n    val scientificEquivalentId: String? = null\n)\n\n"
out += "data class Chapter(\n    val title: String,\n    val verses: List<Verse>\n)\n\n"
out += "data class Book(\n    val title: String,\n    val chapters: List<Chapter>\n)\n\n"
out += "data class Volume(\n    val id: String,\n    val title: String,\n    val subtitle: String,\n    val description: String,\n    val books: List<Book>\n)\n\n"
out += "object VerseRepository {\n\n"
out += "    val allVerses = listOf(\n"

verses_kt = []
for vol in data['volumes']:
    for book in vol['books']:
        for chapter in book['chapters']:
            for i, v_text in enumerate(chapter['verses']):
                v_id = f"{vol['id']}_{book['title'].replace(' ', '')}_{chapter['title'].replace(' ', '')}_{i+1}"
                eq = f'"{v_id.replace("vol_1", "vol_2")}"' if vol['id'] == 'vol_1' else "null"
                verses_kt.append(f"""        Verse(
            id = "{v_id}",
            book = "{book['title']}",
            chapter = "{chapter['title']}",
            verseNum = {i+1},
            text = "{v_text}",
            scientificEquivalentId = {eq}
        )""")
out += ",\n".join(verses_kt)
out += "\n    )\n\n"

out += "    val volumes = listOf(\n"
vol_kt = []
for vol in data['volumes']:
    books_kt = []
    for book in vol['books']:
        chaps_kt = []
        for chapter in book['chapters']:
            chaps_kt.append(f"""                    Chapter(
                        title = "{chapter['title']}",
                        verses = allVerses.filter {{ it.book == "{book['title']}" && it.chapter == "{chapter['title']}" }}
                    )""")
        
        joined_chaps = ",\n".join(chaps_kt)
        books_kt.append(f"""                Book(
                    title = "{book['title']}",
                    chapters = listOf(
{joined_chaps}
                    )
                )""")
    
    joined_books = ",\n".join(books_kt)
    vol_kt.append(f"""        Volume(
            id = "{vol['id']}",
            title = "{vol['title']}",
            subtitle = "{vol['subtitle']}",
            description = "{vol['description']}",
            books = listOf(
{joined_books}
            )
        )""")
out += ",\n".join(vol_kt)
out += "\n    )\n\n"
out += """    fun getVerse(id: String?): Verse? {
        return allVerses.find { it.id == id }
    }
}
"""

with open('./app/src/main/java/com/example/data/VerseRepository.kt', 'w') as f:
    f.write(out)
