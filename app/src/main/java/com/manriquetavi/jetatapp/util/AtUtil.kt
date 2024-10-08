package com.manriquetavi.jetatapp.util

import kotlinx.coroutines.delay
import kotlin.random.Random
import android.annotation.SuppressLint
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Locale

suspend fun delayShortTime() {
    val time = Random.nextInt(1500, 2500).toLong()
    delay(time)
}

suspend fun delayMediumTime() {
    val time = Random.nextInt(3500, 5500).toLong()
    delay(time)
}

suspend fun delayLongTime() {
    val time = Random.nextInt(6500, 8500).toLong()
    delay(time)
}

fun String.toTypeName() =
    when (this) {
        "System" -> "Multiple"
        "Simple" -> "Simple"
        else -> ""

}

fun formatDate(input: String): String {
    val originalFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val targetFormat = SimpleDateFormat("yyyy-MM-dd h:mma", Locale.getDefault())
    val date = originalFormat.parse(input)
    return targetFormat.format(date!!)
}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.coloredShadow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = composed {
    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparent = color.copy(alpha = 0f).toArgb()
    this.drawBehind {
        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparent
            frameworkPaint.setShadowLayer(
                shadowRadius.toPx(),
                offsetX.toPx(),
                offsetY.toPx(),
                shadowColor
            )
            it.drawRoundRect(
                0f,
                0f,
                this.size.width,
                this.size.height,
                borderRadius.toPx(),
                borderRadius.toPx(),
                paint
            )
        }
    }
}