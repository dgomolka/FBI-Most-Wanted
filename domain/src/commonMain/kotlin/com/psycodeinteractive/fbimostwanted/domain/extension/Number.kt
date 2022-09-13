package com.psycodeinteractive.fbimostwanted.domain.extension // ktlint-disable filename

fun Long?.orZero() = this ?: 0L
fun Int?.orZero() = this ?: 0
fun Float?.orZero() = this ?: 0f
