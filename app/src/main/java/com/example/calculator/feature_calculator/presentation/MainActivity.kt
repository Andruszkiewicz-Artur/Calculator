package com.example.calculator.feature_calculator.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.calculator.feature_calculator.presentation.calcualtor.CalculatorViewModel
import com.example.calculator.feature_calculator.presentation.calcualtor.compose.Calculator
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = CalculatorViewModel()

        setContent {
            CalculatorTheme {
                Calculator(
                    viewModel = viewModel
                )
            }
        }
    }
}