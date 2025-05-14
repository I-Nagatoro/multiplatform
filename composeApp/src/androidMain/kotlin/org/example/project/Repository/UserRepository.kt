package org.example.project.Repository

import org.example.project.DAO.FondDao
import org.example.project.DAO.UserDao
import org.example.project.Models.Fond
import org.example.project.Models.User

class userRepository(
    private val userDao: UserDao,
    private val fondDao: FondDao
) {
    fun fetchUsers(): List<User> = userDao.fetchUsers()

    fun regUser(user: User): Boolean = userDao.regUser(user) > 0

    fun fetchFonds(): List<Fond> = fondDao.fetchFonds()

    fun withdrawalBalance(idFond: Int, dedSum: Int): Boolean =
        fondDao.withdrawalBalance(idFond, dedSum) > 0

    fun getUserIdByEmail(email: String): Int =
        userDao.getUserIdByEmail(email) ?: -1

    fun updateUserActive(idUser: Int): Boolean =
        userDao.updateUserActive(idUser) > 0

    fun topUpBalance(idFond: Int, sum: Int): Boolean =
        fondDao.topUpBalance(idFond, sum) > 0
}

