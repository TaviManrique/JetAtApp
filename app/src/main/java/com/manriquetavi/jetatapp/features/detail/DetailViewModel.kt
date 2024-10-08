package com.manriquetavi.jetatapp.features.detail

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.manriquetavi.jetatapp.common.model.BetDetail
import com.manriquetavi.jetatapp.util.delayMediumTime
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.reflect.Type
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
): ViewModel() {
    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val gameId = savedStateHandle.get<String>(key = "game")
            gameId?.let {
                val jsonString = context.assets.open("betsDetailHistory.json").bufferedReader().use { it.readText() }
                val gson = Gson()
                val listType: Type = object : TypeToken<List<BetDetail>>() {}.type
                val betsDetail: List<BetDetail> = gson.fromJson(jsonString, listType)
                delayMediumTime()
                val betDetail = betsDetail.first { it.betId.toString() == gameId }
                _uiState.value = DetailUiState.Success(betDetail = betDetail)

            } ?: run {
                _uiState.value = DetailUiState.Error
            }
        }
    }

}

sealed interface DetailUiState {
    data object Loading : DetailUiState
    data class Success(val betDetail: BetDetail) : DetailUiState
    data object Error: DetailUiState
}