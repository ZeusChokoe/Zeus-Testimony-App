# Data Subsystem

## Overview
The `VerseRepository` is the sole data provider for the application, representing the entire 7-volume framework.

## Structure
- **Volume**: A collection of Books (e.g., "The Galilean Court").
- **Book**: A collection of Chapters.
- **Chapter**: A collection of Verses.
- **Verse**: The atomic unit of text. Has an optional `scientificEquivalentId` for cross-referencing legacy myths with scientific truths.
