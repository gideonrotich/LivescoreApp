package com.example.livescore.presentation.screens.matches.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livescore.domain.use_cases.GetMatchesUseCase
import com.example.livescore.presentation.screens.matches.MatchesListState
import com.example.livescore.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(MatchesListState())
    val state: State<MatchesListState> = _state

    init {
        getAllMatches()
    }

    fun getAllMatches() {
        getMatchesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MatchesListState(matches = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MatchesListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MatchesListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
