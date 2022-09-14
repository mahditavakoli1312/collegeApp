package com.example.collegeapp.features.authentication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentSplashBinding
import com.example.collegeapp.easyNavigateWithPopUp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        try {
            lifecycleScope.launch(Dispatchers.IO) {
                delay(3000)
                withContext(Dispatchers.Main) {
                    Navigation.easyNavigateWithPopUp(
                        action = R.id.action_splashFragment_to_chooseLoginFragment,
                        navController = findNavController(),
                        popUpId = R.id.splashFragment,
                        inclusive = true
                    )
                }

            }
        } catch (e: Exception) {

        }

    }


}