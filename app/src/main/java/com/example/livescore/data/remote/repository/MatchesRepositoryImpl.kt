package com.example.livescore.data.remote.repository

import com.example.livescore.data.local.dao.MatchDetailsDao
import com.example.livescore.data.local.dao.MatchesDao
import com.example.livescore.data.remote.api.LivescoreApi
import com.example.livescore.data.remote.mappers.toDomain
import com.example.livescore.data.remote.mappers.toEntity
import com.example.livescore.domain.models.DataModel
import com.example.livescore.domain.models.MatchDetailsModel
import com.example.livescore.domain.models.OddsModel
import com.example.livescore.domain.models.StandingsModel
import com.example.livescore.domain.repository.MatchesRepository
import com.example.livescore.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MatchesRepositoryImpl(
    private val livescoreApi: LivescoreApi,
    private val matchesDao: MatchesDao,
    private val matchDetailsDao: MatchDetailsDao
) : MatchesRepository {
    override fun getMatches(): Flow<Resource<List<DataModel>>> = flow {
        emit(Resource.Loading())

        val getMatchesFromDb = matchesDao.getMatches().map { it.toDomain() }
        emit(Resource.Loading(data = getMatchesFromDb))

        try {
            val apiResponse = livescoreApi.getMatches()
//            matchesDao.deleteMatches()
//            matchesDao.insertMatches(apiResponse.data.map { it.toEntity() })
        } catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost",
                    data = getMatchesFromDb
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message(),
                    data = getMatchesFromDb
                )
            )
        }
        val allMatches = livescoreApi.getMatches().data.map { it.toEntity() }
        emit(Resource.Success(allMatches))
    }

    override fun getStandings(): Flow<Resource<List<StandingsModel>>> = flow {
        emit(Resource.Loading())

        try {

        } catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost"
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message()
                )
            )
        }
        val allStandings = livescoreApi.geStandings().data.standings.map { it.toEntity() }
        emit(Resource.Success(allStandings))
    }

    override fun getMatchDetails(id: String): Flow<Resource<MatchDetailsModel>> = flow {
        emit(Resource.Loading())

//        val getMatchDetailsFromDb = matchDetailsDao.getMatchDetails().toDomain()
//        emit(Resource.Loading(data = getMatchDetailsFromDb))

        try {
            val apiResponse = livescoreApi.getMatchDetails(id)
//            matchesDao.deleteMatches()
//            matchesDao.insertMatches(apiResponse.data.map { it.toEntity() })
        } catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost"
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message()
                )
            )
        }
        val allMatches = livescoreApi.getMatchDetails(id).data.toEntity()
        emit(Resource.Success(allMatches))

    }


    //used to get the match odds
    override fun getOdds(id: String): Flow<Resource<OddsModel>> = flow{
        emit(Resource.Loading())

        try {

        } catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost"
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message()
                )
            )
        }
        val allStandings = livescoreApi.getOdds(id).data.toEntity()
        emit(Resource.Success(allStandings))
    }
}