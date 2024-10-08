package com.manriquetavi.jetatapp.common.model

import com.google.gson.annotations.SerializedName

data class BetSelection(
    @SerializedName("SelectionId")
    val selectionId: Long,
    @SerializedName("SelectionStatus")
    val selectionStatus: Int,
    @SerializedName("Price")
    val price: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Spec")
    val spec: String?,
    @SerializedName("MarketTypeId")
    val marketTypeId: Int,
    @SerializedName("MarketId")
    val marketId: Long,
    @SerializedName("MarketName")
    val marketName: String,
    @SerializedName("IsLive")
    val isLive: Boolean,
    @SerializedName("IsBetBuilder")
    val isBetBuilder: Boolean,
    @SerializedName("IsBanker")
    val isBanker: Boolean,
    @SerializedName("IsVirtual")
    val isVirtual: Boolean,
    @SerializedName("BBSelections")
    val bBSelections: List<BBSelection>?,
    @SerializedName("EventId")
    val eventId: Long,
    @SerializedName("EventCode")
    val eventCode: String?,
    @SerializedName("FeedEventId")
    val feedEventId: Long,
    @SerializedName("EventName")
    val eventName: String,
    @SerializedName("SportTypeId")
    val sportTypeId: Int,
    @SerializedName("CategoryId")
    val categoryId: Int,
    @SerializedName("CategoryName")
    val categoryName: String?,
    @SerializedName("ChampId")
    val champId: Int,
    @SerializedName("ChampName")
    val champName: String?,
    @SerializedName("EventScore")
    val eventScore: String?,
    @SerializedName("GameTime")
    val gameTime: String?,
    @SerializedName("EventDate")
    val eventDate: String,
    @SerializedName("PitcherInfo")
    val pitcherInfo: String?,
    @SerializedName("Runners")
    val runners: String?,
    @SerializedName("ExtraEventInfo")
    val extraEventInfo: String?,
    @SerializedName("RC")
    val rc: Boolean,
    @SerializedName("LiveInfoAtEventMinute")
    val liveInfoAtEventMinute: String?,
    @SerializedName("IsLiveOrVirtual")
    val isLiveOrVirtual: Boolean,
    @SerializedName("EarlyPayout")
    val earlyPayout: Boolean,
    @SerializedName("BoreDraw")
    val boreDraw: Boolean,
    @SerializedName("DeadHeatFactor")
    val deadHeatFactor: String?,
    @SerializedName("DbId")
    val dbId: Int
)
