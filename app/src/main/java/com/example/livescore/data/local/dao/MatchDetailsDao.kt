package com.example.livescore.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.livescore.data.local.entity.MatchDetailsEntity

@Dao
interface MatchDetailsDao {
    @Query("SELECT * FROM match_details")
    suspend fun getMatchDetails(): MatchDetailsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatchDetails(list: MatchDetailsEntity)

    @Query("DELETE FROM match_details")
    suspend fun deleteMatchDetails()
}
