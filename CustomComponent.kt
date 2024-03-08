package com.example.tutorial

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*


@Composable
fun CustomComponent(
    canvasSize: Dp = 300.dp,
    indicatorValue: Float = 0f,
    maxIndicatorValue: Float = 100f,
    backgroundIndicatorColor: Color = MaterialTheme.colorScheme.onSurface,
    backgroundIndicatorStrokeWidth: Float = 100f,
    foregroundIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    foregroundIndicatorStrokeWidth: Float = 100f
){
    var allowedValue by remember { mutableFloatStateOf(maxIndicatorValue) }
    allowedValue = if (indicatorValue <= maxIndicatorValue) indicatorValue else maxIndicatorValue

    val animatedIndicatorValue = remember { Animatable(initialValue = indicatorValue) }
    LaunchedEffect(key1 = indicatorValue){
        animatedIndicatorValue.animateTo(targetValue = allowedValue,
            animationSpec = tween(durationMillis = 1000)
        )
    }
    val percentage = (animatedIndicatorValue.value / maxIndicatorValue) * 100
    val sweepAngle = 2.4 * percentage

    Column (
        modifier = Modifier
            .size(canvasSize)
            .drawBehind {
                val componentSize = size / 1.25f
                backgroundIndicator(
                    componentSize = componentSize,
                    backgroundIndicatorColor = backgroundIndicatorColor,
                    backgroundIndicatorStrokeWidth = backgroundIndicatorStrokeWidth
                )

                foregroundIndicator(
                    componentSize = componentSize,
                    sweepAngle = sweepAngle.toFloat(),
                    foregroundIndicatorColor = foregroundIndicatorColor,
                    foregroundStrokeWidth = foregroundIndicatorStrokeWidth
                )
            }
    ){

    }
}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    backgroundIndicatorColor: Color,
    backgroundIndicatorStrokeWidth: Float
){
    drawArc(
        color = backgroundIndicatorColor,
        size = componentSize,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        alpha = 1.25f,
        style = Stroke(
            width = backgroundIndicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width)/2,
            y = (size.height - componentSize.height)/2
        )
    )
}

fun DrawScope.foregroundIndicator(
    sweepAngle: Float,
    componentSize: Size,
    foregroundIndicatorColor: Color,
    foregroundStrokeWidth: Float
){
    drawArc(
        color = foregroundIndicatorColor,
        size = componentSize,
        startAngle = 150f,
        sweepAngle = sweepAngle,
        useCenter = false,
        alpha = 1.25f,
        style = Stroke(
            width = foregroundStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width)/2,
            y = (size.height - componentSize.height)/2
        )
    )
}

@Composable
@Preview(showBackground = true)
fun CustomComponentPreview(){
    CustomComponent()
}