package com.example.collegeapp

import androidx.navigation.NavController
import androidx.navigation.NavOptions

class FragmentNavigationMethod {

    companion object {
        fun navigate(action: Int, navController: NavController) {
            navController.navigate(action)
        }

        fun navigateWithPopUp(
            action: Int,
            navController: NavController,
            popUpId: Int,
            inclusive: Boolean
        ) {
            val options = NavOptions.Builder().setPopUpTo(popUpId, inclusive).build()
            navController.navigate(action, null, options)
        }
    }
}