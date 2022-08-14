package com.example.calculator.feature_calculator.presentation.calcualtor

sealed class CalculatorEvent {
    data class addNumberToFiger(val number: String): CalculatorEvent()
    object Add: CalculatorEvent()
    object Subtract: CalculatorEvent()
    object Multiply: CalculatorEvent()
    object Divide: CalculatorEvent()
    object PlusMinus: CalculatorEvent()
    object Clear: CalculatorEvent()
    object Comma: CalculatorEvent()
    object Result: CalculatorEvent()
    object Percent: CalculatorEvent()
}
