package com.manriquetavi.jetatapp.common.model

import com.google.gson.annotations.SerializedName


data class Bet(
    @SerializedName("db")
    val db: Int,
    @SerializedName("operation")
    val operation: Long,
    @SerializedName("game")
    val game: String,
    @SerializedName("created_date")
    val createdDate: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("wager")
    val wager: Int,
    @SerializedName("winning")
    val winning: Double?,
    @SerializedName("odds")
    val odds: Double,
    @SerializedName("type")
    val type: String,
    @SerializedName("account")
    val account: String
)
