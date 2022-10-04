package com.example.livescore.domain.use_cases

import com.example.livescore.domain.models.MatchDetailsModel
import com.example.livescore.domain.repository.MatchesRepository
import com.example.livescore.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMatchDetailsUseCase @Inject constructor(
    private val repository: MatchesRepository
) {
    operator fun invoke(id: String): Flow<Resource<MatchDetailsModel>> {
        return repository.getMatchDetails(id)
    }
}
