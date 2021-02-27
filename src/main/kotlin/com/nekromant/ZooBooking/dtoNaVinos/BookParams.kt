package com.nekromant.ZooBooking.dtoNaVinos

import enums.AnimalType
import enums.RoomType

data class BookParams(
     val animalRequestId: Long,
     val id: Long,
     val animalType: AnimalType,
     val roomType: RoomType,
     val videoSupported: Boolean,
     val begin: String,
     val end: String
) {
    override fun toString(): String {
        return "BookParams(animalRequestId=$animalRequestId, id=$id, animalType=$animalType, roomType=$roomType, videoSupported=$videoSupported, begin='$begin', end='$end')"
    }
}