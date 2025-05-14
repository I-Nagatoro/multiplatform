package org.example.project.ViewModel

import org.example.project.DAO.FondDao
import org.example.project.DAO.UserDao
import org.example.project.Models.Fond
import org.example.project.Models.User
import org.example.project.Repository.UserRepository

class UserViewModel() {
    private lateinit var userDao: UserDao
    private lateinit var fondDao: FondDao
    private var userRepository: UserRepository? = null
    private var isInitialized = false

    fun initDao(userDao: UserDao, fondDao: FondDao) {
        if (isInitialized) {
            throw IllegalStateException("UserViewModel уже инициализирован. Повторная инициализация запрещена.")
        }

        this.userDao = userDao
        this.fondDao = fondDao
        this.userRepository = UserRepository(userDao, fondDao)
        isInitialized = true
    }

    private fun repo(): UserRepository {
        return userRepository
            ?: throw IllegalStateException("UserRepository не инициализирован. Вызовите initDao() перед использованием.")
    }

    fun getUsers(): List<User> = repo().fetchUsers()

    fun regUser(user: User): Boolean = repo().regUser(user)

    fun getFond(): List<Fond> = repo().fetchFonds()

    fun withdrawalBalance(idFond: Int, dedSum: Int): Boolean =
        repo().withdrawalBalance(idFond, dedSum)

    fun getUserIdByEmail(email: String): Int = repo().getUserIdByEmail(email)

    fun updateUserActive(idUser: Int): Boolean = repo().updateUserActive(idUser)

    fun topUpBalance(idFond: Int, sum: Int): Boolean = repo().topUpBalance(idFond, sum)
}
