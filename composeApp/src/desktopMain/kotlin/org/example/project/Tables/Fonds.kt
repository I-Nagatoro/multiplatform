package org.example.project.Tables

import org.example.project.Tables.Users.autoIncrement
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object Fonds : Table() {
    val fondId = integer("fondId").autoIncrement()
    val name = varchar("name",  255)
    val balance = integer("balance")

    override val primaryKey = PrimaryKey(fondId)
}