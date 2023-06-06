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
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material.icons.twotone.Close
import androidx.compose.material.icons.twotone.Exposure
import androidx.compose.material.icons.twotone.Remove
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
            .background(color = MaterialTheme.colorScheme.background)
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
                char = 'C',
                colorType = ColorOption.standard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.Clear)
                }
            )
            ButtonItem(
                char = '^',
                colorType = ColorOption.standard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addOperationChar("^"))
                }
            )
            ButtonItem(
                char = '%',
                colorType = ColorOption.standard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.Percent)
                }
            )
            ButtonItem(
                char = '/',
                colorType = ColorOption.primary,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addOperationChar("/"))
                }
            )
        }
        Row(
            modifier = Modifier
                .padding(bottom = breakSize)
        ) {
            ButtonItem(
                char = '7',
                colorType = ColorOption.secondStandard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addFigure("7"))
                }
            )
            ButtonItem(
                char = '8',
                colorType = ColorOption.secondStandard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addFigure("8"))
                }
            )
            ButtonItem(
                char = '9',
                colorType = ColorOption.secondStandard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addFigure("9"))
                }
            )
            ButtonItem(
                image = Icons.TwoTone.Close,
                colorType = ColorOption.primary,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addOperationChar("*"))
                }
            )
        }
        Row(
            modifier = Modifier
                .padding(bottom = breakSize)
        ) {
            ButtonItem(
                char = '4',
                colorType = ColorOption.secondStandard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addFigure("4"))
                }
            )
            ButtonItem(
                char = '5',
                colorType = ColorOption.secondStandard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addFigure("5"))
                }
            )
            ButtonItem(
                char = '6',
                colorType = ColorOption.secondStandard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addFigure("6"))
                }
            )
            ButtonItem(
                image = Icons.TwoTone.Remove,
                colorType = ColorOption.primary,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addOperationChar("-"))
                }
            )
        }
        Row(
            modifier = Modifier
                .padding(bottom = breakSize)
        ) {

            ButtonItem(
                char = '1',
                colorType = ColorOption.secondStandard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addFigure("4"))
                }
            )
            ButtonItem(
                char = '2',
                colorType = ColorOption.secondStandard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addFigure("5"))
                }
            )
            ButtonItem(
                char = '3',
                colorType = ColorOption.secondStandard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addFigure("6"))
                }
            )
            ButtonItem(
                image = Icons.TwoTone.Add,
                colorType = ColorOption.primary,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addOperationChar("+"))
                }
            )
        }
        Row(
            modifier = Modifier
                .padding(bottom = breakSize)
        ) {
            ButtonItem(
                char = '0',
                colorType = ColorOption.secondStandard,
                aspectRation = 2f,
                modifier = Modifier
                    .weight(2f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addFigure("0"))
                }
            )
            ButtonItem(
                char = '.',
                colorType = ColorOption.secondStandard,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.addOperationChar("."))
                }
            )
            ButtonItem(
                char = '=',
                colorType = ColorOption.accent,
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    viewModel.onEvent(CalculatorEvent.Result)
                }
            )
        }
    }
}