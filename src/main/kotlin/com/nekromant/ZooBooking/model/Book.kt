package com.nekromant.ZooBooking.model

import java.time.LocalDate
import javax.persistence.*

@Entity(name = "Book")
data class Book (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val animalRequestId: Long,

    @Column
    val roomId: Long,

    @Column(columnDefinition = "DATE")
    val beginDate: LocalDate,

    @Column(columnDefinition = "DATE")
    val endDate: LocalDate
){
    override fun toString(): String {
        return "Book(id=$id, animalRequestId=$animalRequestId, roomId=$roomId, beginDate=$beginDate, endDate=$endDate)"
    }
}