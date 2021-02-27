package com.nekromant.ZooBooking.mapper

import com.nekromant.ZooBooking.dtoNaVinos.BookParams
import com.nekromant.ZooBooking.model.Book
import dto.BookDTO
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class BookMapper {
    fun bookParamstoEntity(bookParams: BookParams) : Book{
        return Book(
                0L,
                bookParams.animalRequestId,
                bookParams.id,
                LocalDate.parse(bookParams.begin),
                LocalDate.parse(bookParams.end)
        )
    }

    fun entityToDto(book: Book): BookDTO{
        return BookDTO(
                book.id,
                book.animalRequestId,
                book.roomId,
                book.beginDate,
                book.endDate
        )
    }
}