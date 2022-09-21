package com.example.livescore.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.livescore.data.local.entity.MatchesEntity

@Dao
interface MatchesDao {
    @Query("SELECT * FROM matches_table")
    suspend fun getMatches():List<MatchesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatches(list: List<MatchesEntity>)

    @Query("DELETE FROM matches_table")
    suspend fun deleteMatches()
}