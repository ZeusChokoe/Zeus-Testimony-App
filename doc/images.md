# Illustrations

Drop files into `app/src/main/assets/images/` using **exactly** these names. Any image not yet
supplied shows a styled placeholder, so you can add them gradually. Run
`python3 tools/validate_testimony.py` to see how many are still missing.

## Specification
- Format: **WebP** (Android Studio: right-click image > Convert to WebP, quality 80).
- Size: any orientation. Images are stored at most 900 px wide and 1500 px tall. Chapter and volume headers show the WHOLE image framed over a blurred copy of itself, so portrait, square and landscape art all display uncropped. Volume list thumbnails crop toward the top.
- Weight: keep each under ~300 KB (the validator warns above 360 KB). The current 134 images total about 23 MB, well under Play's 200 MB AAB limit.
- Keep important subject matter in the centre; the volume list crops thumbnails to a tall strip.

## Rights (Play policy: Intellectual Property)
Only use images you created, licensed, or that are public domain. Most NASA imagery is not
copyrighted (https://www.nasa.gov/nasa-brand-center/images-and-media/), but NASA logos are restricted,
and ESA, ESO and Hubble/Webb images often require credit (CC BY 4.0). Add credits to the About screen
when you use them. AI-generated art is allowed; do not imitate a named living artist's style or a
film/game franchise.

## Slots
| File | Used for |
|---|---|
| `hero.webp` | Home screen header |
| `vol_01.webp` | **Volume 1**: The Unnamed Source |
| `v01_c01.webp` | Vol 1 Ch 1: The Silence Before Light |
| `v01_c02.webp` | Vol 1 Ch 2: The Spark of the Dying Star |
| `v01_c03.webp` | Vol 1 Ch 3: The Kindling of Helios |
| `v01_c05.webp` | Vol 1 Ch 4: The Witness Stones |
| `v01_c06.webp` | Vol 1 Ch 5: The Age Written in Lead |
| `v01_c07.webp` | Vol 1 Ch 6: The Seeds in the Cold |
| `v01_c08.webp` | Vol 1 Ch 7: The Lost Siblings of the Sun |
| `v01_c09.webp` | Vol 1 Ch 8: The Whisper of the First Light |
| `v01_c10.webp` | Vol 1 Ch 9: The Gold of Colliding Stars |
| `v01_c04.webp` | Vol 1 Ch 10: The Order of the Testimony |
| `vol_02.webp` | **Volume 2**: The Disk of Becoming |
| `v02_c01.webp` | Vol 2 Ch 1: The Spinning Veil |
| `v02_c02.webp` | Vol 2 Ch 2: The Line of Frost |
| `v02_c03.webp` | Vol 2 Ch 3: The Gathering of Pebbles |
| `v02_c05.webp` | Vol 2 Ch 4: The Race Against the Wind |
| `v02_c06.webp` | Vol 2 Ch 5: The Children of Other Stars |
| `v02_c07.webp` | Vol 2 Ch 6: The Giants Who Fell into the Fire |
| `v02_c08.webp` | Vol 2 Ch 7: The Gentle Gathering |
| `v02_c09.webp` | Vol 2 Ch 8: The Nursery in Orion |
| `v02_c10.webp` | Vol 2 Ch 9: The Woman Who Found the Hydrogen |
| `v02_c04.webp` | Vol 2 Ch 10: Wisdom of the Small Things |
| `vol_03.webp` | **Volume 3**: The Firstborn |
| `v03_c01.webp` | Vol 3 Ch 1: The Seed of the King |
| `v03_c02.webp` | Vol 3 Ch 2: The Claiming of the First World |
| `v03_c03.webp` | Vol 3 Ch 3: The Great Inhalation |
| `v03_c04.webp` | Vol 3 Ch 4: The Name Given by Men |
| `v03_c05.webp` | Vol 3 Ch 5: The Heart of the King |
| `v03_c06.webp` | Vol 3 Ch 6: The Weight of the King |
| `v03_c07.webp` | Vol 3 Ch 7: The Star That Was Not Lit |
| `v03_c08.webp` | Vol 3 Ch 8: The Year Star |
| `v03_c09.webp` | Vol 3 Ch 9: The King Who Measured Light |
| `v03_c10.webp` | Vol 3 Ch 10: The Flattened King |
| `vol_04.webp` | **Volume 4**: The Wall Between the Realms |
| `v04_c01.webp` | Vol 4 Ch 1: The Gap in the Disk |
| `v04_c02.webp` | Vol 4 Ch 2: The Two Treasuries |
| `v04_c03.webp` | Vol 4 Ch 3: The Keeper of the Boundary |
| `v04_c05.webp` | Vol 4 Ch 4: The Camps of the Trojan War |
| `v04_c06.webp` | Vol 4 Ch 5: The Unfinished World |
| `v04_c07.webp` | Vol 4 Ch 6: Ceres, the Dwarf at the Door |
| `v04_c08.webp` | Vol 4 Ch 7: The Iron Hearts |
| `v04_c09.webp` | Vol 4 Ch 8: The Stone Older Than the Sun |
| `v04_c10.webp` | Vol 4 Ch 9: The Stone from Mars |
| `v04_c04.webp` | Vol 4 Ch 10: The Wisdom of Boundaries |
| `vol_05.webp` | **Volume 5**: The Wandering of Giants |
| `v05_c01.webp` | Vol 5 Ch 1: The Descent Toward the Sun |
| `v05_c02.webp` | Vol 5 Ch 2: The Brother Who Came After |
| `v05_c03.webp` | Vol 5 Ch 3: The Turning of the Sail |
| `v05_c04.webp` | Vol 5 Ch 4: The Small Red World |
| `v05_c05.webp` | Vol 5 Ch 5: The Great Shuffle |
| `v05_c06.webp` | Vol 5 Ch 6: The Far Dark |
| `v05_c07.webp` | Vol 5 Ch 7: The Visitors from Other Stars |
| `v05_c08.webp` | Vol 5 Ch 8: The Sentinels of the Edge |
| `v05_c09.webp` | Vol 5 Ch 9: The World Found with a Pen |
| `v05_c10.webp` | Vol 5 Ch 10: The Giant That May Be Hiding |
| `vol_06.webp` | **Volume 6**: The Forging of Gaia |
| `v06_c01.webp` | Vol 6 Ch 1: The Rubble of the Inner Realm |
| `v06_c02.webp` | Vol 6 Ch 2: The Collision of Theia |
| `v06_c03.webp` | Vol 6 Ch 3: The Gift of Waters |
| `v06_c04.webp` | Vol 6 Ch 4: The Cooling of the Stones |
| `v06_c05.webp` | Vol 6 Ch 5: The Testimony of the Moon |
| `v06_c06.webp` | Vol 6 Ch 6: The Breath of the Small Ones |
| `v06_c07.webp` | Vol 6 Ch 7: The Day the Sky Fell |
| `v06_c08.webp` | Vol 6 Ch 8: The Stone of Africa |
| `v06_c09.webp` | Vol 6 Ch 9: The Snowball Earth |
| `v06_c10.webp` | Vol 6 Ch 10: The Cradle of Humankind |
| `vol_07.webp` | **Volume 7**: The Aegis |
| `v07_c01.webp` | Vol 7 Ch 1: The Shield Unseen |
| `v07_c02.webp` | Vol 7 Ch 2: The Day of the Twenty-One Fragments |
| `v07_c03.webp` | Vol 7 Ch 3: The Two Hands of the Shield |
| `v07_c05.webp` | Vol 7 Ch 4: The Watchers Who Saw the Scars |
| `v07_c06.webp` | Vol 7 Ch 5: The Arrow That Moved a Moon |
| `v07_c07.webp` | Vol 7 Ch 6: The Stones That Got Through |
| `v07_c08.webp` | Vol 7 Ch 7: The Watch of the Southern Sky |
| `v07_c09.webp` | Vol 7 Ch 8: The Comet Who Kept Its Promise |
| `v07_c10.webp` | Vol 7 Ch 9: The Day Apophis Comes Close |
| `v07_c04.webp` | Vol 7 Ch 10: The Wisdom of Protection |
| `vol_08.webp` | **Volume 8**: The Court of Moons |
| `v08_c01.webp` | Vol 8 Ch 1: Io the Burning |
| `v08_c02.webp` | Vol 8 Ch 2: Europa the Hidden Sea |
| `v08_c03.webp` | Vol 8 Ch 3: Ganymede the Greatest |
| `v08_c04.webp` | Vol 8 Ch 4: Callisto the Ancient Witness |
| `v08_c05.webp` | Vol 8 Ch 5: The Harmony of Four |
| `v08_c06.webp` | Vol 8 Ch 6: The Lesser Court |
| `v08_c07.webp` | Vol 8 Ch 7: The Breath of Europa |
| `v08_c08.webp` | Vol 8 Ch 8: The Lake of the Trickster |
| `v08_c09.webp` | Vol 8 Ch 9: The Dance of Tides |
| `v08_c10.webp` | Vol 8 Ch 10: The Shadows on the King |
| `v08_c11.webp` | Vol 8 Ch 11: The Engineer Who Saw a Volcano |
| `vol_09.webp` | **Volume 9**: The Storms of the Thunderer |
| `v09_c01.webp` | Vol 9 Ch 1: The Eye That Does Not Close |
| `v09_c02.webp` | Vol 9 Ch 2: The Bands of the Thunderer |
| `v09_c03.webp` | Vol 9 Ch 3: The Lightning of the Deep |
| `v09_c04.webp` | Vol 9 Ch 4: The Invisible Crown |
| `v09_c05.webp` | Vol 9 Ch 5: The Voice in the Radio Dark |
| `v09_c06.webp` | Vol 9 Ch 6: The Great Blue Spot |
| `v09_c07.webp` | Vol 9 Ch 7: The Rain of Helium |
| `v09_c08.webp` | Vol 9 Ch 8: The Lights at the Poles |
| `v09_c09.webp` | Vol 9 Ch 9: The Desert in the Clouds |
| `v09_c10.webp` | Vol 9 Ch 10: The Roots of the Winds |
| `vol_10.webp` | **Volume 10**: The Legacy Myths |
| `v10_c01.webp` | Vol 10 Ch 1: What the Ancients Sang |
| `v10_c02.webp` | Vol 10 Ch 2: The Swallowing Father |
| `v10_c03.webp` | Vol 10 Ch 3: The Error of Succession |
| `v10_c04.webp` | Vol 10 Ch 4: Why Men Remember Backwards |
| `v10_c05.webp` | Vol 10 Ch 5: The Sky Father of Many Nations |
| `v10_c06.webp` | Vol 10 Ch 6: The Eagle, the Oak and the Thunderbolt |
| `v10_c07.webp` | Vol 10 Ch 7: The Statue at Olympia |
| `v10_c08.webp` | Vol 10 Ch 8: Metis, the Swallowed Wisdom |
| `v10_c09.webp` | Vol 10 Ch 9: Prometheus and the Stolen Fire |
| `v10_c10.webp` | Vol 10 Ch 10: Io and the Hundred Eyes |
| `vol_11.webp` | **Volume 11**: The Watchers of the Sky |
| `v11_c01.webp` | Vol 11 Ch 1: The Wandering Star |
| `v11_c02.webp` | Vol 11 Ch 2: The Glass of Galileo |
| `v11_c03.webp` | Vol 11 Ch 3: The Messengers of Iron |
| `v11_c04.webp` | Vol 11 Ch 4: The Messengers Yet Travelling |
| `v11_c05.webp` | Vol 11 Ch 5: Your Own Watch |
| `v11_c06.webp` | Vol 11 Ch 6: The Night of the Great Conjunction |
| `v11_c07.webp` | Vol 11 Ch 7: The Messenger Who Chose to Fall |
| `v11_c08.webp` | Vol 11 Ch 8: The Eyes of the Karoo |
| `v11_c09.webp` | Vol 11 Ch 9: The Golden Record and the Pale Blue Dot |
| `v11_c10.webp` | Vol 11 Ch 10: The Man Who Rests on the Moon |
| `vol_12.webp` | **Volume 12**: The Book of Wisdom |
| `v12_c01.webp` | Vol 12 Ch 1: Proverbs of the Firstborn |
| `v12_c02.webp` | Vol 12 Ch 2: The Path of the Builder |
| `v12_c03.webp` | Vol 12 Ch 3: On Storms Within |
| `v12_c05.webp` | Vol 12 Ch 4: The Seven Disciplines |
| `v12_c06.webp` | Vol 12 Ch 5: The Book of Questions |
| `v12_c07.webp` | Vol 12 Ch 6: A Letter to the Reader |
| `v12_c08.webp` | Vol 12 Ch 7: The Daily Watch |
| `v12_c09.webp` | Vol 12 Ch 8: The Seasons of a Life |
| `v12_c10.webp` | Vol 12 Ch 9: The Courage to Begin |
| `v12_c04.webp` | Vol 12 Ch 10: The Final Anchor |

## Source of the current images
The 134 images were selected by the owner from their own supplied collection (November 2026) and
matched to each chapter's subject. Excluded from that collection: recognisable film, game and anime
characters (including lightsabers), nudity, religious symbols, and off-theme modern scenes. Small signatures on four images
were cropped. The owner is responsible for holding the rights to publish every image on Google Play.

**Permission status (22 November 2026):** the owner confirmed that the artists of the supplied
images gave permission for their use in this app. Keep that written permission (messages, emails or
screenshots of the replies) somewhere safe: it is your evidence if Google Play receives an
intellectual property complaint. The About screen credits the illustrations as used with permission.
