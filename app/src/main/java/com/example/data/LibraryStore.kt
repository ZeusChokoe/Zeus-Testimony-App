package com.example.data

import android.content.Context
import androidx.compose.runtime.mutableStateMapOf
import org.json.JSONObject

/** A single verse address, zero-based volume/chapter and one-based verse number. */
data class VerseRef(val volume: Int, val chapter: Int, val verse: Int) {
    val position: Position get() = Position(volume, chapter)
    val key: String get() = "$volume.$chapter.$verse"

    companion object {
        fun parse(key: String): VerseRef? {
            val p = key.split('.')
            if (p.size != 3) return null
            val (v, c, n) = p.map { it.toIntOrNull() ?: return null }
            return VerseRef(v, c, n)
        }
    }
}

enum class HighlightColor(val argb: Long, val label: String) {
    GOLD(0xFFC9A227, "Gold"),
    CRIMSON(0xFFC00010, "Crimson"),
    SKY(0xFF3D7BD9, "Sky"),
    OLIVE(0xFF7A9A5B, "Olive"),
}

/**
 * Bookmarks, highlights and chapters read. Backed by Compose snapshot state so every screen
 * updates instantly, and persisted to app-private SharedPreferences as small JSON maps.
 * Entries pointing at verses that no longer exist are dropped on load, so editing
 * testimony.txt can never crash the app.
 */
class LibraryStore(context: Context, testimony: Testimony) {
    private val prefs = context.applicationContext.getSharedPreferences("library", Context.MODE_PRIVATE)

    /** verse key -> time bookmarked (epoch millis) */
    val bookmarks = mutableStateMapOf<String, Long>()

    /** verse key -> highlight colour */
    val highlights = mutableStateMapOf<String, HighlightColor>()

    /** "volume.chapter" -> time first opened */
    val readChapters = mutableStateMapOf<String, Long>()

    init {
        fun valid(ref: VerseRef?) = ref != null &&
            (testimony.chapter(ref.position)?.verses?.size ?: 0) >= ref.verse && ref.verse >= 1

        load(KEY_BOOKMARKS).forEach { (k, v) -> if (valid(VerseRef.parse(k))) (v as? Number)?.let { bookmarks[k] = it.toLong() } }
        load(KEY_HIGHLIGHTS).forEach { (k, v) ->
            val color = HighlightColor.entries.firstOrNull { it.name == v }
            if (color != null && valid(VerseRef.parse(k))) highlights[k] = color
        }
        load(KEY_READ).forEach { (k, v) ->
            val p = k.split('.').mapNotNull { it.toIntOrNull() }
            if (p.size == 2 && testimony.chapter(Position(p[0], p[1])) != null) (v as? Number)?.let { readChapters[k] = it.toLong() }
        }
    }

    fun isBookmarked(ref: VerseRef) = ref.key in bookmarks

    fun toggleBookmark(ref: VerseRef) {
        if (bookmarks.remove(ref.key) == null) bookmarks[ref.key] = System.currentTimeMillis()
        save(KEY_BOOKMARKS, bookmarks)
    }

    fun highlight(ref: VerseRef): HighlightColor? = highlights[ref.key]

    fun setHighlight(ref: VerseRef, color: HighlightColor?) {
        if (color == null) highlights.remove(ref.key) else highlights[ref.key] = color
        save(KEY_HIGHLIGHTS, highlights.mapValues { it.value.name })
    }

    fun markRead(position: Position) {
        val key = "${position.volume}.${position.chapter}"
        if (key !in readChapters) {
            readChapters[key] = System.currentTimeMillis()
            save(KEY_READ, readChapters)
        }
    }

    fun readCount(volume: Volume): Int = volume.chapters.count { "${volume.index}.${it.index}" in readChapters }

    private fun load(key: String): Map<String, Any?> = try {
        val json = JSONObject(prefs.getString(key, "{}") ?: "{}")
        json.keys().asSequence().associateWith { json.opt(it) }
    } catch (_: Exception) {
        emptyMap()
    }

    private fun save(key: String, map: Map<String, Any>) {
        prefs.edit().putString(key, JSONObject(map).toString()).apply()
    }

    private companion object {
        const val KEY_BOOKMARKS = "bookmarks"
        const val KEY_HIGHLIGHTS = "highlights"
        const val KEY_READ = "read"
    }
}
