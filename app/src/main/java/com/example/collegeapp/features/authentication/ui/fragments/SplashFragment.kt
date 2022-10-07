package com.example.collegeapp.features.authentication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.core.common.easyNavigateWithPopUp
import com.example.collegeapp.databinding.FragmentSplashBinding
import com.example.collegeapp.features.authentication.ui.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private val splashViewModel: SplashViewModel by viewModels()
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_splash,
            container,
            false
        )
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        try {
            lifecycleScope.launch(Dispatchers.IO) {
                delay(3000)
                withContext(Dispatchers.Main) {
                    checkLogin()
                }

            }
        } catch (e: Exception) {

        }
    }

    private fun checkLogin() {
        if (splashViewModel.isLogin()) {
            Navigation.easyNavigateWithPopUp(
                action = SplashFragmentDirections.actionSplashFragmentToHomeFragment(),
                navController = findNavController(),
                popUpId = R.id.splashFragment,
                inclusive = true
            )
        } else {
            Navigation.easyNavigateWithPopUp(
                action = SplashFragmentDirections.actionSplashFragmentToChooseLoginFragment(),
                navController = findNavController(),
                popUpId = R.id.splashFragment,
                inclusive = true
            )
        }
    }

}