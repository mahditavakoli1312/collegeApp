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
import com.example.collegeapp.databinding.FragmentChooseLoginBinding
import com.example.collegeapp.core.common.easyNavigate

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
                Navigation.easyNavigate(
                    action = R.id.action_chooseLoginFragment_to_registerFragment,
                    navController = findNavController(),
                )
            }

            btnLoginChooseLoginFragment.setOnClickListener {
                Navigation.easyNavigate(
                    action = R.id.action_chooseLoginFragment_to_loginFragment,
                    navController = findNavController(),
                )
            }

        }
    }

}