package com.example.calculator.feature_calculator.presentation.calcualtor

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calculator.feature_calculator.unit.calculation.isInteger
import com.example.calculator.feature_calculator.unit.calculation.resultOfTask

class CalculatorViewModel: ViewModel() {

    val history: MutableList<String> = mutableListOf()

    var task = mutableStateOf("0")

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.addFigure -> {
                if(task.value != "0") {
                    task.value += event.figure
                } else {
                    task.value = event.figure
                }
            }
            is CalculatorEvent.addOperationChar -> {
                if (isInteger(task.value.last().toString())) {
                    if (task.value != "0" || event.operationChar == ".") {
                        task.value += event.operationChar
                    } else {
                        if (event.operationChar == "-") {
                            task.value = event.operationChar
                        }
                    }
                }
            }
            is CalculatorEvent.Result -> {
                val result = resultOfTask(task.value)

                if (result != null) {
                    if(history.count() > 5) history.removeFirst()
                    history.add("${task.value} = $result")
                    task.value = result
                }
            }
            is CalculatorEvent.Percent -> {
                val value = resultOfTask(task.value)
                val result = resultOfTask(value + "/100")

                if (result != null) {
                    history.add("(${task.value})%")
                    task.value = result
                }
            }
            CalculatorEvent.Clear -> {
                task.value = "0"
            }
        }
    }
}