package com.example.collegeapp.core.common

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigation

fun Navigation.easyNavigate(action: NavDirections, navController: NavController) {
    try {
        navController.navigate(action)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}

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

fun Navigation.easyNavigateWithPopUp(
    action: NavDirections,
    navController: NavController,
    popUpId: Int,
    inclusive: Boolean
) {
    val options = NavOptions.Builder().setPopUpTo(popUpId, inclusive).build()
    try {
        navController.navigate(action, options)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}
