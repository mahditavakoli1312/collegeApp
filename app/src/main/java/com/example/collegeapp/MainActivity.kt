package com.example.collegeapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    var lastClick = 0L

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


        val bottomNav: BottomNavigationView = findViewById(R.id.bn_activityMain)
        bottomNav.setupWithNavController(navController)
        globalMain = this
        // mahdi tavakoli profile : https://github.com/mahditavakoli1312/FragmentTransaction---mahdi-tavakoli
        navController
            .addOnDestinationChangedListener { _, dest, _ ->
                when (dest.id) {
                    R.id.homeFragment, R.id.profileFragment, R.id.searchFragment -> bottomNav.visibility =
                        View.VISIBLE
                    else -> bottomNav.visibility = View.GONE
                }
            }


    }


    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.homeFragment) {
            val now = System.currentTimeMillis()
            if (now - lastClick < 2000L) {
                finish()
            } else {
                showMessage()
                lastClick = now
            }
        } else if (navController.currentDestination?.id == R.id.searchFragment || navController.currentDestination?.id == R.id.profileFragment) {
            FragmentNavigationMethod.navigate(
                action = R.id.homeFragment,
                navController = navController
            )
        } else {
            super.onBackPressed()

        }
    }

    fun showMessage() {
        Toast.makeText(globalMain, "از خروج مطمئنید ؟", Toast.LENGTH_SHORT)
            .show()
    }


}

