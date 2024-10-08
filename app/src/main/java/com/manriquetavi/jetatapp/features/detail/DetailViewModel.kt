package com.manriquetavi.jetatapp.features.detail

import androidx.lifecycle.SavedStateHandle
import com.manriquetavi.jetatapp.common.model.Bet
import com.manriquetavi.jetatapp.features.history.HistoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) {
    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState = _uiState.asStateFlow()
    private var bets: List<Bet> = emptyList()
}

sealed interface DetailUiState {
    data object Loading : DetailUiState
    data class Success(val bets: List<Bet>) : DetailUiState
}