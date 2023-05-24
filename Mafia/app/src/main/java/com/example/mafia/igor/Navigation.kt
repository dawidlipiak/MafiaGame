package com.example.mafia.igor

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(context: Context, viewModel: VariableViewModel)
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Loading.route) {
            LoadingScreen(navController = navController)
        }
        composable(route = Screen.Role.route) {
            RoleScreen(navController = navController, context, viewModel)
        }
    }
}