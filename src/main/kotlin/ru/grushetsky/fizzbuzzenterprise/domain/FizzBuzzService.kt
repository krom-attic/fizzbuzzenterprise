package ru.grushetsky.fizzbuzzenterprise.domain

import org.springframework.stereotype.Service

@Service
class FizzBuzzService {

    fun doFizzBuzz(numbers: List<Int>): List<String> {
        return numbers.map {
            val fizz = divisibleBy3(it)
            val buzz = divisibleBy5(it)
            when {
                fizz && buzz -> "fizz buzz"
                fizz -> "fizz"
                buzz -> "buzz"
                else -> it.toString()
            }
        }
    }

    private fun divisibleBy3(number: Int) = number % 3 == 0

    private fun divisibleBy5(number: Int) = number % 5 == 0
}