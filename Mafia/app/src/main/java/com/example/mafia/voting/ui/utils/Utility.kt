/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.mafia.voting.ui.utils

import com.example.mafia.Player
import com.example.mafia.Role
import java.util.concurrent.TimeUnit

object Utility {

    // time to countdown - 1hr - 60secs
    const val TIME_COUNTDOWN: Long = 60000L
    private const val TIME_FORMAT = "%02d:%02d"
    val playerList: ArrayList<Player> = createPlayer()

    // convert time to milli seconds
    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MILLISECONDS.toMinutes(this),
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )

    private fun createPlayer (): ArrayList<Player>{

        val playersList = ArrayList<Player>()
        playersList.add(Player("Wiktoria", Role.MAFIA))
        playersList.add(Player("Martyna", Role.DETECTIVE))
        playersList.add(Player("Kasia", Role.MAFIA))
        playersList.add(Player("Dawid", Role.CIVIL))
        playersList.add(Player("Denis", Role.CIVIL))
        playersList.add(Player("Igor", Role.DETECTIVE))
        playersList.add(Player("Jakub", Role.CIVIL))
        playersList.add(Player("Karol", Role.CIVIL))
        playersList.add(Player("Mikołaj", Role.DOCTOR))

        return playersList
    }
}
