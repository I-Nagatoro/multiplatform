package org.example.project.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.Date

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val email: String,
    val password: String,
    val name: String,
    val lastname: String,
    val gender: String,
    val photo: String,
    val birthDate: LocalDate,
    val country: String,
    val active: Boolean
)
