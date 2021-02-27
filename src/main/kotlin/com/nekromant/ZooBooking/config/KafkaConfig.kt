package com.nekromant.ZooBooking.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.kafka.core.KafkaAdmin
import java.util.*

@Configuration
@PropertySource("classpath:kafka.properties")
class KafkaConfig {
    @Value(value = "\${kafka.bootstrapAddress}")
    private val bootstrapAddress: String = ""

    @Value(value = "\${kafka.bookingToOrchestratorTopic}")
    private val topic = "\${kafka.bookingToOrchestratorTopic}"

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: MutableMap<String, Any?> = HashMap()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        return KafkaAdmin(configs)
    }

    @Bean
    fun bookingProducer(): NewTopic {
        return NewTopic(topic, 1, 1.toShort())
    }
}
