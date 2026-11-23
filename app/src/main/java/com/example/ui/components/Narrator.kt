package com.example.ui.components

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

/**
 * Reads text aloud with the phone's own offline text-to-speech engine.
 * Nothing is recorded or sent anywhere; the engine is released when the screen closes.
 */
class Narrator(context: Context) {
    var speaking by mutableStateOf(false)
        private set
    var available by mutableStateOf(true)
        private set
    private var ready = false
    private var pending: List<String>? = null

    private val tts: TextToSpeech = TextToSpeech(context.applicationContext) { status ->
        ready = status == TextToSpeech.SUCCESS
        available = ready
        if (ready) {
            tts.language = Locale.UK
            pending?.let { speak(it) }
        }
        pending = null
    }

    init {
        tts.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {}
            override fun onDone(utteranceId: String?) { if (utteranceId == LAST) speaking = false }
            @Deprecated("Deprecated in Java")
            override fun onError(utteranceId: String?) { speaking = false }
        })
    }

    fun speak(parts: List<String>) {
        if (!ready) { pending = parts; speaking = true; return }
        tts.stop()
        parts.forEachIndexed { i, text ->
            val id = if (i == parts.lastIndex) LAST else "part$i"
            tts.speak(text, if (i == 0) TextToSpeech.QUEUE_FLUSH else TextToSpeech.QUEUE_ADD, null, id)
        }
        speaking = parts.isNotEmpty()
    }

    fun stop() {
        pending = null
        if (ready) tts.stop()
        speaking = false
    }

    fun release() {
        stop()
        tts.shutdown()
    }

    private companion object { const val LAST = "last" }
}

@Composable
fun rememberNarrator(): Narrator {
    val context = LocalContext.current
    val narrator = remember { Narrator(context) }
    DisposableEffect(narrator) { onDispose { narrator.release() } }
    return narrator
}
