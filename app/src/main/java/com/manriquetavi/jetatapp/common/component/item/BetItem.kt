package com.manriquetavi.jetatapp.common.component.item

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.manriquetavi.jetatapp.common.model.Bet
import com.manriquetavi.jetatapp.common.model.BetState
import com.manriquetavi.jetatapp.ui.theme.loseStatus
import com.manriquetavi.jetatapp.ui.theme.neutralStatus
import com.manriquetavi.jetatapp.ui.theme.scrimLight
import com.manriquetavi.jetatapp.ui.theme.wonStatus
import com.manriquetavi.jetatapp.util.formatDate

@Composable
fun BetItem(
    bet: Bet,
    navigateToDetail: (String) -> Unit
) {
    val colorStatus = remember(bet.status) {
        when (bet.status) {
            BetState.WON.name -> wonStatus
            BetState.LOST.name -> loseStatus
            else -> neutralStatus
        }
    }
    val textStatus = remember(bet.status) {
        when (bet.status) {
            BetState.WON.name -> "Ganado"
            BetState.LOST.name -> "Perdido"
            else -> "Abierto"
        }
    }
    val formattedDate = remember(bet.createdDate) {
        formatDate(bet.createdDate)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        colors = CardColors(
            containerColor = Color.Transparent,
            contentColor = scrimLight,
            disabledContentColor = scrimLight,
            disabledContainerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .padding(start = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = textStatus,
                        color = colorStatus,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .background(
                                color = colorStatus.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = formattedDate,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                IconButton(
                    onClick = {
                        navigateToDetail(bet.game)
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = "Icon To Navigate More Detail",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}