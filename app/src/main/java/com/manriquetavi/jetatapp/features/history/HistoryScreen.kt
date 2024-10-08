package com.manriquetavi.jetatapp.features.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.manriquetavi.jetatapp.common.model.Bet
import com.manriquetavi.jetatapp.common.model.ChipFilter
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.manriquetavi.jetatapp.common.component.item.BetItem
import com.manriquetavi.jetatapp.common.component.progress.AtProgressIndicator
import com.manriquetavi.jetatapp.common.component.screen.EmptyContent

@Composable
fun HistoryScreen(
    paddingValues: PaddingValues,
    uiState: HistoryUiState,
    chips: List<ChipFilter>,
    searchByStatus: (ChipFilter) -> Unit,
    navigateToDetail: (String) -> Unit
) {
    var selectedChipFilter by remember { mutableStateOf(ChipFilter.NONE) }
    when (uiState) {
        HistoryUiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                AtProgressIndicator()
            }
        }
        HistoryUiState.Error -> {

        }

        HistoryUiState.EmptyData -> {
            EmptyContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                title = "No se encontraron datos"
            )
        }

        is HistoryUiState.Success -> {
            HistoryContent(
                paddingValues = paddingValues,
                bets = uiState.bets,
                chips = chips,
                searchByStatus = searchByStatus,
                selectedChipFilter = selectedChipFilter,
                changeSelectedChipFilter = { selectedChipFilter = it },
                navigateToDetail = navigateToDetail
            )
        }
    }

}

@Composable
fun HistoryContent(
    paddingValues: PaddingValues,
    bets: List<Bet>,
    chips: List<ChipFilter>,
    searchByStatus: (ChipFilter) -> Unit,
    selectedChipFilter: ChipFilter,
    changeSelectedChipFilter: (ChipFilter) -> Unit,
    navigateToDetail: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
    ) {
        LazyRow (
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(chips) { filterItem ->
                val selected = filterItem == selectedChipFilter
                FilterChip(
                    label = { Text(text = filterItem.value) },
                    selected = selected,
                    onClick = {
                        val selectedCurrent = if (selectedChipFilter == filterItem) {
                            ChipFilter.NONE
                        } else {
                            filterItem
                        }
                        changeSelectedChipFilter(selectedCurrent)
                        searchByStatus(selectedCurrent)
                    },
                    leadingIcon = if (selected) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Icon Done"
                            )
                        }
                    } else {
                        null
                    }
                )
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(
                items = bets,
                key = { bet ->
                    bet.game
                }
            ) { bet ->
                BetItem(
                    bet = bet,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}
