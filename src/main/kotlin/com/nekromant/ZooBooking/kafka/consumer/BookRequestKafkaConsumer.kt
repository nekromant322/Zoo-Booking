package com.nekromant.ZooBooking.kafka.consumer

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.nekromant.ZooBooking.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.PropertySource
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:kafka.properties")
class BookRequestKafkaConsumer {

    @Autowired
    private lateinit var bookService: BookService

    @KafkaListener(topics = ["\${kafka.orchestratorToBookingTopic}"],groupId = "\${kafka.orchestratorToBookingGroup}")
    fun listenBookingRequest(message: String) {
        bookService.bookAnimalRequest(jacksonObjectMapper().readValue(message))
    }
}