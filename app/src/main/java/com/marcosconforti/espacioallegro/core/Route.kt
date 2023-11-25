package com.marcosconforti.espacioallegro.core

sealed class Route(val route:String){
    object Login:Route("LoginScreen")
    object Menu:Route("MenuScreen")
    object Register:Route("RegisterScreen")
    object TeacherProfile:Route("TeacherProfileScreen")
    object UserProfile:Route("UserProfileScreen")
}
