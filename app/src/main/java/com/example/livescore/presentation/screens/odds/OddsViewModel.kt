package com.example.livescore.presentation.screens.odds

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livescore.domain.use_cases.GetOddsUseCase
import com.example.livescore.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class OddsViewModel @Inject constructor(
    private val oddsUseCase: GetOddsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(OddsDetailState())
    val state: State<OddsDetailState> = _state

    fun getOdds(id: String) {
        oddsUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = OddsDetailState(odds = result.data)
                }
                is Resource.Error -> {
                    _state.value = OddsDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = OddsDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
