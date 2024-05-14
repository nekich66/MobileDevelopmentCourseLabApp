package com.example.mobiledevelopmentcourselabapp.presentation.view.second.model

interface ItemUiModel

class PlayerUiModel(
    val name: String,
    val photoUrl: String,
    val number: Int,
    val team: String,
    val age: Int,
    var isExpanded: Boolean = false
): ItemUiModel {
    val formattedTeam = "Команда: $team"
    object AdUiModel : ItemUiModel

}