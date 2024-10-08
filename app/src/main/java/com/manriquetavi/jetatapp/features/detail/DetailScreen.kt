package com.manriquetavi.jetatapp.features.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.manriquetavi.jetatapp.common.component.progress.AtProgressIndicator
import com.manriquetavi.jetatapp.common.component.screen.EmptyContent
import com.manriquetavi.jetatapp.common.model.BetDetail
import com.manriquetavi.jetatapp.ui.theme.loseStatus
import com.manriquetavi.jetatapp.ui.theme.neutralStatus
import com.manriquetavi.jetatapp.ui.theme.wonStatus
import com.manriquetavi.jetatapp.util.toTypeName

@Composable
fun DetailScreen(
    paddingValues: PaddingValues,
    uiState: DetailUiState
) {
    when (uiState) {
        DetailUiState.Error -> {
            EmptyContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                title = "Error reintentar"
            )
        }
        DetailUiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                AtProgressIndicator()
            }
        }
        is DetailUiState.Success -> {
            DetailContent(
                paddingValues = paddingValues,
                betDetail = uiState.betDetail
            )
        }
    }
}

@Composable
fun DetailContent(
    paddingValues: PaddingValues,
    betDetail: BetDetail
) {
    var isExpanded by remember { mutableStateOf(false) }
    val colorStatus = remember(betDetail.betStatusName) {
        when (betDetail.betStatusName) {
            "Ganado" -> wonStatus
            "Perdido" -> loseStatus
            "Abierto" -> neutralStatus
            else -> neutralStatus
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Estado:",
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                    Text(
                        text = betDetail.betStatusName,
                        fontWeight = FontWeight.Bold,
                        color = colorStatus
                    )
                }
                HorizontalDivider(
                    color = Color.White
                )
                BetDetailRow(
                    label = "Nivel:",
                    value = betDetail.betLevel
                )
                HorizontalDivider(
                    color = Color.White
                )
                BetDetailRow(
                    label = "Tipo:",
                    value = betDetail.betTypeName.toTypeName()
                )
                HorizontalDivider(
                    color = Color.White
                )
                BetDetailRow(
                    label = "Fecha:",
                    value = betDetail.createdDate
                )
                HorizontalDivider(
                    color = Color.White
                )
                BetDetailRow(
                    label = "Monto:",
                    value = betDetail.totalStake
                )
                HorizontalDivider(
                    color = Color.White
                )
                BetDetailRow(
                    label = "Ganancia:",
                    value = "S/. " + betDetail.totalWin
                )
                HorizontalDivider(
                    color = Color.White
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Eventos",
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                    IconButton(
                        onClick = {
                            isExpanded = !isExpanded
                        }
                    ) {
                        Icon(
                            imageVector = if (isExpanded) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
                            contentDescription = "Icon Expand",
                            tint = Color.Black
                        )
                    }

                }
                AnimatedVisibility(visible = isExpanded) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        betDetail.betSelections.forEach { betSelection ->
                            EventDetailRow(
                                label = betSelection.eventName,
                                value = "Cuota: ${betSelection.price}"
                            )
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))
            }
        }
    }

}

@Composable
fun BetDetailRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = value,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun EventDetailRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.weight(0.65f),
            text = label,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Text(
            modifier = Modifier
                .weight(0.35f)
                .padding(start = 4.dp),
            text = value,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}