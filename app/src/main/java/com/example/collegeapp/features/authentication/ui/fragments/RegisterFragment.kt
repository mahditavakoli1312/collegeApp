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
import com.example.collegeapp.databinding.FragmentRegisterBinding
import com.example.collegeapp.features.authentication.ui.viewModel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val persianCharacterPattern = "[ءآأؤإئابپتثجچحخدذرزژسشصضطظعغفقکگلمنوهھی ]+"
    private val usernamePattern = "[a-zA-Z0-9_]+"

    //todo change Pattern of UserName_Pattern
    private val phonePattern = "09[0-9]{9}"
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]{2,4}"
    private val passwordPattern = "[a-zA-Z0-9._-]+"

    private val registerViewModel: RegisterViewModel by viewModels()
    lateinit var binding: FragmentRegisterBinding
    private var nameValid = false
    private var lastNameValid = false
    private var usernameValid = false
    private var emailValid = false
    private var phoneNumberValid = false
    private var passwordValid = false

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
            viewModel = registerViewModel
            lifecycleOwner = viewLifecycleOwner
            registerViewModel.name.observe(viewLifecycleOwner) {
                val checkMessage = checkFirstName(it)
                if (checkMessage.isEmpty()) {
                    tilNameRegisterFragment.isErrorEnabled = false
                    nameValid = true
                } else {
                    tilNameRegisterFragment.error = checkMessage
                    nameValid = false
                }
            }
            registerViewModel.lastName.observe(viewLifecycleOwner) {
                val checkMessage = checkLastName(it)
                if (checkMessage.isEmpty()) {
                    tilFamilyRegisterFragment.isErrorEnabled = false
                    lastNameValid = true
                } else {
                    tilFamilyRegisterFragment.error = checkMessage
                    lastNameValid = false
                }
            }
            registerViewModel.username.observe(viewLifecycleOwner) {
                val checkMessage = checkUsername(it)
                if (checkMessage.isEmpty()) {
                    tilUsernameRegisterFragment.isErrorEnabled = false
                    usernameValid = true
                } else {
                    tilUsernameRegisterFragment.error = checkMessage
                    usernameValid = false
                }
            }
            registerViewModel.email.observe(viewLifecycleOwner) {
                val checkMessage = checkEmail(it)
                if (checkMessage.isEmpty()) {
                    tilEmailRegisterFragment.isErrorEnabled = false
                    emailValid = true
                } else {
                    tilEmailRegisterFragment.error = checkMessage
                    emailValid = false
                }
            }
            registerViewModel.phoneNumber.observe(viewLifecycleOwner) {
                val checkMessage = checkPhoneNumber(it)
                if (checkMessage.isEmpty()) {
                    tilMobileNumberRegisterFragment.isErrorEnabled = false
                    phoneNumberValid = true
                } else {
                    tilMobileNumberRegisterFragment.error = checkMessage
                    phoneNumberValid = false
                }
            }
            registerViewModel.password.observe(viewLifecycleOwner) {
                val checkMessage = checkPassword(it)
                if (checkMessage.isEmpty()) {
                    tilPasswordRegisterFragment.isErrorEnabled = false
                    passwordValid = true
                } else {
                    tilPasswordRegisterFragment.error = checkMessage
                    passwordValid = false
                }
            }
            btnRegisterRegisterFragment.setOnClickListener {
                if (checkAllValidation()) {
                    registerViewModel.register()
                    ProgressRegisterRegisterFragment.visibility = View.VISIBLE
                    btnRegisterRegisterFragment.visibility = View.GONE
                }
                else CustomSnackBar.Builder(
                    view = view,
                    requiredActivity = requireActivity()
                ).setDescriptionText(getString(R.string.label_validation_true))
                    .build().showSnackBar()
            }
            tvLoginRegisterFragment.setOnClickListener {
                Navigation.easyNavigateWithPopUp(
                    action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment(),
                    navController = findNavController(),
                    popUpId = R.id.registerFragment,
                    inclusive = true
                )
            }

            registerViewModel.registerMessage.observe(viewLifecycleOwner) {
                if (it.equals(ConstanceValue.SUCCESS)) {
                    Navigation.easyNavigateWithPopUp(
                        action = RegisterFragmentDirections.actionRegisterFragmentToConfirmRegisterFragment(),
                        navController = findNavController(),
                        popUpId = R.id.registerFragment,
                        inclusive = true
                    )
                } else {
                    CustomSnackBar.Builder(
                        view = view,
                        requiredActivity = requireActivity()
                    )
                        .setDescriptionText(it)
                        .build()
                        .showSnackBar()
                }
                btnRegisterRegisterFragment.visibility = View.VISIBLE
                ProgressRegisterRegisterFragment.visibility = View.GONE
            }
        }

    }

    private fun checkFirstName(firstName: String): String {
        if (firstName.length < 3) {
            return getString(R.string.label_name_length_error)
        } else if (!persianCharacterPattern.toRegex().matches(firstName)) {
            return getString(R.string.label_name_persian_error)
        }
        return ""
    }

    private fun checkLastName(firstName: String): String {
        if (firstName.length < 3) {
            return getString(R.string.label_last_name_length_error)
        } else if (!persianCharacterPattern.toRegex().matches(firstName)) {
            return getString(R.string.label_last_name_persian_error)
        }
        return ""
    }

    private fun checkUsername(username: String): String {
        if (username.length < 6) {
            return getString(R.string.label_username_length_error)
        } else if (!usernamePattern.toRegex().matches(username)) {
            return getString(R.string.label_username_pattern_error)
        }
        return ""
    }

    private fun checkEmail(email: String): String {
        if (!emailPattern.toRegex().matches(email)) {
            return getString(R.string.label_email_error)
        }
        return ""
    }

    private fun checkPhoneNumber(phoneNumber: String): String {
        if (!phonePattern.toRegex().matches(phoneNumber)) {
            return getString(R.string.label_phone_number_error)
        }
        return ""
    }

    private fun checkPassword(password: String): String {
        if (password.trim().length < 6) {
            return getString(R.string.label_password_length_error)
        } else if (!passwordPattern.toRegex().matches(password)) {
            return getString(R.string.label_password_error)
        }
        return ""
    }

    private fun checkAllValidation(): Boolean {
        return nameValid && lastNameValid && usernameValid
                && emailValid && phoneNumberValid && passwordValid
    }


}