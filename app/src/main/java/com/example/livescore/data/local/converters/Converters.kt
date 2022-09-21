package com.example.livescore.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.livescore.data.remote.dto.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val gson: Gson
) {

    //Away team converter
    @TypeConverter
    fun fromTest(str: AwayTeam): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toTest(str: String): AwayTeam {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }


    //Group converter
    @TypeConverter
    fun fromGroup(str: Group): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toGroup(str: String): Group {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    //home team
    @TypeConverter
    fun fromHometeam(str: HomeTeam): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toHometeam(str: String): HomeTeam {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    //round
    @TypeConverter
    fun fromRound(str: Round): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toRound(str: String): Round {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    //stage
    @TypeConverter
    fun fromStage(str: Stage): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toStage(str: String): Stage {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    //stats
    @TypeConverter
    fun fromStats(str: Stats): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toStats(str: String): Stats {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    //venue
    @TypeConverter
    fun fromVenue(str: Venue): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toVenue(str: String): Venue {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }
}