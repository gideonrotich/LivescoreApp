package com.example.livescore.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.livescore.domain.use_cases.GetMatchesUseCase
import com.example.livescore.presentation.screens.matches.components.MatchesViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class GetMatchesViewModelTest {

    // nimeshindwa kuimpliment this test for the match viewmodel

//    private lateinit var getMatchesViewModel: MatchesViewModel
//    private val getMatchesUseCase: GetMatchesUseCase = mock()
//
//    @get: Rule
//    val rule = InstantTaskExecutorRule()
//
//    @Before
//    fun Setup() {
//        getMatchesViewModel = MatchesViewModel(getMatchesUseCase)
//    }
//
//    @Test
//    fun `call to fetch matches`() = runTest {
//        getMatchesViewModel.getAllMatches()
//        verify(getMatchesUseCase).invoke()
//    }
}
