package com.example.mabinogiinfoapp.data

import java.io.Serializable

data class GameInfo(
    val id: Int,
    val title: String,
    val subtitle : String,
    val description: String,
    val iconResId: Int,
    val searchKeys: List<String> = emptyList()

) : Serializable
