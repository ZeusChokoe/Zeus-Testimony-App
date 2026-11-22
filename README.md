# The Zeus Testimony

An offline Android reader (Kotlin, Jetpack Compose) for a 12-volume work of speculative mythology:
Jupiter, the first planet to form, and Zeus, the first god of the solar realm to hold a world.

- Content: `app/src/main/assets/testimony.txt` (format documented in the file header)
- Validate content: `python3 tools/validate_testimony.py`
- Illustrations: `doc/images.md`
- Architecture: `doc/architecture.md`
- Play Store submission: `doc/play-store-submission.md`
- Privacy policy: `doc/privacy-policy.md`

Build a release bundle: `./gradlew bundleRelease` (signing via env vars, see `app/build.gradle.kts`).
