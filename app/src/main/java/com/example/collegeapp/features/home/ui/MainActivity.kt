package com.example.collegeapp.features.home.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.collegeapp.R
import com.example.collegeapp.easyNavigate
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

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
                showMassage(findViewById<View?>(R.id.fcv_fragmentContainer_activityMain).rootView)
                lastClick = now
            }
        } else if (navController.currentDestination?.id == R.id.searchFragment || navController.currentDestination?.id == R.id.profileFragment) {
            Navigation.easyNavigate(
                action = R.id.homeFragment,
                navController = navController
            )
        } else {
            super.onBackPressed()

        }
    }

    private fun showMassage(view: View) {
        val snackBar: Snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG)
        val viewSnack: Snackbar.SnackbarLayout = snackBar.view as Snackbar.SnackbarLayout
        val customLayoutSnack = layoutInflater.inflate(R.layout.snackbar_internet_error, null)
        viewSnack.setBackgroundColor(view.resources.getColor(R.color.transparent100))
        viewSnack.addView(customLayoutSnack, 0)
        viewSnack.findViewById<TextView>(R.id.tv_okAction_snackLayout).visibility = View.GONE
        viewSnack.findViewById<TextView>(R.id.tv_cancelAction_snackLayout).visibility =
            View.GONE
        viewSnack.findViewById<ImageView>(R.id.img_icon_snackLayout).visibility = View.GONE
        viewSnack.findViewById<TextView>(R.id.tv_desc_SnackLayout).text =
            getString(R.string.label_exit)
        snackBar.show()
    }


}

