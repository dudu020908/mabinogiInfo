package com.example.mabinogiinfoapp.data

import java.io.Serializable

data class GameSkill(
    val id: Int,
    val jobGroup: String,
    val jobClass: String,
    val title: String,
    val description: String,
    val iconResId: Int
) : Serializable {


    fun toGameInfo(): GameInfo = GameInfo(
        id, title, description, iconResId
    )
}
