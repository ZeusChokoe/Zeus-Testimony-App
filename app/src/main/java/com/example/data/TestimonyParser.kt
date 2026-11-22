package com.example.data

class TestimonyFormatException(line: Int, message: String) :
    IllegalArgumentException("testimony.txt line $line: $message")

/**
 * Parses the line-based testimony format documented at the top of assets/testimony.txt.
 * Volumes, chapters and verses are numbered by position, never by hand, so numbering
 * cannot drift out of sync with the content.
 */
object TestimonyParser {

    private val SAFE_IMAGE = Regex("^[A-Za-z0-9_\\-]+(/[A-Za-z0-9_\\-]+)*\\.(webp|png|jpg|jpeg)$")

    private class VerseB(val text: String) { val notes = mutableListOf<Note>() }
    private class ChapterB(val title: String) {
        var image: String? = null; var epigraph: String? = null
        val verses = mutableListOf<VerseB>()
    }
    private class VolumeB(val title: String) {
        var subtitle = ""; var summary = ""; var image: String? = null; var seal: String? = null
        val chapters = mutableListOf<ChapterB>()
    }

    fun parse(source: String): Testimony {
        val volumes = mutableListOf<VolumeB>()

        source.lineSequence().forEachIndexed { i, raw ->
            val lineNo = i + 1
            val line = raw.trim()
            if (line.isEmpty() || line.startsWith("#")) return@forEachIndexed

            val volume = volumes.lastOrNull()
            val chapter = volume?.chapters?.lastOrNull()

            when {
                line.startsWith("@") -> {
                    val key = line.substringBefore(' ').removePrefix("@").lowercase()
                    val value = line.substringAfter(' ', "").trim()
                    if (value.isEmpty()) throw TestimonyFormatException(lineNo, "@$key needs a value")
                    when (key) {
                        "volume" -> volumes += VolumeB(value)
                        "subtitle" -> (volume ?: fail(lineNo, "@subtitle before any @volume")).subtitle = value
                        "summary" -> (volume ?: fail(lineNo, "@summary before any @volume")).summary = value
                        "seal" -> (volume ?: fail(lineNo, "@seal before any @volume")).seal = value
                        "chapter" -> (volume ?: fail(lineNo, "@chapter before any @volume")).chapters += ChapterB(value)
                        "epigraph" -> (chapter ?: fail(lineNo, "@epigraph must follow a @chapter")).epigraph = value
                        "image" -> {
                            if (!SAFE_IMAGE.matches(value)) fail(lineNo, "unsafe or unsupported image name '$value'")
                            when {
                                chapter != null -> chapter.image = value
                                volume != null -> volume.image = value
                                else -> fail(lineNo, "@image before any @volume")
                            }
                        }
                        else -> fail(lineNo, "unknown directive @$key")
                    }
                }
                line.startsWith(">") -> {
                    val verse = chapter?.verses?.lastOrNull() ?: fail(lineNo, "commentary '>' before any verse")
                    verse.notes += parseNote(line.removePrefix(">").trim())
                }
                else -> {
                    val target = chapter ?: fail(lineNo, "verse before any @chapter")
                    target.verses += VerseB(line)
                }
            }
        }

        return Testimony(
            volumes.mapIndexed { vi, v ->
                Volume(
                    index = vi,
                    title = v.title,
                    subtitle = v.subtitle,
                    summary = v.summary,
                    image = v.image,
                    seal = v.seal,
                    chapters = v.chapters.mapIndexed { ci, c ->
                        Chapter(
                            volumeIndex = vi,
                            index = ci,
                            title = c.title,
                            image = c.image,
                            epigraph = c.epigraph,
                            verses = c.verses.mapIndexed { n, verse -> Verse(n + 1, verse.text, verse.notes.toList()) },
                        )
                    },
                )
            },
        )
    }

    private fun parseNote(body: String): Note {
        val prefix = body.substringBefore(':', "")
        val kind = if (prefix.isNotEmpty()) NoteKind.fromPrefix(prefix) else null
        return if (kind != null) Note(kind, body.substringAfter(':').trim()) else Note(NoteKind.NOTE, body)
    }

    private fun fail(line: Int, message: String): Nothing = throw TestimonyFormatException(line, message)
}
