package com.nekromant.ZooBooking.service

import com.nekromant.ZooBooking.dao.BookRepository
import com.nekromant.ZooBooking.dtoNaVinos.BookParams
import com.nekromant.ZooBooking.kafka.producer.BookingRequestKafkaProducer
import com.nekromant.ZooBooking.mapper.BookMapper
import dto.BookDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.stream.Collectors


@Service
class BookService {
    @Autowired
    private lateinit var bookRepository: BookRepository

    @Autowired
    private lateinit var bookMapper : BookMapper

    @Autowired
    private lateinit var bookingRequestKafkaProducer: BookingRequestKafkaProducer

    fun bookAnimalRequest(bookParams: BookParams){
        bookingRequestKafkaProducer.producerBookingRequest(
                bookRepository.save(
                        bookMapper.bookParamstoEntity(bookParams)
                )
        )
    }

    fun getAll() : List<BookDTO>{
        return bookRepository.findAll()
                .stream()
                .map{book -> bookMapper.entityToDto(book) }
                .collect(Collectors.toList())
    }

    fun getBooksByRoomAndDate(roomId: Long, beginDate: LocalDate, endDate: LocalDate): List<BookDTO> {
        return bookRepository.findBookByRoomIdAndDate(roomId,beginDate,endDate).stream()
                .map { t -> bookMapper.entityToDto(t) }
                .collect(Collectors.toList())
    }
}