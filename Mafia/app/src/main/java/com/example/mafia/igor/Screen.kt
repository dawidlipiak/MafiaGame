package com.example.mafia.igor

sealed class Screen(val route: String)
{
    object Splash: Screen("splash_screen")
    object Loading: Screen("loading_screen")
    object Role: Screen("role_screen")
    object Entry: Screen("entry_screen")
}
