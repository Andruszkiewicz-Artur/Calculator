package com.example.calculator.feature_calculator.presentation.calcualtor.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.feature_calculator.presentation.calcualtor.CalculatorEvent
import com.example.calculator.feature_calculator.presentation.calcualtor.CalculatorViewModel

@Composable
fun Calculator(
    viewModel: CalculatorViewModel = hiltViewModel()
) {
    val width = LocalContext.current.resources.configuration.screenWidthDp
    val buttonSize = (width/5).dp
    val breakSize = buttonSize/5
    val fontSize = width/13
    var isHistory by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = breakSize)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = breakSize)
        ) {
            Icon(
                imageVector = Icons.Outlined.FormatListNumbered,
                contentDescription = null,
                modifier = Modifier
                    .size(fontSize.dp)
                    .clickable {
                        isHistory = true
                    }
            )
        }
        Text(
            text = viewModel.presentNumber.value,
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
                        viewModel.onEvent(CalculatorEvent.PlusMinus)
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
                        viewModel.onEvent(CalculatorEvent.Divide)
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
                        viewModel.onEvent(CalculatorEvent.addNumberToFiger("7"))
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
                        viewModel.onEvent(CalculatorEvent.addNumberToFiger("8"))
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
                        viewModel.onEvent(CalculatorEvent.addNumberToFiger("9"))
                    }
            )
            ButtonItem(
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = fontSize,
                image = Icons.Outlined.Close,
                modifier = Modifier
                    .size(buttonSize)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
                    .clickable {
                        viewModel.onEvent(CalculatorEvent.Multiply)
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
                        viewModel.onEvent(CalculatorEvent.addNumberToFiger("4"))
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
                        viewModel.onEvent(CalculatorEvent.addNumberToFiger("5"))
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
                        viewModel.onEvent(CalculatorEvent.addNumberToFiger("6"))
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
                        viewModel.onEvent(CalculatorEvent.Subtract)
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
                        viewModel.onEvent(CalculatorEvent.addNumberToFiger("1"))
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
                        viewModel.onEvent(CalculatorEvent.addNumberToFiger("2"))
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
                        viewModel.onEvent(CalculatorEvent.addNumberToFiger("3"))
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
                        viewModel.onEvent(CalculatorEvent.Add)
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
                        viewModel.onEvent(CalculatorEvent.addNumberToFiger("0"))
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
                        viewModel.onEvent(CalculatorEvent.Comma)
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

    if(isHistory) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(
                    color = Color.Black.copy(alpha = 0.3f)
                )
                .fillMaxSize()
                .clickable {
                    isHistory = false
                }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(0.7f)
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(40f)
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = RoundedCornerShape(40f)
                    )
                    .padding(10.dp)
            ) {
                if(viewModel.history.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        itemsIndexed(viewModel.history) { index, item ->
                            Text(
                                text = "${index + 1}. ${item.firstNumber} ${item.char} ${item.secondNumber} = ${item.result}".replace(".0", "")
                            )
                        }
                    }
                } else {
                    Text(
                        text = "History is empty right now!",
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}