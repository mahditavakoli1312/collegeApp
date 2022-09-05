package com.example.collegeapp.register_Login

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.easyNavigateWithPopUp

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Handler().postDelayed({
            Navigation.easyNavigateWithPopUp(
                action = R.id.action_splashFragment_to_chooseLoginFragment,
                navController = findNavController(),
                popUpId = R.id.splashFragment,
                inclusive = true
            )
        }, 3000)
    }


}