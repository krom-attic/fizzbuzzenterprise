package ru.grushetsky.fizzbuzzenterprise.api

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import ru.grushetsky.fizzbuzzenterprise.domain.FizzBuzzService

@CrossOrigin
@RestController("/numbers")
class FizzBuzzController(val fizzBuzzService: FizzBuzzService) {

    @PostMapping
    fun doFizzBuzz(@RequestBody numbers: List<Int>): Flux<StringValue> {
        return fizzBuzzService.doFizzBuzz(numbers)
    }
}