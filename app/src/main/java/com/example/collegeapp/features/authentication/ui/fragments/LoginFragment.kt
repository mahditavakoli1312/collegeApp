package com.example.collegeapp.features.authentication.ui.fragments

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.core.common.easyNavigateWithPopUp
import com.example.collegeapp.core.ui.CustomSnackBar
import com.example.collegeapp.databinding.FragmentLoginBinding
import com.example.collegeapp.features.authentication.ui.AuthenticationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val authenticationViewModel: AuthenticationViewModel by activityViewModels()
    lateinit var binding: FragmentLoginBinding

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

        CustomSnackBar
            .Builder(
                view = view,
                requiredActivity = requireActivity()
            )
            .setDescriptionText(view.resources.getString(R.string.label_internet_error))
            .setGravity(Gravity.TOP)
            .build()
            .showSnackBar()


        binding.apply {
            viewModel = authenticationViewModel
            lifecycleOwner = viewLifecycleOwner

            btnLoginLoginFragment.setOnClickListener {
                Navigation.easyNavigateWithPopUp(
                    action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(),
                    navController = findNavController(),
                    popUpId = R.id.chooseLoginFragment,
                    inclusive = true
                )
            }
        }

    }
}