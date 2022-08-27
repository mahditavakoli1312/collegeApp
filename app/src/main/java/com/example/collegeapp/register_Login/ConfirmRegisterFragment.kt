package com.example.collegeapp.register_Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.FragmentNavigationMethod
import com.example.collegeapp.R
import kotlinx.android.synthetic.main.fragment_confirm_register.*

class ConfirmRegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login_confrimRegister.setOnClickListener {

            FragmentNavigationMethod.navigateWithPopUp(
                action = R.id.action_confirmRegisterFragment_to_loginFragment,
                navController = findNavController(),
                popUpId = R.id.confirmRegisterFragment,
                inclusive = true
            )

        }

    }

}