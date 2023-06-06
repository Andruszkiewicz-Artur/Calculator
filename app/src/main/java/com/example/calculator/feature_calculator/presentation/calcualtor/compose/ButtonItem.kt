package com.example.calculator.feature_calculator.presentation.calcualtor.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonItem(
    char: Char? = null,
    image: ImageVector? = null,
    colorType: ColorOption,
    aspectRation: Float = 1f,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val color = colorType(type = colorType)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(8.dp)
            .clip(CircleShape)
            .background(
                color = color.second
            )
            .aspectRatio(aspectRation)
            .clickable {
                onClick()
            }
            .then(modifier)
    ) {
        if (char != null) {
            Text(
                text = char.toString(),
                fontSize = 36.sp,
                color = color.first
            )
        } else if (image != null){
            Icon(
                imageVector = image,
                contentDescription = null,
                tint = color.first,
                modifier = Modifier
                    .size(36.dp)
            )
        }
    }
}

@Composable
private fun colorType(type: ColorOption): Pair<Color, Color> {
    when (type) {
        ColorOption.standard -> return Pair(colorScheme.onSecondaryContainer, colorScheme.secondaryContainer)
        ColorOption.secondStandard -> return Pair(colorScheme.onSurfaceVariant, colorScheme.surfaceVariant)
        ColorOption.primary -> return Pair(colorScheme.onPrimary, colorScheme.primary)
        ColorOption.accent -> return Pair(colorScheme.onSecondary, colorScheme.secondary)
    }
}

enum class ColorOption {
    standard, secondStandard, primary, accent
}