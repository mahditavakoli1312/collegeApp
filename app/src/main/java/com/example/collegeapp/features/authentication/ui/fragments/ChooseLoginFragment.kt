package com.example.collegeapp.features.authentication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.core.common.easyNavigateWithPopUp
import com.example.collegeapp.databinding.FragmentChooseLoginBinding

class ChooseLoginFragment : Fragment() {

    lateinit var binding: FragmentChooseLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_choose_login,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnRegisterChooseLoginFragment.setOnClickListener {
                Navigation.easyNavigateWithPopUp(
                    action = ChooseLoginFragmentDirections.actionChooseLoginFragmentToRegisterFragment(),
                    navController = findNavController(),
                    popUpId = R.id.chooseLoginFragment,
                    inclusive = true
                )
            }

            btnLoginChooseLoginFragment.setOnClickListener {
                Navigation.easyNavigateWithPopUp(
                    action = ChooseLoginFragmentDirections.actionChooseLoginFragmentToLoginFragment(),
                    navController = findNavController(),
                    popUpId = R.id.chooseLoginFragment,
                    inclusive = true
                )
            }

        }
    }

}