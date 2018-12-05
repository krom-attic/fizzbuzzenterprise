package ru.grushetsky.fizzbuzzenterprise.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.grushetsky.fizzbuzzenterprise.api.StringValue

internal class FizzBuzzServiceTest {

    @Test
    internal fun `should return empty list for empty input list`() {
        // given
        val fizzBuzzService = FizzBuzzService()

        // when
        val fizzBuzzed = fizzBuzzService.doFizzBuzz(emptyList()).collectList().block()

        // then
        assertThat(fizzBuzzed).isEmpty()
    }

    @ParameterizedTest
    @CsvSource(
        "1, 1",
        "2, 2",
        "3, fizz",
        "4, 4",
        "5, buzz",
        "9, fizz",
        "10, buzz",
        "15, fizz buzz",
        "90, fizz buzz"
    )
    internal fun `should return list with the only item matching the input`(input: Int, output: String) {
        // given
        val fizzBuzzService = FizzBuzzService()

        // when
        val fizzBuzzed = fizzBuzzService.doFizzBuzz(listOf(input)).collectList().block()

        // then
        assertThat(fizzBuzzed).containsOnly(StringValue(output))
    }
}