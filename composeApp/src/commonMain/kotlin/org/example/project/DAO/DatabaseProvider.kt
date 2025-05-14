package org.example.project.DAO

interface DatabaseProvider {
    fun getUserDao(): UserDao
    fun getFondDao(): FondDao
}