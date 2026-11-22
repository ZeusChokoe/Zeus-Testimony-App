# Google Play store assets

| File | Play Console field | Spec |
|---|---|---|
| `icon-512.png` | App icon | 512 x 512 PNG |
| `feature-graphic-1024x500.png` | Feature graphic | 1024 x 500 PNG |
| `screenshots/*.png` | Phone screenshots (upload 2 to 8) | 1080 x 1920 PNG |

Screenshots are produced by `ReaderFlowTest` (`./gradlew testDebugUnitTest`, output in
`app/build/screens/`). Copy them here after a content or design change.
