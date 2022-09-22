package com.example.livescore.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.livescore.data.local.converters.Converters
import com.example.livescore.data.local.dao.MatchesDao
import com.example.livescore.data.local.entity.MatchesEntity


@TypeConverters(Converters::class)
@Database(
    entities = [MatchesEntity::class],
    version = 20,
    exportSchema = false
)
abstract class LivescoreDatabase:RoomDatabase() {
    abstract fun MatchesDao():MatchesDao
}