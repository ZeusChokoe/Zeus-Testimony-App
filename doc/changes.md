# Changes

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
