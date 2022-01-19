package com.albe.borutoapp.navigation

/** Screen Holder Class*/
/** Used to add routes to each navigable screen in the app*/
sealed class Screen (val route: String){
    //Splash
    object Splash: Screen("splash_screen")

    //Welcome
    object Welcome: Screen("welcome_screen")

    //Home contains the list of all heroes retrieved from the boruto api
    object Home: Screen("home_screen")

    //Details will take a required argument which will be the hero details to pass to this screen
    // / = required argument, {"argumentId"} = argument ID
    object Details: Screen("details_screen/{heroId}"){
        fun passHeroId(heroId: Int) : String {
            return "details_screen/$heroId"
        }
    }

    //Search
    object Search: Screen("search_screen")
}