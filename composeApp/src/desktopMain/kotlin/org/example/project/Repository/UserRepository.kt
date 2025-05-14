package org.example.project.Repository

import org.example.project.Models.Fond
import org.example.project.Models.User
import org.example.project.Tables.Fonds
import org.example.project.Tables.Users
import org.example.project.Tables.connectToDatabase
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

actual class IUserRepository {

    actual fun fetchUsers(): List<User> {
        connectToDatabase()
        return transaction {
            Users.selectAll().map {
                User(
                    userId = it[Users.userId],
                    email = it[Users.email],
                    password = it[Users.password],
                    name = it[Users.name],
                    lastname = it[Users.lastname],
                    gender = it[Users.gender],
                    photo = it[Users.photo],
                    birthDate = it[Users.birthday],
                    country = it[Users.country],
                    active = it[Users.active]
                )
            }
        }
    }

    actual fun regUser(user: User): Boolean {
        connectToDatabase()
        return try {
            transaction {
                Users.insert {
                    it[userId] = user.userId
                    it[email] = user.email
                    it[password] = user.password
                    it[name] = user.name
                    it[lastname] = user.lastname
                    it[gender] = user.gender
                    it[photo] = user.photo
                    it[birthday] = user.birthDate
                    it[country] = user.country
                }
            }
            true
        } catch (e: Exception) {
            println("Ошибка при регистрации: ${e.message}")
            false
        }
    }

    actual fun fetchFonds(): List<Fond> {
        connectToDatabase()
        return transaction {
            Fonds.selectAll().map {
                Fond(
                    fondId = it[Fonds.fondId],
                    name = it[Fonds.name],
                    balance = it[Fonds.balance]
                )
            }
        }
    }

    actual fun withdrawalBalance(idFond: Int, dedSum: Int): Boolean {
        connectToDatabase()
        return try {
            transaction {
                Fonds.update({ Fonds.fondId eq idFond }) {
                    with(SqlExpressionBuilder) {
                        it.update(Fonds.balance, Fonds.balance - dedSum)
                    }
                }
            }
            true
        } catch (e: Exception) {
            println("Ошибка при снятии: ${e.message}")
            false
        }
    }

    actual fun getUserIdByEmail(email: String): Int {
        connectToDatabase()

        return transaction {
            Users.selectAll().where { Users.email eq email }.single()[Users.userId]
        }
    }

    actual fun updateUserActive(idUser: Int): Boolean {
        connectToDatabase()
        return try {
            transaction {
                Users.update({ Users.userId eq idUser }) {
                    it[active] = true
                }
            }
            true
        } catch (e: Exception) {
            println("Ошибка при обновлении: ${e.message}")
            false
        }
    }

    actual fun topUpBalance(idFond: Int, sum: Int): Boolean {
        connectToDatabase()
        return try {
            transaction {
                Fonds.update({ Fonds.fondId eq idFond }) {
                    with(SqlExpressionBuilder) {
                        it.update(Fonds.balance, Fonds.balance + sum)
                    }
                }
            }
            true
        } catch (e: Exception) {
            println("Ошибка при пополнении: ${e.message}")
            false
        }
    }
}