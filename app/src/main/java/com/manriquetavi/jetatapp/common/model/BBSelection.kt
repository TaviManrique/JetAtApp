package com.manriquetavi.jetatapp.common.model

import kotlinx.serialization.Serializable

@Serializable
data class BBSelection(
    val SelectionId: Long,
    val SelectionName: String,
    val MarketName: String,
    val EarlyPayout: Boolean,
    val BoreDraw: Boolean,
    val SelectionStatus: Int
)
