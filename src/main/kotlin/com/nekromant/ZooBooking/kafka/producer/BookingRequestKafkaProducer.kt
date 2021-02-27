package com.nekromant.ZooBooking.kafka.producer

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.nekromant.ZooBooking.model.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class BookingRequestKafkaProducer {
    @Value(value = "\${kafka.bookingToOrchestratorTopic}")
    private val topic = ""

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String,String>

    fun producerBookingRequest(book: Book){
        kafkaTemplate.send(topic,jacksonObjectMapper().writeValueAsString(book))
    }

}