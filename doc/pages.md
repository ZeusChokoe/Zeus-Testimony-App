# Page Inventory

## 1. HomeScreen (`home`)
- **Purpose**: Entry point for the application. Displays the epic Zeus Testimony branding and a scrollable list of all 7 Sacred Volumes.
- **Components**: `VolumeCard`

## 2. ReaderScreen (`reader/{volumeId}`)
- **Purpose**: Displays the hierarchical text (Books -> Chapters -> Verses) of the selected Volume.
- **Interactions**: Tapping a verse in Volume 1 reveals its scientific equivalent (if one is mapped) using a `ModalBottomSheet`.
