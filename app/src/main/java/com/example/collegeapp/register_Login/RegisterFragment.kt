package com.example.collegeapp.register_Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.FragmentNavigationMethod
import com.example.collegeapp.R
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_register_registerFragment.setOnClickListener {

            FragmentNavigationMethod.navigateWithPopUp(
                action = R.id.action_registerFragment_to_confirmRegisterFragment,
                navController = findNavController(),
                popUpId = R.id.registerFragment,
                inclusive = true
            )
        }
    }

}