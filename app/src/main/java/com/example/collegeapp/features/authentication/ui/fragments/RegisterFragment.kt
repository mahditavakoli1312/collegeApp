package com.example.collegeapp.features.authentication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentRegisterBinding
import com.example.collegeapp.core.common.easyNavigateWithPopUp
import com.example.collegeapp.features.authentication.ui.AuthenticationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val authenticationViewModel: AuthenticationViewModel by activityViewModels()
    lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_register,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewmodel = authenticationViewModel
            lifecycleOwner = viewLifecycleOwner

            btnRegisterRegisterFragment.setOnClickListener {
                Navigation.easyNavigateWithPopUp(
                    action = R.id.action_registerFragment_to_confirmRegisterFragment,
                    navController = findNavController(),
                    popUpId = R.id.registerFragment,
                    inclusive = true
                )
            }
        }
    }

}