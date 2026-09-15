# Architectural Decisions

## 1. Static In-Memory Repository
- **Decision**: Keep the text payload strictly in-memory (`VerseRepository.kt`) as Kotlin objects instead of an SQLite/Room database or a local JSON file.
- **Reason**: The text payload is small enough that it doesn't incur a measurable memory footprint penalty, but using a static Kotlin object allows for 0-latency loads, synchronous UI rendering, and significantly less boilerplate/maintenance overhead than a Room DB for static read-only text.

## 2. Generic Navigation Routing
- **Decision**: Transition from hardcoded `reader/old` and `reader/new` routes to dynamic `reader/{volumeId}` routes.
- **Reason**: Allow seamless expansion to 7 volumes without adding redundant navigation paths in `AppNavigation.kt`.
