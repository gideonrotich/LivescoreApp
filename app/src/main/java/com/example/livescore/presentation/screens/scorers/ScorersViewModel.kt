package com.example.livescore.presentation.screens.scorers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livescore.domain.use_cases.GetScorersUseCase
import com.example.livescore.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ScorersViewModel @Inject constructor(
    private val getScorersUseCase: GetScorersUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ScorersDataState())
    val state: State<ScorersDataState> = _state

    init {
        getScorers()
    }

    private fun getScorers() {
        getScorersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ScorersDataState(scorer = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ScorersDataState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = ScorersDataState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
