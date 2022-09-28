package com.example.collegeapp.features.home.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.collegeapp.R
import com.example.collegeapp.core.common.LocalDatabase
import com.example.collegeapp.core.common.easyNavigate
import com.example.collegeapp.core.ui.CustomSnackBar
import com.example.collegeapp.databinding.ActivityMainBinding
import com.example.collegeapp.features.article.data.model.ArticleEntity
import com.example.collegeapp.features.article.data.model.TagEntity
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
    var lastClick = 0L
    companion object {
        var globalMain: MainActivity? = null
            get() {
                return if (field == null) {
                    field = MainActivity()
                    field
                } else
                    field
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        globalMain = this
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
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
                        R.id.homeFragment, R.id.profileFragment, R.id.searchFragment ->
                            bottomNav.visibility = View.VISIBLE
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
                CustomSnackBar.Builder(
                    view = binding.root,
                    requiredActivity = this
                )
                    .setDescriptionText(getString(R.string.label_exit))
                    .build()
                    .showSnackBar()
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
}

