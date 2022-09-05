package com.example.collegeapp

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation

fun Navigation.easyNavigate(action: Int, navController: NavController) {
    try {
        navController.navigate(action)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}

fun Navigation.easyNavigateWithPopUp(
    action: Int,
    navController: NavController,
    popUpId: Int,
    inclusive: Boolean
) {
    val options = NavOptions.Builder().setPopUpTo(popUpId, inclusive).build()
    try {
        navController.navigate(action, null, options)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}

class FragmentNavigationMethod {

    companion object {

        fun navigate(action: Int, navController: NavController) {
            Navigation.easyNavigate(
                action = action,
                navController = navController
            )

        }

        fun navigateWithPopUp(
            action: Int,
            navController: NavController,
            popUpId: Int,
            inclusive: Boolean
        ) {
            Navigation.easyNavigateWithPopUp(
                action = action,
                navController = navController,
                popUpId = popUpId,
                inclusive = inclusive
            )
        }

    }
}