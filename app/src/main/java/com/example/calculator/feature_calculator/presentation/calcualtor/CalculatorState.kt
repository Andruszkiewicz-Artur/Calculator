package com.example.calculator.feature_calculator.presentation.calcualtor

data class CalculatorState(
    val lastNumber: Float = 0f,
    val currentNumber: String = "0",
    val char: Char = ' '
)
