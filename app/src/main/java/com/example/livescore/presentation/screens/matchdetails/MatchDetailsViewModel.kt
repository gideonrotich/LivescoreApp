package com.example.livescore.presentation.screens.matchdetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livescore.domain.use_cases.GetMatchDetailsUseCase
import com.example.livescore.domain.use_cases.GetOddsUseCase
import com.example.livescore.presentation.screens.matches.MatchesListState
import com.example.livescore.presentation.screens.odds.OddsDetailState
import com.example.livescore.util.Constants
import com.example.livescore.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MatchDetailsViewModel @Inject constructor(
    private val getMatchDetailsUseCase: GetMatchDetailsUseCase,
    private val oddsUseCase: GetOddsUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel(){
    private val _state = mutableStateOf(MatchDetailsState())
    val state:State<MatchDetailsState> = _state

    //to call get match details

    init {
        savedStateHandle.get<String>(Constants.PARAM_MATCH_ID)?.let { match ->
            getMatchDetails(match)
            getOdds(match)
        }
    }

    private fun getMatchDetails(id:String){
        getMatchDetailsUseCase(id).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = MatchDetailsState(matchdetails = result.data)
//
                }
                is Resource.Error -> {
                    _state.value = MatchDetailsState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MatchDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getOdds(id: String) {
        oddsUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MatchDetailsState(odds = result.data)
                }
                is Resource.Error -> {
                    _state.value = MatchDetailsState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MatchDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}