# System Architecture

## Overview
The application is built entirely on the Android platform using Kotlin and Jetpack Compose. 

## 1. Data Layer
- `VerseRepository.kt`: In-memory data store containing all 7 Volumes, Books, Chapters, and Verses. Modeled statically to ensure zero latency during reads.

## 2. UI Layer
- `HomeScreen.kt`: The entry point. A scrollable list of `VolumeCard`s presenting the 7 volumes.
- `ReaderScreen.kt`: The primary reading interface. Renders `Book`, `Chapter`, and `Verse` hierarchies. Includes a bottom-sheet interaction for scientific cross-referencing.

## 3. Navigation
- Uses `androidx.navigation.compose`. Routes defined in `Navigation.kt`.
