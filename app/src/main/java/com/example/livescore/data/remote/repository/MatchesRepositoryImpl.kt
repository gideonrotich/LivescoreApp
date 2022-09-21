package com.example.livescore.data.remote.repository

import com.example.livescore.data.local.dao.MatchesDao
import com.example.livescore.data.remote.api.LivescoreApi
import com.example.livescore.data.remote.mappers.toDomain
import com.example.livescore.data.remote.mappers.toEntity
import com.example.livescore.domain.models.DataModel
import com.example.livescore.domain.repository.MatchesRepository
import com.example.livescore.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MatchesRepositoryImpl(
    private val livescoreApi: LivescoreApi,
    private val matchesDao: MatchesDao
) : MatchesRepository {
    override fun getMatches(): Flow<Resource<List<DataModel>>> = flow {
        emit(Resource.Loading())

        val getMatchesFromDb = matchesDao.getMatches().map { it.toDomain() }
        emit(Resource.Loading(data = getMatchesFromDb))

        try {
            val apiResponse = livescoreApi.getMatches()
            matchesDao.deleteMatches()
            matchesDao.insertMatches(apiResponse.data.map { it.toEntity() })
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
        val allMatches = matchesDao.getMatches().map { it.toDomain() }
        emit(Resource.Success(allMatches))
    }
}