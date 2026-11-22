package com.example.data

import android.content.Context

/** Loads and caches the bundled testimony. Fully offline: no network, no accounts. */
object TestimonyRepository {
    private const val ASSET = "testimony.txt"

    @Volatile private var cached: Testimony? = null

    /** Blocking; call from a background dispatcher. */
    fun load(context: Context): Testimony =
        cached ?: synchronized(this) {
            cached ?: context.applicationContext.assets.open(ASSET).bufferedReader().use {
                TestimonyParser.parse(it.readText())
            }.also { cached = it }
        }
}

/** Reading position and text size, stored locally in app-private SharedPreferences. */
class ReadingPrefs(context: Context) {
    private val prefs = context.applicationContext.getSharedPreferences("reading", Context.MODE_PRIVATE)

    var lastRead: Position?
        get() {
            val v = prefs.getInt(KEY_VOLUME, -1)
            val c = prefs.getInt(KEY_CHAPTER, -1)
            return if (v >= 0 && c >= 0) Position(v, c) else null
        }
        set(value) {
            prefs.edit().apply {
                if (value == null) { remove(KEY_VOLUME); remove(KEY_CHAPTER) }
                else { putInt(KEY_VOLUME, value.volume); putInt(KEY_CHAPTER, value.chapter) }
            }.apply()
        }

    var textScale: Float
        get() = prefs.getFloat(KEY_SCALE, 1f).coerceIn(MIN_SCALE, MAX_SCALE)
        set(value) = prefs.edit().putFloat(KEY_SCALE, value.coerceIn(MIN_SCALE, MAX_SCALE)).apply()

    companion object {
        const val MIN_SCALE = 0.85f
        const val MAX_SCALE = 1.45f
        private const val KEY_VOLUME = "volume"
        private const val KEY_CHAPTER = "chapter"
        private const val KEY_SCALE = "text_scale"
    }
}
