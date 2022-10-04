package com.example.livescore.presentation.screens.standings

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livescore.domain.use_cases.GetStandingsUseCase
import com.example.livescore.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val getStandingsUseCase: GetStandingsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(StandingsListState())
    val state: State<StandingsListState> = _state

    private val _isRefresh = MutableStateFlow(false)
    val isRefresh: StateFlow<Boolean> = _isRefresh

    init {
        getStandings()
    }

    fun refresh() {
        viewModelScope.launch {
            _isRefresh.emit(true)
            getStandings()
            _isRefresh.emit(false)
        }
    }

    private fun getStandings() {
        getStandingsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = StandingsListState(standings = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = StandingsListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = StandingsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
