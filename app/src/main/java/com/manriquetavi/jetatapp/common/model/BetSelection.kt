package com.manriquetavi.jetatapp.common.model

import kotlinx.serialization.Serializable

@Serializable
data class BetSelection(
    val SelectionId: Long,
    val SelectionStatus: Int,
    val Price: String,
    val Name: String,
    val Spec: String?,
    val MarketTypeId: Int,
    val MarketId: Long,
    val MarketName: String,
    val IsLive: Boolean,
    val IsBetBuilder: Boolean,
    val IsBanker: Boolean,
    val IsVirtual: Boolean,
    val BBSelections: List<BBSelection>?,
    val EventId: Long,
    val EventCode: String?,
    val FeedEventId: Long,
    val EventName: String,
    val SportTypeId: Int,
    val CategoryId: Int,
    val CategoryName: String?,
    val ChampId: Int,
    val ChampName: String?,
    val EventScore: String?,
    val GameTime: String?,
    val EventDate: String,
    val PitcherInfo: String?,
    val Runners: String?,
    val ExtraEventInfo: String?,
    val RC: Boolean,
    val LiveInfoAtEventMinute: String?,
    val IsLiveOrVirtual: Boolean,
    val EarlyPayout: Boolean,
    val BoreDraw: Boolean,
    val DeadHeatFactor: String?,
    val DbId: Int
)
