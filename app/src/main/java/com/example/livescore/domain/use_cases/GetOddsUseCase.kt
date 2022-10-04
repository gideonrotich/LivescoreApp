package com.example.livescore.domain.use_cases

import com.example.livescore.domain.models.OddsModel
import com.example.livescore.domain.repository.MatchesRepository
import com.example.livescore.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOddsUseCase @Inject constructor(
    private val repository: MatchesRepository
) {
    operator fun invoke(id: String): Flow<Resource<OddsModel>> {
        return repository.getOdds(id)
    }
}
