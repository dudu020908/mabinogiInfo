package com.example.mabinogiinfoapp.data

import java.io.Serializable

data class GameInfo(
    val id: Int,
    val title: String,
    val description: String,
    val iconResId: Int
) : Serializable
