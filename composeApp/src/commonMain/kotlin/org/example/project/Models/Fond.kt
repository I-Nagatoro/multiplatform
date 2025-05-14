package org.example.project.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Fond(
    @PrimaryKey(autoGenerate = true) val fondId: Int = 0,
    val name: String,
    val balance: Int
)