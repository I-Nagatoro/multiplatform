package org.example.project.Tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object Users : Table() {
    val userId = integer("userId").autoIncrement()
    val email = varchar("email",  255)
    val password = varchar("password",  255)
    val name = varchar("name", 255)
    val lastname = varchar("lastname", 255)
    val gender = varchar("gender", 255)
    val photo = varchar("photo", 255)
    val birthday = date("birthday")
    val country = varchar("country", 255)
    val active = bool("active").default(false)
    override val primaryKey = PrimaryKey(userId)
}
