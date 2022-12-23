package com.example.livescore.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.livescore.data.remote.dto.*
import com.example.livescore.data.remote.dto.matchdetails.Lineup
import com.example.livescore.data.remote.dto.matchdetails.MatchEvent
import com.example.livescore.data.remote.dto.matchdetails.MatchStatistic
import com.example.livescore.data.remote.dto.matchdetails.Stats
import com.example.livescore.data.remote.dto.matches.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val gson: Gson
){

    // Away team converter
    @TypeConverter
    fun fromTest(str: AwayTeam): String? {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toTest(str: String?): AwayTeam {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // Group converter
    @TypeConverter
    fun fromGroup(strone: Group): String? {
        return Gson().toJson(strone)
    }

    @TypeConverter
    fun toGroup(strtwo: String?): Group {
        return Gson().fromJson(strtwo, object : TypeToken<String>() {}.type)
    }

    // home team
    @TypeConverter
    fun fromHometeam(str: HomeTeam): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toHometeam(str: String): HomeTeam {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // round
    @TypeConverter
    fun fromRound(str: Round): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toRound(str: String): Round {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // stage
    @TypeConverter
    fun fromStage(str: Stage): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toStage(str: String): Stage {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // stats
    @TypeConverter
    fun fromStatss(str: com.example.livescore.data.remote.dto.matches.Stats): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toStatss(str: String): com.example.livescore.data.remote.dto.matches.Stats {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // venue
    @TypeConverter
    fun fromVenue(str: Venue): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toVenue(str: String): Venue {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // venue
    @TypeConverter
    fun fromAwa(str: com.example.livescore.data.remote.dto.matchdetails.AwayTeam): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toAwa(str: String): com.example.livescore.data.remote.dto.matchdetails.AwayTeam {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // venue
    @TypeConverter
    fun fromGrou(str: com.example.livescore.data.remote.dto.matchdetails.Group): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toGrou(str: String): com.example.livescore.data.remote.dto.matchdetails.Group {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // venue
    @TypeConverter
    fun fromHome(str: com.example.livescore.data.remote.dto.matchdetails.HomeTeam): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toHome(str: String): com.example.livescore.data.remote.dto.matchdetails.HomeTeam {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // venue
    @TypeConverter
    fun fromLine(str: List<Lineup>): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toLine(str: String): List<Lineup> {
        return Gson().fromJson(str, object : TypeToken<List<String>>() {}.type)
    }

    // venue
    @TypeConverter
    fun fromMatch(str: List<MatchEvent>): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toMatch(str: String): List<MatchEvent> {
        return Gson().fromJson(str, object : TypeToken<List<String>>() {}.type)
    }

    // venue
    @TypeConverter
    fun fromStatistic(str: List<MatchStatistic>): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toStatistic(str: String): List<MatchStatistic> {
        return Gson().fromJson(str, object : TypeToken<List<String>>() {}.type)
    }

    // venue
    @TypeConverter
    fun fromReferee(str: com.example.livescore.data.remote.dto.matchdetails.Round): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toReferee(str: String): com.example.livescore.data.remote.dto.matchdetails.Round {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // venue
    @TypeConverter
    fun fromStagee(str: com.example.livescore.data.remote.dto.matchdetails.Stage): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toStagee(str: String): com.example.livescore.data.remote.dto.matchdetails.Stage {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // venue
    @TypeConverter
    fun fromStatw(str: com.example.livescore.data.remote.dto.matchdetails.Stats): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toStatw(str: String): com.example.livescore.data.remote.dto.matchdetails.Stats {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }

    // venue
    @TypeConverter
    fun fromVenu(str: com.example.livescore.data.remote.dto.matchdetails.Venue): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toVenu(str: String): com.example.livescore.data.remote.dto.matchdetails.Venue {
        return Gson().fromJson(str, object : TypeToken<String>() {}.type)
    }
}
