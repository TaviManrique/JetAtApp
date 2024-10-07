package com.manriquetavi.jetatapp.common.model

import com.google.gson.annotations.SerializedName


data class BetDetail(
    @SerializedName("BetNivel")
    val betLevel: String,
    val BetStarts: Int,
    val BetStatusName: String,
    val BetTypeName: String,
    val BgSrc: String,
    val CashoutOdds: String,
    val TotalOdds: String,
    val TotalStake: String,
    val TotalWin: String,
    val CashoutValue: String,
    val CreatedDate: String,
    val BetSelections: List<BetSelection>,
    val BetStatus: Int,
    val BetType: Int,
    val BetId: Long
)
