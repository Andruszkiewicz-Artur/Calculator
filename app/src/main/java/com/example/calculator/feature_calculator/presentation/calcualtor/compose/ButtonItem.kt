package com.example.calculator.feature_calculator.presentation.calcualtor.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonItem(
    char: Char? = null,
    image: ImageVector? = null,
    color: Color,
    fontSize: Int,
    modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        if (char != null) {
            Text(
                text = char.toString(),
                fontSize = fontSize.sp,
                color = color
            )
        } else if (image != null){
            Icon(
                imageVector = image,
                contentDescription = null,
                tint = color,
                modifier = Modifier
                    .size(fontSize.dp)
            )
        }
    }
}