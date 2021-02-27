package com.nekromant.ZooBooking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource(value = [
	"classpath:datasources.properties",
	"classpath:jpa.properties"
])
class ZooBookingApplication

fun main(args: Array<String>) {
	runApplication<ZooBookingApplication>(*args)
}
