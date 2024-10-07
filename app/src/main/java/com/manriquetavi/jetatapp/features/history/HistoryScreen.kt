package com.manriquetavi.jetatapp.features.history

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.manriquetavi.jetatapp.common.model.Bet
import java.lang.reflect.Type

@Composable
fun HistoryScreen(
    paddingValues: PaddingValues
) {
    val jsonString = LocalContext.current.assets.open("betsHistory.json").bufferedReader().use { it.readText() }
    val gson = Gson()
    val listType: Type = object : TypeToken<List<Bet>>() {}.type
    val bets: List<Bet> = gson.fromJson(jsonString, listType)
    Log.d("HistoryScreen", bets[0].type)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("HISTORY SCREEN")
    }
}