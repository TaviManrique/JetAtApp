package com.manriquetavi.jetatapp.util

import kotlinx.coroutines.delay
import kotlin.random.Random

suspend fun delayShortTime() {
    val time = Random.nextInt(1500, 2500).toLong()
    delay(time)
}

suspend fun delayMediumTime() {
    val time = Random.nextInt(3500, 5500).toLong()
    delay(time)
}

suspend fun delayLongTime() {
    val time = Random.nextInt(6500, 8500).toLong()
    delay(time)
}