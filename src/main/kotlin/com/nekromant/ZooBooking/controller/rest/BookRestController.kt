package com.nekromant.ZooBooking.controller.rest

import com.nekromant.ZooBooking.service.BookService
import dto.BookDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/book")
class BookRestController {
    @Autowired
    private lateinit var bookService: BookService

    @GetMapping("/allBooks")
    fun getAllBooks() : List<BookDTO>{
        return bookService.getAll()
    }

    @PostMapping("/findByRoomAndDate")
    fun getBooksByRoomAndDate(@RequestBody bookDTO: BookDTO) : List<BookDTO>{
        return bookService.getBooksByRoomAndDate(bookDTO.roomId,bookDTO.beginDate,bookDTO.endDate);
    }
}