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
import com.example.collegeapp.databinding.FragmentConfirmRegisterBinding

class ConfirmRegisterFragment : Fragment() {

    lateinit var binding: FragmentConfirmRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_confirm_register,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnLoginConfirmRegister.setOnClickListener {
                Navigation.easyNavigateWithPopUp(
                    action = ConfirmRegisterFragmentDirections.actionConfirmRegisterFragmentToLoginFragment(),
                    navController = findNavController(),
                    popUpId = R.id.confirmRegisterFragment,
                    inclusive = true
                )
            }
        }

    }

}