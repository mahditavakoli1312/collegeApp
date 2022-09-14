package com.example.collegeapp.features.authentication.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentLoginBinding
import com.example.collegeapp.databinding.SnackbarLayoutBinding
import com.example.collegeapp.easyNavigateWithPopUp
import com.example.collegeapp.features.authentication.ui.AuthenticationViewModel
import com.google.android.material.snackbar.Snackbar
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


    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

            // SnackBar
            val snackBar: Snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG)
            val viewSnack: Snackbar.SnackbarLayout = snackBar.view as Snackbar.SnackbarLayout
            val snackBarBinding: SnackbarLayoutBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.snackbar_layout,
                null,
                false
            )
            val params = viewSnack.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.TOP
            viewSnack.layoutParams = params
            viewSnack.setBackgroundColor(
                ResourcesCompat.getColor(
                    root.resources,
                    R.color.transparent100,
                    root.context.theme
                )
            )
            viewSnack.addView(snackBarBinding.root, 0)
            snackBar.show()
        }


    }
}