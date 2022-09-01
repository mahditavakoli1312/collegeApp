package com.example.collegeapp.register_Login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.FragmentNavigationMethod
import com.example.collegeapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val snackBar: Snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG)
        val viewSnack: Snackbar.SnackbarLayout = snackBar.view as Snackbar.SnackbarLayout
        val customLayoutSnack = layoutInflater.inflate(R.layout.snackbar_internet_error, null)
        val params = viewSnack.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP
        viewSnack.layoutParams = params
        viewSnack.setBackgroundColor(view.resources.getColor(R.color.transparent100))
        viewSnack.addView(customLayoutSnack, 0)
        snackBar.show()
        btn_login_loginFragment.setOnClickListener {

            FragmentNavigationMethod.navigateWithPopUp(
                action = R.id.action_loginFragment_to_homeFragment,
                navController = findNavController(),
                popUpId = R.id.chooseLoginFragment,
                inclusive = true
            )
        }


    }
}