package com.example.collegeapp.features.authentication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.core.common.easyNavigateWithPopUp
import com.example.collegeapp.core.data.ConstanceValue
import com.example.collegeapp.core.ui.CustomSnackBar
import com.example.collegeapp.databinding.FragmentLoginBinding
import com.example.collegeapp.features.authentication.ui.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val phonePattern = "09[0-9]{9}"

    private val loginViewModel: LoginViewModel by viewModels()
    lateinit var binding: FragmentLoginBinding
    private var phoneNumberValid = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_login,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = loginViewModel
            lifecycleOwner = viewLifecycleOwner

            btnLoginLoginFragment.setOnClickListener {
                loginViewModel.login()
                ProgressLoginLoginFragment.visibility = View.VISIBLE
                btnLoginLoginFragment.visibility = View.GONE
            }

            loginViewModel.phoneNumber.observe(viewLifecycleOwner) {
                val checkMessage = checkPhoneNumber(it)
                if (checkMessage.isEmpty()) {
                    tilMobileNumberLoginFragment.isErrorEnabled = false
                    phoneNumberValid = true
                } else {
                    tilMobileNumberLoginFragment.error = checkMessage
                    phoneNumberValid = false
                }
            }
            loginViewModel.loginMessage.observe(viewLifecycleOwner) {
                if (it.equals(ConstanceValue.SUCCESS))
                    Navigation.easyNavigateWithPopUp(
                        action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(),
                        navController = findNavController(),
                        popUpId = R.id.loginFragment,
                        inclusive = true
                    )
                else CustomSnackBar.Builder(
                    view = view,
                    requiredActivity = requireActivity()
                ).setDescriptionText(it)
                    .build().showSnackBar()

                btnLoginLoginFragment.visibility = View.VISIBLE
                ProgressLoginLoginFragment.visibility = View.GONE
            }

            tvRegisterLoginFragment.setOnClickListener {
                Navigation.easyNavigateWithPopUp(
                    action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment(),
                    navController = findNavController(),
                    popUpId = R.id.loginFragment,
                    inclusive = true
                )
            }
        }
    }

    private fun checkPhoneNumber(phoneNumber: String): String {
        if (!phonePattern.toRegex().matches(phoneNumber)) {
            return getString(R.string.label_phone_number_error)
        }
        return ""
    }
}