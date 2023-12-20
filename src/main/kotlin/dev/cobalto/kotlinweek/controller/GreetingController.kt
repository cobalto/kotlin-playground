package dev.cobalto.kotlinweek.controller

import dev.cobalto.kotlinweek.model.Greeting
import dev.cobalto.kotlinweek.service.GreetingService
import mu.KLogging

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam

@RestController
class GreetingController(val greetingService: GreetingService) {

    companion object : KLogging()

    @GetMapping("/hello")
    fun sayHello(): String {
        logger.info("Hello route was called")
        return "Hello, World!"
    }

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        logger.info("A greeting for $name was sent")
        return greetingService.getGreeting(name)
    }
}