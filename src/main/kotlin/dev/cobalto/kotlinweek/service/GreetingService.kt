package dev.cobalto.kotlinweek.service

import dev.cobalto.kotlinweek.model.Greeting
import mu.KLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class GreetingService {
    companion object : KLogging()
    private val counter = AtomicLong()

    @Value("\${template.greeting.log}")
    lateinit var templateLog : String

    @Value("\${template.greeting.message}")
    lateinit var templateGreeting : String

    fun getGreeting(name: String): Greeting {
        val currentCounter = counter.incrementAndGet()

        logger.info(String.format(templateLog, name, currentCounter))

        return Greeting(currentCounter, String.format(templateGreeting, name))
    }
}