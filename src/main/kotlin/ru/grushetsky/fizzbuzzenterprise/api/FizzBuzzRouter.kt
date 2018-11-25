package ru.grushetsky.fizzbuzzenterprise.api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*

@Configuration
class FizzBuzzRouter(private val fizzBuzzController: FizzBuzzController) {

    @Bean
    fun route() = router {
        GET("/", fizzBuzzController::showWelcome)
    }
}