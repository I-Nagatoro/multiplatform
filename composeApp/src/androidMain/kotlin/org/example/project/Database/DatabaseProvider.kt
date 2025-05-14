package org.example.project.Database

import android.content.Context
import androidx.room.Room
import org.example.project.DAO.DatabaseProvider
import org.example.project.DAO.FondDao
import org.example.project.DAO.UserDao

class AndroidDatabaseProvider(context: Context) : DatabaseProvider {
    private val database: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java, "app_database"
    ).build()

    override fun getUserDao(): UserDao = database.userDao()
    override fun getFondDao(): FondDao = database.fondDao()
}