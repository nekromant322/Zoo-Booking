package com.nekromant.ZooBooking.dao

import com.nekromant.ZooBooking.model.Book
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.time.LocalDate

interface BookRepository : CrudRepository<Book,Long> {
    @Query("select b from Book b where b.roomId = :roomId and ((:endDate between b.beginDate and b.endDate) or (:beginDate between b.beginDate and b.endDate) or ((:beginDate < b.beginDate) and (:endDate > b.endDate)))")
    fun findBookByRoomIdAndDate(@Param("roomId") id: Long,
                                @Param("beginDate") beginDate: LocalDate,
                                @Param("endDate") endDate: LocalDate): List<Book>

    override fun findAll() : List<Book>
}