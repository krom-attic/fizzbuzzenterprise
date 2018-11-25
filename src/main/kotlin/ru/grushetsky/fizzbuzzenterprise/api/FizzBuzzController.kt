package ru.grushetsky.fizzbuzzenterprise.api

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Controller
class FizzBuzzController {

    fun showWelcome(request: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
            .body(BodyInserters.fromObject("{\"App name\": \"FizzBuzz Enterprise\"}"))
}