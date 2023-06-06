package com.example.calculator.feature_calculator.presentation.calcualtor.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.twotone.Close
import androidx.compose.material.icons.twotone.Exposure
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.feature_calculator.presentation.calcualtor.CalculatorEvent
import com.example.calculator.feature_calculator.presentation.calcualtor.CalculatorViewModel

@Composable
fun Calculator(
    viewModel: CalculatorViewModel
) {
    val width = LocalContext.current.resources.configuration.screenWidthDp
    val buttonSize = (width/5).dp
    val breakSize = buttonSize/5
    val fontSize = width/13

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = breakSize)
    ) {
        Text(
            text = viewModel.task.value,
            fontSize = (fontSize * 1.75).sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(buttonSize / 5),
            textAlign = TextAlign.End,
            color = MaterialTheme.colorScheme.onBackground
        )

        Row(
            modifier = Modifier
                .padding(bottom = breakSize)
        ) {
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = fontSize,
                char = 'C',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.Clear)
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = fontSize,
                image = Icons.TwoTone.Exposure,
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addOperationChar("+"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = fontSize,
                char = '%',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.Percent)
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = fontSize,
                char = '/',
                modifier = Modifier
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addOperationChar("/"))
                    }
            )
        }
        Row(
            modifier = Modifier
                .padding(bottom = breakSize)
        ) {
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = fontSize,
                char = '7',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addFigure("7"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = fontSize,
                char = '8',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addFigure("8"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = fontSize,
                char = '9',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addFigure("9"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = fontSize,
                image = Icons.TwoTone.Close,
                modifier = Modifier
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addOperationChar("*"))
                    }
            )
        }
        Row(
            modifier = Modifier
                .padding(bottom = breakSize)
        ) {
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = fontSize,
                char = '4',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addFigure("4"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = fontSize,
                char = '5',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addFigure("5"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = fontSize,
                char = '6',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addFigure("6"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = fontSize,
                image = Icons.Outlined.Remove,
                modifier = Modifier
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addOperationChar("-"))
                    }
            )
        }
        Row(
            modifier = Modifier
                .padding(bottom = breakSize)
        ) {
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = fontSize,
                char = '1',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addFigure("1"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = fontSize,
                char = '2',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addFigure("2"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = fontSize,
                char = '3',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addFigure("3"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = fontSize,
                image = Icons.Outlined.Add,
                modifier = Modifier
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addOperationChar("+"))
                    }
            )
        }
        Row(
            modifier = Modifier
                .padding(bottom = breakSize)
        ) {
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = fontSize,
                char = '0',
                modifier = Modifier
                    .padding(end = breakSize)
                    .height(buttonSize)
                    .width((buttonSize * 2) + breakSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addFigure("0"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = fontSize,
                char = ',',
                modifier = Modifier
                    .padding(end = breakSize)
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.addOperationChar("."))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onTertiary,
                fontSize = fontSize,
                char = '=',
                modifier = Modifier
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.Result)
                    }
            )
        }
    }
}