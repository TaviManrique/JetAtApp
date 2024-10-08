package com.manriquetavi.jetatapp.common.model

import com.google.gson.annotations.SerializedName

data class BetDetail(
    @SerializedName("BetNivel")
    val betLevel: String,
    @SerializedName("BetStarts")
    val betStarts: Int,
    @SerializedName("BetStatusName")
    val betStatusName: String,
    @SerializedName("BetTypeName")
    val betTypeName: String,
    @SerializedName("BgSrc")
    val bgSrc: String,
    @SerializedName("CashoutOdds")
    val cashOutOdds: String,
    @SerializedName("TotalOdds")
    val totalOdds: String,
    @SerializedName("TotalStake")
    val totalStake: String,
    @SerializedName("TotalWin")
    val totalWin: String,
    @SerializedName("CashoutValue")
    val cashOutValue: String,
    @SerializedName("CreatedDate")
    val createdDate: String,
    @SerializedName("BetSelections")
    val betSelections: List<BetSelection>,
    @SerializedName("BetStatus")
    val betStatus: Int,
    @SerializedName("BetType")
    val betType: Int,
    @SerializedName("BetId")
    val betId: Long
)
