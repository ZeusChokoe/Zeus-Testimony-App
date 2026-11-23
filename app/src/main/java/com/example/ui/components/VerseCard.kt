package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Shader
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.core.content.FileProvider
import androidx.core.content.res.ResourcesCompat
import com.example.R
import java.io.File

/**
 * Renders a verse onto its chapter's artwork as a 1080 x 1350 image (the shape social apps prefer),
 * using the app's own fonts. Runs off the main thread; nothing leaves the device until the reader
 * chooses where to share it.
 */
object VerseCard {
    const val WIDTH = 1080
    const val HEIGHT = 1350

    fun render(context: Context, imagePath: String?, verse: String, reference: String): Bitmap {
        val out = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(out)
        canvas.drawColor(0xFF0F0F0F.toInt())

        imagePath?.let { AssetImageCache.load(context, it) }?.asAndroidBitmap()?.let { art ->
            // Centre-crop the artwork to fill the card.
            val scale = maxOf(WIDTH.toFloat() / art.width, HEIGHT.toFloat() / art.height)
            val w = (WIDTH / scale).toInt(); val h = (HEIGHT / scale).toInt()
            val src = Rect((art.width - w) / 2, (art.height - h) / 2, (art.width + w) / 2, (art.height + h) / 2)
            canvas.drawBitmap(art, src, Rect(0, 0, WIDTH, HEIGHT), Paint(Paint.FILTER_BITMAP_FLAG))
        }
        // Darken towards the bottom so the words stay readable on any artwork.
        canvas.drawRect(0f, 0f, WIDTH.toFloat(), HEIGHT.toFloat(), Paint().apply {
            shader = LinearGradient(0f, 0f, 0f, HEIGHT.toFloat(), 0x55000000, 0xF2000000.toInt(), Shader.TileMode.CLAMP)
        })

        val lora = ResourcesCompat.getFont(context, R.font.lora_italic)
        val cinzel = ResourcesCompat.getFont(context, R.font.cinzel_bold)
        val margin = 90
        val textWidth = WIDTH - margin * 2

        val versePaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply { color = 0xFFF5F2EA.toInt(); textSize = 58f; typeface = lora }
        val verseLayout = StaticLayout.Builder.obtain("“$verse”", 0, verse.length + 2, versePaint, textWidth)
            .setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(14f, 1f).build()

        val refPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply { color = 0xFFC9A227.toInt(); textSize = 34f; typeface = cinzel; letterSpacing = 0.05f }
        val refText = reference.uppercase()
        val refLayout = StaticLayout.Builder.obtain(refText, 0, refText.length, refPaint, textWidth).build()

        val namePaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply { color = 0xFFFFFFFF.toInt(); textSize = 40f; typeface = cinzel; letterSpacing = 0.1f }

        val bottom = HEIGHT - 120f
        val refTop = bottom - refLayout.height
        val verseTop = refTop - 40f - verseLayout.height
        canvas.save(); canvas.translate(margin.toFloat(), verseTop); verseLayout.draw(canvas); canvas.restore()
        canvas.save(); canvas.translate(margin.toFloat(), refTop); refLayout.draw(canvas); canvas.restore()
        canvas.drawText("THE ZEUS TESTIMONY", margin.toFloat(), 130f, namePaint)
        return out
    }

    /** Writes the card to the app's private cache and opens the share sheet. */
    fun share(context: Context, card: Bitmap, text: String) {
        val dir = File(context.cacheDir, "shared").apply { mkdirs() }
        val file = File(dir, "zeus-testimony-verse.png")
        file.outputStream().use { card.compress(Bitmap.CompressFormat.PNG, 100, it) }
        val uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
        val send = Intent(Intent.ACTION_SEND).apply {
            type = "image/png"
            putExtra(Intent.EXTRA_STREAM, uri)
            putExtra(Intent.EXTRA_TEXT, text)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        context.startActivity(Intent.createChooser(send, "Share verse").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }
}
