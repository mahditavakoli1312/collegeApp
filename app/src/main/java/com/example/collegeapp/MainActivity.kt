package com.example.collegeapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

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

        val bottomNav : BottomNavigationView = findViewById(R.id.bn_activityMain)
        bottomNav.setupWithNavController(navController)
        globalMain = this
        // mahdi tavakoli profile : https://github.com/mahditavakoli1312/FragmentTransaction---mahdi-tavakoli
        navController
            .addOnDestinationChangedListener{_,dest,_ ->
                when(dest.id){
                    R.id.homeFragment , R.id.profileFragment , R.id.searchFragment -> bottomNav.visibility = View.VISIBLE
                    else -> bottomNav.visibility = View.GONE
                }
        }


    }

}
