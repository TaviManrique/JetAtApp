package com.manriquetavi.jetatapp.features.history

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.manriquetavi.jetatapp.common.model.Bet
import com.manriquetavi.jetatapp.common.model.ChipFilter
import com.manriquetavi.jetatapp.util.delayMediumTime
import com.manriquetavi.jetatapp.util.delayShortTime
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.reflect.Type
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    @ApplicationContext private val context: Context
): ViewModel() {

    private val _uiState = MutableStateFlow<HistoryUiState>(HistoryUiState.Loading)
    val uiState = _uiState.asStateFlow()
    private var bets: List<Bet> = emptyList()

    init {
        viewModelScope.launch {
            val jsonString = context.assets.open("betsHistory.json").bufferedReader().use { it.readText() }
            val gson = Gson()
            val listType: Type = object : TypeToken<List<Bet>>() {}.type
            val bets: List<Bet> = gson.fromJson(jsonString, listType)
            this@HistoryViewModel.bets = bets
            delayMediumTime()
            _uiState.value = HistoryUiState.Success(bets = bets)
        }
    }
    fun filterByStatus(status: ChipFilter) {
        viewModelScope.launch {
            _uiState.value = HistoryUiState.Loading
            if (status == ChipFilter.NONE) {
                _uiState.value = HistoryUiState.Success(bets = bets)
            } else {
                delayMediumTime()
                val betsFilter = bets.filter { it.status == status.name }
                _uiState.value = HistoryUiState.Success(bets = betsFilter)
            }
        }
    }

}

sealed interface HistoryUiState {
    data object Loading : HistoryUiState
    data object Error: HistoryUiState
    data class Success(val bets: List<Bet>) : HistoryUiState
    data object EmptyData: HistoryUiState
}