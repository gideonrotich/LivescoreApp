package com.example.livescore.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.livescore.data.local.converters.Converters
import com.example.livescore.data.local.dao.MatchDetailsDao
import com.example.livescore.data.local.dao.MatchesDao
import com.example.livescore.data.local.entity.MatchDetailsEntity
import com.example.livescore.data.local.entity.MatchesEntity


@TypeConverters(Converters::class)
@Database(
    entities = [MatchesEntity::class,MatchDetailsEntity::class],
    version = 21,
    exportSchema = false
)
abstract class LivescoreDatabase:RoomDatabase() {
    abstract fun MatchesDao():MatchesDao
    abstract fun MatchDetailsDao():MatchDetailsDao
}