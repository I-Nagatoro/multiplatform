package org.example.project.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.example.project.Models.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun fetchUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun regUser(user: User): Long

    @Query("SELECT userId FROM User WHERE email = :email LIMIT 1")
    fun getUserIdByEmail(email: String): Int?

    @Query("UPDATE User SET active = 1 WHERE userId = :idUser")
    fun updateUserActive(idUser: Int): Int
}