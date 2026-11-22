package com.example.ui.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.LruCache
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.concurrent.ConcurrentHashMap

/**
 * Bitmap loader for images bundled in assets/images/. Images are downsampled to at most
 * [MAX_WIDTH] px wide and kept in a memory-bounded LRU cache, so large source photos
 * cannot exhaust the heap on low-end devices.
 */
object AssetImageCache {
    private const val MAX_WIDTH = 1080
    private val missing = ConcurrentHashMap.newKeySet<String>()
    private val cache = object : LruCache<String, Bitmap>((Runtime.getRuntime().maxMemory() / 8).toInt()) {
        override fun sizeOf(key: String, value: Bitmap) = value.byteCount
    }

    fun peek(path: String?): ImageBitmap? = path?.let { cache.get(it)?.asImageBitmap() }

    fun load(context: Context, path: String): ImageBitmap? {
        cache.get(path)?.let { return it.asImageBitmap() }
        if (path in missing) return null
        val assetPath = "images/$path"
        return try {
            val assets = context.applicationContext.assets
            val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            assets.open(assetPath).use { BitmapFactory.decodeStream(it, null, bounds) }
            var sample = 1
            while (bounds.outWidth / (sample * 2) >= MAX_WIDTH) sample *= 2
            val opts = BitmapFactory.Options().apply { inSampleSize = sample }
            val bitmap = assets.open(assetPath).use { BitmapFactory.decodeStream(it, null, opts) }
            if (bitmap == null) { missing += path; null }
            else { cache.put(path, bitmap); bitmap.asImageBitmap() }
        } catch (_: IOException) {
            missing += path
            null
        } catch (_: OutOfMemoryError) {
            null
        }
    }
}

/**
 * Shows an image from assets/images/, or [fallback] drawn over a themed gradient when the
 * image has not been supplied yet. Missing images never crash the reader.
 */
@Composable
fun AssetImage(
    path: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    framed: Boolean = false,
    cropAlignment: Alignment = Alignment.Center,
    fallback: @Composable BoxScope.() -> Unit = {},
) {
    val context = LocalContext.current
    val bitmap by produceState(initialValue = AssetImageCache.peek(path), path) {
        if (value == null && path != null) {
            value = withContext(Dispatchers.IO) { AssetImageCache.load(context, path) }
        }
    }
    Box(modifier) {
        val image = bitmap
        if (image != null && framed) {
            FramedArtwork(image, contentDescription)
        } else if (image != null) {
            Image(
                bitmap = image,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                alignment = cropAlignment,
                modifier = Modifier.fillMaxSize(),
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            listOf(
                                MaterialTheme.colorScheme.tertiary,
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary,
                            ),
                        ),
                    ),
                contentAlignment = Alignment.Center,
                content = fallback,
            )
        }
    }
}

/**
 * Shows the whole artwork in its own shape (portrait, square or landscape), never cropped,
 * over a darkened and blurred copy of itself, with a thin gold frame.
 * Blur needs Android 12+; older devices get the darkened backdrop without blur.
 */
@Composable
private fun BoxScope.FramedArtwork(image: ImageBitmap, contentDescription: String?) {
    val ratio = image.width.toFloat() / image.height.coerceAtLeast(1)
    Image(
        bitmap = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize().blur(28.dp),
    )
    Box(Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.55f)))
    Image(
        bitmap = image,
        contentDescription = contentDescription,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .align(Alignment.Center)
            .padding(horizontal = 20.dp, vertical = 18.dp)
            .aspectRatio(ratio, matchHeightConstraintsFirst = true)
            .shadow(16.dp, RoundedCornerShape(4.dp))
            .clip(RoundedCornerShape(4.dp))
            .border(1.dp, Color(0xFFC9A227).copy(alpha = 0.7f), RoundedCornerShape(4.dp)),
    )
    Box(
        Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(28.dp)
            .background(Brush.verticalGradient(listOf(Color.Transparent, MaterialTheme.colorScheme.background))),
    )
}
