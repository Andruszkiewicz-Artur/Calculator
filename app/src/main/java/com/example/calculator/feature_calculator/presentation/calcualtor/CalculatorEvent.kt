package com.example.calculator.feature_calculator.presentation.calcualtor

sealed class CalculatorEvent {
    data class addFigure(val figure: String): CalculatorEvent()
    data class addOperationChar(val operationChar: String): CalculatorEvent()
    object Clear: CalculatorEvent()
    object Result: CalculatorEvent()
    object Percent: CalculatorEvent()
}
