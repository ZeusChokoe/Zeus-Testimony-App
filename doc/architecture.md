# Architecture

Offline, single-activity Jetpack Compose reader. No network, accounts, analytics, ads or database.

## Content (`app/src/main/assets/testimony.txt`)
The entire book is one plain-text file. Format is documented at the top of the file.
Volumes, chapters and verses are numbered **by position**, never by hand. This is what fixed the
old bug where every volume showed only "Chapter 1": numbering can no longer drift from content.

Edit the text, then run `python3 tools/validate_testimony.py` before building.

## Data layer (`com.example.data`)
- `Testimony.kt` - immutable model: `Volume -> Chapter -> Verse -> Note`, plus `next/previous`
  navigation that crosses volume boundaries.
- `TestimonyParser.kt` - strict parser; errors report the line number. Image names are whitelisted
  (`[A-Za-z0-9_-]` + `.webp/.png/.jpg`), blocking asset path traversal.
- `TestimonyRepository.kt` - loads and caches the file once, off the main thread.
  `ReadingPrefs` stores last-read chapter and text size in app-private SharedPreferences.

## UI layer (`com.example.ui`)
- `Navigation.kt` - routes: `home`, `volume/{volume}`, `chapter/{volume}/{chapter}`, `about`.
  Indexes are typed Int args and bounds-checked; invalid ones show "not found" instead of crashing.
- `HomeScreen` - hero, continue-reading card, volume list.
- `VolumeScreen` - volume illustration, summary, chapter list.
- `ChapterScreen` - chapter illustration, numbered verses, colour-coded commentary, text-size control,
  previous/next chapter.
- `AboutScreen` - fiction/science disclaimer, sources, privacy statement.
- `components/AssetImage.kt` - downsampling (max 1080 px wide), LRU-cached asset image loader.
  Missing images render a themed gradient placeholder, so the app ships safely before art exists.

## Images
See `doc/images.md`.
