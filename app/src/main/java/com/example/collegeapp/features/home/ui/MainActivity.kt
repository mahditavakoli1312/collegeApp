package com.example.collegeapp.features.home.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.collegeapp.R
import com.example.collegeapp.databinding.ActivityMainBinding
import com.example.collegeapp.databinding.SnackbarLayoutBinding
import com.example.collegeapp.easyNavigate
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
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

        globalMain = this
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHost =
            supportFragmentManager.findFragmentById(R.id.fcv_fragmentContainer_activityMain)
                    as NavHostFragment
        navController = navHost.navController


        binding.apply {

            val bottomNav: BottomNavigationView = bnActivityMain
            bottomNav.setupWithNavController(navController)
            navController
                .addOnDestinationChangedListener { _, dest, _ ->
                    when (dest.id) {
                        R.id.homeFragment, R.id.profileFragment, R.id.searchFragment -> bottomNav.visibility =
                            View.VISIBLE
                        else -> bottomNav.visibility = View.GONE
                    }
                }

        }


    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.homeFragment) {
            val now = System.currentTimeMillis()
            if (now - lastClick < 2000L) {
                finish()
            } else {
                showMassage(binding.root)
                lastClick = now
            }
        } else if (navController.currentDestination?.id == R.id.searchFragment ||
            navController.currentDestination?.id == R.id.profileFragment
        ) {
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


        val snackBarBinding: SnackbarLayoutBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.snackbar_layout,
            null,
            false
        )
        snackBarBinding.apply {

            tvOkActionSnackLayout.visibility = View.GONE
            tvCancelActionSnackLayout.visibility =
                View.GONE
            imgIconSnackLayout.visibility = View.GONE
            tvDescSnackLayout.text =
                getString(R.string.label_exit)

        }

        viewSnack.setBackgroundColor(view.resources.getColor(R.color.transparent100))
        viewSnack.addView(snackBarBinding.root, 0)
        snackBar.show()
    }


}

