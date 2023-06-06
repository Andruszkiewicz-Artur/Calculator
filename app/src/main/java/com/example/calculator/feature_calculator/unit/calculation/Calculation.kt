package com.example.calculator.feature_calculator.unit.calculation

import android.util.Log
import com.example.calculator.feature_calculator.unit.calculation.OperationEnum.*

fun resultOfTask(task: String): String? {

    if(!isInteger(task.last().toString())) {
        Log.d("Problem with calcualte", "wrong task")
        return null
    }

    val numbersList = mutableListOf<Double>()
    val charsList = mutableListOf<OperationEnum>()
    var value = ""

    task.forEach {
        val str = it.toString()
        if (isInteger(str) || str == ".") {
            value += str
        } else {
            val operation = checkChar(it)

            if (operation != null) {
                charsList.add(operation)
            } else {
                Log.d("Problem with calculate", "problem with make char operation")
                return null
            }

            if (isNumber(value)) {
                numbersList.add(value.toDouble())
                value = ""
            } else {
                Log.d("Problem with calcualte", "problem with number")
                return null
            }
        }
    }

    if (isNumber(value)) {
        numbersList.add(value.toDouble())
        value = ""
    } else {
        Log.d("Problem with calculate", "problem with last number")
        return null
    }

    val size = charsList.count()

    for (i in 0 until size) {
        val index = witchOperation(charsList)

        numbersList[index] = countNumbers(
            numLeft = numbersList[index],
            numRight = numbersList[index + 1],
            operation = charsList[index]
        )

        numbersList.removeAt(index + 1)
        charsList.removeAt(index)

        Log.d("Operations", numbersList.toString())

    }

    val result = numbersList[0].toString().let {
        var newValue = it

        if(it.takeLast(2) == ".0") {
            newValue = it.replace(".0", "")
        }

        newValue
    }

    return result
}

private val integerChars = '0'..'9'

private fun isNumber(input: String): Boolean {
    var dotOccurred = 0
    return input.all { it in integerChars || it == '.' && dotOccurred++ < 1 }
}

fun isInteger(input: String) = input.all { it in integerChars }

private fun countNumbers(numLeft: Double, numRight: Double, operation: OperationEnum): Double {
    when (operation) {
        Addition -> return numLeft + numRight
        Subtraction -> return numLeft - numRight
        Multiplication -> return numLeft * numRight
        Division -> return numLeft / numRight
    }
}

private fun checkChar(char: Char): OperationEnum? {
    when (char) {
        '+' -> return Addition
        '-' -> return Subtraction
        '*' -> return Multiplication
        '/' -> return Division
    }

    return null
}

private fun witchOperation(list: MutableList<OperationEnum>): Int {
    val listOperationExecute: List<List<OperationEnum>> = listOf(
        listOf(Multiplication, Division)
    )

    listOperationExecute.forEach {
        list.forEachIndexed { index, operationEnum ->
            if (it.contains(operationEnum)) {
                return index
            }
        }
    }

    return 0
}