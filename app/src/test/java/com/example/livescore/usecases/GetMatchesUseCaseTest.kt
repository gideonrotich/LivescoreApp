package com.example.livescore.usecases

import com.example.livescore.domain.models.*
import com.example.livescore.domain.repository.MatchesRepository
import com.example.livescore.domain.use_cases.*
import com.example.livescore.util.Resource
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetMatchesUseCaseTest {
    companion object {
        fun mockMatchesRepository(
            flowReturn: Flow<Resource<List<DataModel>>>,
            flowReturnOne: Flow<Resource<MatchDetailsModel>>,
            flowReturnTwo: Flow<Resource<List<StandingsModel>>>,
            flowReturnThree: Flow<Resource<OddsModel>>,
            flowReturnFour: Flow<Resource<List<ScorersModel>>>
        ) = object : MatchesRepository {

            override fun getMatches(): Flow<Resource<List<DataModel>>> = flowReturn
            override fun getStandings(): Flow<Resource<List<StandingsModel>>> = flowReturnTwo
            override fun getMatchDetails(id: String): Flow<Resource<MatchDetailsModel>> = flowReturnOne
            override fun getOdds(id: String): Flow<Resource<OddsModel>> = flowReturnThree
            override fun getScorers(): Flow<Resource<List<ScorersModel>>> = flowReturnFour

        }
    }


    @Test
    fun `Get matches starts with Loading RETURNS Resource Loading`() = runBlocking {
        val matches = mockk<List<DataModel>>()
        val matchesdetails = mockk<MatchDetailsModel>()
        val standings = mockk<List<StandingsModel>>()
        val odds = mockk<OddsModel>()
        val scorer = mockk<List<ScorersModel>>()

        val matchesRepository = mockMatchesRepository(flow {
            emit(Resource.Loading())
            emit(Resource.Success(matches))

        }, flow {
            emit(Resource.Loading())
            emit(Resource.Success(matchesdetails))
        }, flow {
            emit(Resource.Loading())
            emit(Resource.Success(standings))
        }, flow {
            emit(Resource.Loading())
            emit(Resource.Success(odds))
        }, flow {
            emit(Resource.Loading())
            emit(Resource.Success(scorer))
        })

        val matchresult = GetMatchesUseCase(matchesRepository).invoke().first()
        assert((matchresult is Resource.Loading))

        val matchesdetailsresult = GetMatchDetailsUseCase(matchesRepository).invoke("315814").first()
        assert((matchesdetailsresult is Resource.Loading))

        val standingsresult = GetStandingsUseCase(matchesRepository).invoke().first()
        assert((standingsresult is Resource.Loading))

        val oddsresult = GetOddsUseCase(matchesRepository).invoke("1").first()
        assert((oddsresult is Resource.Loading))

        val scorerresult = GetScorersUseCase(matchesRepository).invoke().first()
        assert((scorerresult is Resource.Loading))

    }
}