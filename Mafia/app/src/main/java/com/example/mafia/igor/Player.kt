package com.example.mafia.igor

enum class PlayerType{
    MAFIA,
    DETECTIVE,
    TOWN_PERSON,
    MEDIC
}

class Player(playerName: String, playerType: PlayerType)
{
    private var name: String
    private var type: PlayerType

    init
    {
        name = playerName
        type = playerType
    }

    fun getName(): String
    {
        return name
    }
    fun getType(): PlayerType
    {
        return type
    }
}