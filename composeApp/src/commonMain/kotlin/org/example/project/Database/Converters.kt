package org.example.project.Database

import androidx.room.TypeConverter
import java.time.LocalDate

class Converters {
    @TypeConverter
    fun fromDate(value: String): LocalDate = LocalDate.parse(value)

    @TypeConverter
    fun toDate(date: LocalDate): String = date.toString()
}