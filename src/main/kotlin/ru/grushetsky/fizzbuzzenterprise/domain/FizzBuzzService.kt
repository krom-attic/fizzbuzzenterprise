package ru.grushetsky.fizzbuzzenterprise.domain

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux
import ru.grushetsky.fizzbuzzenterprise.api.StringValue

@Service
class FizzBuzzService {

    fun doFizzBuzz(numbers: List<Int>): Flux<StringValue> {
        return numbers.asSequence().map {
            val fizz = divisibleBy3(it)
            val buzz = divisibleBy5(it)
            when {
                fizz && buzz -> "fizz buzz"
                fizz -> "fizz"
                buzz -> "buzz"
                else -> it.toString()
            }
        }.map { s -> StringValue(s) }
            .toFlux()
    }

    private fun divisibleBy3(number: Int) = number % 3 == 0

    private fun divisibleBy5(number: Int) = number % 5 == 0
}