package com.manriquetavi.jetatapp.common.model

enum class AtDrawerState {
    Opened,
    Closed
}

fun AtDrawerState.isOpen() = this.name == "Opened"

fun AtDrawerState.opposite() = if (this == AtDrawerState.Opened) AtDrawerState.Closed else AtDrawerState.Opened