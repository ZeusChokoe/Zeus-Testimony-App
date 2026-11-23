# Changes

## 2.14.0
- Plain narration: chapter bodies now tell the story in plain words (Jupiter, the Sun, the solar system, astronomers, spacecraft). Poetic language stays in epigraphs, closing verses and the volume seals.
- Wisdom notes cut from about 140 to 48, so each one carries weight.
- Every chapter carries a "When" date, shown under its title.
- Timeline: all 146 chapters in the order they happen, grouped into eras from before the Sun to the far future.
- Glossary: the book's own names (the Firstborn, the hearth, the court, the watchers, the messengers) explained plainly.
- Listen: reads a chapter aloud with the phone's own offline text-to-speech voice.
- Share as image: turns a verse into a 1080 x 1350 card on its chapter's artwork.
- 5 new tests (16 in total); the content validator now requires a valid @when on every chapter.

## 2.13.0
- Repetition removed: 12 near-duplicate sentence pairs rewritten, the Galileo probe and Europa Clipper stories each told once with cross-references, "So the..." conclusions cut from 102 to 14, "In the year" openings varied.
- Volume XII recap chapters (which retold earlier volumes) replaced by "The Book of What Is to Come": the brightening Sun, Halley's return in 2061, the Milky Way and Andromeda, the red giant, the white ember, what will outlast us, and the last light.
- The content validator now fails the build on near-duplicate sentences across chapters.

## 2.12.0
- 7 new chapters (147 total): The Flood and the Stones (Deucalion and Pyrrha), The Sacred Truce (ekecheiria), The Sky Father of Many Nations (Dyeus, Dyaus Pita, Iuppiter, Tyr), The Eye Given for Wisdom (Odin), How the Sky God's Stories Were Won (Nyame and Anansi), The Golden Eye at the Edge of Time (James Webb), and The Messenger to the Hidden Sea (Europa Clipper).

## 2.11.0
- 8 new chapters (140 total): The Fall of Typhon, The Lord of Justice, The Giver of Rain, The Oracle in the Desert (Zeus-Ammon at Siwa), Ra and the Boat of the Sun, uNkulunkulu and the Reed, The Great Dying, and When the Red Eye Was First Seen.

## 2.10.0
- Volume XII recast from life advice into proverb, psalm and testimony: The Song of the Builder, The Psalm of the Storm, The Seven Witnesses, The Testimony Speaks, The Night Watch, The Ages of the Realm, and The First Gathering.

## 2.9.0
- New volume, "The Acts of the Sky Father" (11 chapters): Zeus's house and lineage told with honour, the freeing of the Cyclopes, the Titanomachy, the casting of lots, the law of the stranger (Baucis and Philemon), Zeus Horkios and the Zanes, the Muses, the eagle, oak and thunderbolt, the Statue at Olympia, Marduk and the Enuma Elish, and the thunder gods of many peoples (Thor, Perun, Indra, Shango).
- Seals: each volume carries a hidden verse revealed only when all its chapters have been read.
- Volume X recast from encouragement to revelation.
- Terms of Use expanded to 19 sections; Privacy Policy expanded; contact email thezeustower@gmail.com.

## 2.8.0
- Volume X rewritten as "The Image of the Stars: What You Are Made Of" (10 chapters on the star-forged elements of the human body, pressure and strength, Jupiter's restrained power, the unbroken line of life, conservation of matter, and the undying king and mortal reader). Greek myths of Zeus's family removed throughout.
- Privacy Policy and Terms of Use screen (About and home footer).
- Resume prompt on launch: "Pick up where you paused" with the exact verse, shown for 5 seconds.
- My Library gains a History tab.

## 2.7.0
- Deepened the remaining 34 six-verse chapters; every chapter now has at least 7 verses (990 verses total).

## 2.6.0
- First-launch introduction: four swipeable pages (the premise, the claim, how to read science versus myth, the reader tools) with Skip, and a way to re-open it from About.
- Deepened 27 of the shortest chapters with 3 to 5 new verses each (886 verses total), including Milankovitch cycles, Mercury's iron core, the Jack Hills zircons, Red Spot Junior, the polar cyclones, Io's lava temperatures and Juno's Galileo plaque.

## 2.5.0
- Fix: home screen volume cards stretched to the full height of portrait thumbnails; cards now have a fixed height.
- New LightModeTest renders the light theme.
- 12 new chapters (121 total, 792 verses): gold from neutron star collisions, Cecilia Payne, Jupiter's flattening, the Martian meteorite ALH84001, Planet Nine, the Cradle of Humankind, Apophis in 2029, Linda Morabito and Io's volcanoes, the depth of Jupiter's winds, Io and Argus, Eugene Shoemaker, and the Courage to Begin.

## 2.4.0
- 12 new story chapters (109 total, 720+ verses): the cosmic microwave background, the Orion Nebula, Romer and the speed of light, the Murchison meteorite, the discovery of Neptune, Snowball Earth, Halley's Comet, shadow transits, the Galileo probe's desert, Prometheus, the Golden Record and Pale Blue Dot, and the Seasons of a Life.

## 2.3.0
- Fonts bundled in the app (no Google Play services needed); OFL licences in /licenses.
- Every chapter epigraph rewritten for variety.
- 12 new chapters (97 total): the Sun's lost siblings, Arrokoth and the gentle gathering, the Year Star of ancient China, iron meteorites and the Hoba meteorite, the Oort Cloud, the Vredefort impact structure, the ATLAS watch at Sutherland, tidal heating, Jupiter's auroras, Metis and Athena, SALT and MeerKAT, and the Daily Watch.
- Store assets in /store; About screen credits.

## 2.2.0
- 24 new chapters (85 total, 559 verses): Patterson and the age of the Earth, organic molecules in space, HL Tauri, hot Jupiters, the Sun-Jupiter barycentre, why Jupiter is not a star, the asteroid belt, Ceres, the Kuiper Belt and Pluto, interstellar visitors, the Great Oxidation, Chicxulub, DART, Tunguska and Chelyabinsk, Europa's plumes, Loki Patera, the Great Blue Spot, helium rain, the signs of Zeus, the Statue at Olympia, the 2020 Great Conjunction, Galileo's final plunge, the Book of Questions, and a letter to the reader.
- Illustrations for every volume and chapter (98), framed by orientation.

## 2.1.0
- applicationId is now `com.zeusfactor.zeustestimony`.
- 12 new chapters (61 total) and an opening epigraph for every chapter.
- Bookmarks, highlights, My Library, search, verse of the day, reading progress, copy and share.

## 2.0.0
- Replaced hard-coded `VerseRepository` (7 volumes, every chapter titled "Chapter 1", broken
  cross-reference IDs) with a parsed `testimony.txt`: 12 volumes, 49 auto-numbered chapters.
- New Volume and Chapter screens, About screen, continue-reading, text size.
- Image slots for hero, every volume and every chapter.
- Removed unused Firebase AI, App Check (including the debug provider), Retrofit, OkHttp, Moshi,
  Room, KSP, Secrets and Google Services plugins.
- Release builds now minified and resource-shrunk; signing read from environment variables.
- Removed broken template tests; added parser and content tests.
