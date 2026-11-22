# Changes

## 2.0.0
- Replaced hard-coded `VerseRepository` (7 volumes, every chapter titled "Chapter 1", broken
  cross-reference IDs) with a parsed `testimony.txt`: 12 volumes, 49 auto-numbered chapters.
- New Volume and Chapter screens, About screen, continue-reading, text size.
- Image slots for hero, every volume and every chapter.
- Removed unused Firebase AI, App Check (including the debug provider), Retrofit, OkHttp, Moshi,
  Room, KSP, Secrets and Google Services plugins.
- Release builds now minified and resource-shrunk; signing read from environment variables.
- Removed broken template tests; added parser and content tests.
