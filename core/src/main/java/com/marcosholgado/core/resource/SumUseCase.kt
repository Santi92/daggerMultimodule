package com.example.calculator.usecase


import com.sundevs.basecinemark.resource.StringsProvider



class SumUseCase constructor(
    val stringsProvider: StringsProvider
) {

    fun execute(firstNumber: Int, secondNumber: Int): Result {
        return if (firstNumber > 0 && secondNumber > 0) {
            Result.Success(firstNumber + secondNumber)
        } else {
           Result.Failure("Fallo")
        }
    }

    sealed class Result {
        class Success(val result: Int) : Result()
        class Failure(val message: String) : Result()
    }

}