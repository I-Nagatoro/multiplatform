package org.example.project.Tables

import org.example.project.Models.User
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun connectToDatabase() {
    Database.connect(
        "jdbc:postgresql://45.67.56.214:5421/user7?currentSchema=multiplatform",
        user = "user7",
        password = "a8yLONBC"
    )
}
