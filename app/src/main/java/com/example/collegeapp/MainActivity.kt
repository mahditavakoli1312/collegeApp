package com.example.collegeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    companion object {
        var globalMain: MainActivity? = null
            get() {
                if (field == null) {
                    field = MainActivity()
                    return field
                } else
                    return field
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost =
            supportFragmentManager.findFragmentById(R.id.fcv_fragmentContainer_activityMain) as NavHostFragment
        navController = navHost.navController


        globalMain = this
        // mahdi tavakoli profile : https://github.com/mahditavakoli1312/FragmentTransaction---mahdi-tavakoli


    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fcv_fragmentContainer_activityMain, fragment)
        }
    }

    fun addFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            add(R.id.fcv_fragmentContainer_activityMain, fragment)
        }
    }

    fun replaceFragmentWithAddToBackStack(fragment: Fragment, backStackName: String? = null) {
        supportFragmentManager.commit {
            replace(R.id.fcv_fragmentContainer_activityMain, fragment)
            addToBackStack(backStackName)
        }
    }

    fun addFragmentWithAddToBackStack(fragment: Fragment, backStackName: String? = null) {
        supportFragmentManager.commit {
            replace(R.id.fcv_fragmentContainer_activityMain, fragment)
            addToBackStack(backStackName)

        }
    }

}
