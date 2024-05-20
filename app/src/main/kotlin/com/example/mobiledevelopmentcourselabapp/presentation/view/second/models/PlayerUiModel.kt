package com.example.mobiledevelopmentcourselabapp.presentation.view.second.model

import android.icu.text.Transliterator
import java.io.Serializable

interface ItemUiModel: Serializable


data class PlayerUiModel(
    val name: String,
    val photoUrl: String,
    val number: Int,
    val team: String,
    val position: Position,
    val age: Int,
    var isExpanded: Boolean = false,
    val gamesCount: Int,
    val goalsCount: Int,
    val gamesGrade: Int,
    val matchGrade: Int,
    val redCardsCount: Int,
    ): ItemUiModel {


        object AdUiModel : ItemUiModel
    enum class Position(val rusName: String = "") {
        COACH("Тренер"),
        DEFENDER("Защитник"),
        MIDFIELD("Полузащитник"),
        FORWARD("Нападающий")
    }

    }