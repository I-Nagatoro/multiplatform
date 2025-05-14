package org.example.project.Database


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.example.project.DAO.FondDao
import org.example.project.DAO.UserDao
import org.example.project.Models.Fond
import org.example.project.Models.User


@Database(entities = [User::class, Fond::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun fondDao(): FondDao
}