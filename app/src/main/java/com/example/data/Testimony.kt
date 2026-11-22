package com.example.data

enum class NoteKind(val label: String) {
    SCIENCE("Science"),
    WISDOM("Wisdom"),
    MYTH("Myth"),
    HISTORY("History"),
    NOTE("Note");

    companion object {
        fun fromPrefix(prefix: String): NoteKind? =
            entries.firstOrNull { it.label.equals(prefix.trim(), ignoreCase = true) && it != NOTE }
    }
}

data class Note(val kind: NoteKind, val text: String)

data class Verse(val number: Int, val text: String, val notes: List<Note>)

data class Chapter(
    val volumeIndex: Int,
    val index: Int,
    val title: String,
    val image: String?,
    val verses: List<Verse>,
    val epigraph: String? = null,
) {
    val number: Int get() = index + 1
}

data class Volume(
    val index: Int,
    val title: String,
    val subtitle: String,
    val summary: String,
    val image: String?,
    val chapters: List<Chapter>,
    /** A hidden verse revealed only after every chapter of the volume has been read. */
    val seal: String? = null,
) {
    val number: Int get() = index + 1
    val numeral: String get() = toRoman(number)
}

/** A position in the testimony: volume index + chapter index (both zero-based). */
data class Position(val volume: Int, val chapter: Int)

class Testimony(val volumes: List<Volume>) {

    val chapterCount: Int = volumes.sumOf { it.chapters.size }
    val verseCount: Int = volumes.sumOf { v -> v.chapters.sumOf { it.verses.size } }

    fun volume(index: Int): Volume? = volumes.getOrNull(index)

    fun chapter(position: Position): Chapter? =
        volumes.getOrNull(position.volume)?.chapters?.getOrNull(position.chapter)

    /** Next chapter, crossing into the next volume when the current one ends. */
    fun next(position: Position): Position? {
        val vol = volume(position.volume) ?: return null
        if (position.chapter + 1 < vol.chapters.size) return position.copy(chapter = position.chapter + 1)
        val nextVol = (position.volume + 1 until volumes.size).firstOrNull { volumes[it].chapters.isNotEmpty() }
        return nextVol?.let { Position(it, 0) }
    }

    /** Previous chapter, crossing into the previous volume when at a volume start. */
    fun previous(position: Position): Position? {
        if (volume(position.volume) == null) return null
        if (position.chapter > 0) return position.copy(chapter = position.chapter - 1)
        val prevVol = (position.volume - 1 downTo 0).firstOrNull { volumes[it].chapters.isNotEmpty() }
        return prevVol?.let { Position(it, volumes[it].chapters.lastIndex) }
    }
}

fun toRoman(value: Int): String {
    require(value in 1..3999) { "Roman numerals support 1..3999, got $value" }
    val table = listOf(
        1000 to "M", 900 to "CM", 500 to "D", 400 to "CD", 100 to "C", 90 to "XC",
        50 to "L", 40 to "XL", 10 to "X", 9 to "IX", 5 to "V", 4 to "IV", 1 to "I",
    )
    var n = value
    return buildString {
        for ((amount, symbol) in table) while (n >= amount) { append(symbol); n -= amount }
    }
}
