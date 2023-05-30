package com.example.calculator.feature_calculator.presentation.calcualtor

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel (): ViewModel() {

    private val _state = mutableStateOf(CalculatorState())
    val state: State<CalculatorState> = _state

    var presentNumber = mutableStateOf("0")

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.addNumberToFiger -> {
                if(presentNumber.value == "0") {
                    _state.value = state.value.copy(
                        currentNumber = event.number
                    )
                } else {
                    if(_state.value.currentNumber.length < 10) {
                        _state.value = state.value.copy(
                            currentNumber = _state.value.currentNumber + event.number
                        )
                    } else {
//                        Toast.makeText(application, "Number can contains max 10 figures", Toast.LENGTH_LONG).show()
                    }
                }
            }
            is CalculatorEvent.Add -> {
                addOperator('+')
            }
            is CalculatorEvent.Subtract -> {
                addOperator('-')
            }
            is CalculatorEvent.Multiply -> {
                addOperator('*')
            }
            is CalculatorEvent.Divide -> {
                addOperator('/')
            }
            is CalculatorEvent.PlusMinus -> {
                if(_state.value.currentNumber != "0") {
                    _state.value = state.value.copy(
                        currentNumber = if(_state.value.currentNumber.first() == '-') _state.value.currentNumber.replace('-', ' ').toFloat().toString().replace(".0", "") else '-' + _state.value.currentNumber
                    )
                }
            }
            is CalculatorEvent.Clear -> {
                _state.value = state.value.copy(
                    currentNumber = "0"
                )
            }
            is CalculatorEvent.Comma -> {
                if(!_state.value.currentNumber.contains('.')) {
                    _state.value = state.value.copy(
                        currentNumber = _state.value.currentNumber + '.'
                    )
                }
            }
            is CalculatorEvent.Result -> {
                makeOperation()
            }
            is CalculatorEvent.Percent -> {
                _state.value = state.value.copy(
                    currentNumber = (_state.value.currentNumber.toFloat() / 100).toString().replace(".0", "")
                )
            }
        }

        if(event != CalculatorEvent.Result) {
            presentNumber.value = _state.value.currentNumber
        }
    }

    private fun addOperator(char: Char) {
        _state.value = state.value.copy(
            lastNumber = _state.value.currentNumber.toFloat(),
            currentNumber = "0",
            char = char
        )
        presentNumber.value = "0"
    }

    private fun makeOperation() {
        val fState = _state.value
        var result: Float = 0f

        when (fState.char) {
            '+' -> {
                result = fState.lastNumber + fState.currentNumber.toFloat()
                presentNumber.value = result.toString()
                resetState()
            }
            '-' -> {
                result = fState.lastNumber - fState.currentNumber.toFloat()
                presentNumber.value = result.toString()
                resetState()
            }
            '*' -> {
                result = fState.lastNumber * fState.currentNumber.toFloat()
                presentNumber.value = result.toString()
                resetState()
            }
            '/' -> {
                if (fState.currentNumber.toFloat() == 0f) {
//                    Toast.makeText(application, "You can`t divide via 0", Toast.LENGTH_LONG).show()
                } else {
                    result = fState.lastNumber / fState.currentNumber.toFloat()
                    resetState()
                }
            }
            else -> {
//                Toast.makeText(application, "You need write new sentence", Toast.LENGTH_LONG).show()
            }
        }

        presentNumber.value = result.toString().replace(".0", "")
    }

    private fun resetState() {
        _state.value = state.value.copy(
            lastNumber = 0f,
            currentNumber = "0",
            char = ' '
        )
    }
}