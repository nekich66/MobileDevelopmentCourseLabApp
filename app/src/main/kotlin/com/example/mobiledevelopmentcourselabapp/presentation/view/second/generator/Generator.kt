package com.example.mobiledevelopmentcourselabapp.presentation.view.list.generator
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.ItemUiModel
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.PlayerUiModel
import com.github.javafaker.Faker
import kotlin.random.Random
object Generator {
    private const val PLAYERS_COUNT = 7
    private const val PHOTO_LINK = "https://img.a.transfermarkt.technology/portrait/medium/"
    private val photos = arrayOf(
        "290532-1686212081.jpg",
        "709726-1672304545.jpg",
        "315252-1605116025.png",
        "748319-1694617058.jpg",
        "1036407-1706528684.jpg",
        "705864-1678301241.jpg",
        "149577-1617369576.png"
    )


    fun generate(): List<ItemUiModel> {
        val faker = Faker()
        return mutableListOf<ItemUiModel>().apply {
            repeat(PLAYERS_COUNT) {
                add(
                    PlayerUiModel(
                        name = faker.name().fullName(),
                        team = faker.team().name(),
                        number = (1..25).random(),
                        age = (18..35).random(),
                        position = PlayerUiModel.Position.values().random(),
                        photoUrl = PHOTO_LINK + photos.random(),
                        gamesCount = (1..99).random(),
                        goalsCount = (1..17).random(),
                        gamesGrade = (1..5).random(),
                        matchGrade = (1..5).random(),
                        redCardsCount = (1..4).random()
                    )
                )
               // if (Random.nextBoolean()) add(PlayerUiModel.AdUiModel)
            }
        }
    }
}
