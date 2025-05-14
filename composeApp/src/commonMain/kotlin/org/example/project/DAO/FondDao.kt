package org.example.project.DAO

import androidx.room.Dao
import androidx.room.Query
import org.example.project.Models.Fond

@Dao
interface FondDao {
    @Query("SELECT * FROM Fond")
    fun fetchFonds(): List<Fond>

    @Query("UPDATE Fond SET balance = balance - :dedSum WHERE fondId = :idFond AND balance >= :dedSum")
    fun withdrawalBalance(idFond: Int, dedSum: Int): Int

    @Query("UPDATE Fond SET balance = balance + :sum WHERE fondId = :idFond")
    fun topUpBalance(idFond: Int, sum: Int): Int
}