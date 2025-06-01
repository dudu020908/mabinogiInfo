package com.example.mabinogiinfoapp.data

import java.io.Serializable

data class GameRune(
    val id: Int,
    val category: String,     // 무기, 방어구, 엠블럼, 장신구
    val title: String,
    val description: String,
    val iconResId: Int
) : Serializable {
    fun toGameInfo(): GameInfo = GameInfo(
        id = id,
        title = title,
        description = description,
        iconResId = iconResId
    )
}
