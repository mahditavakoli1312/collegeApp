package com.example.collegeapp.register_Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.FragmentNavigationMethod
import com.example.collegeapp.R
import kotlinx.android.synthetic.main.fragment_choose_login.*


class ChooseLoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_register_chooseLoginActivity.setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_chooseLoginFragment_to_registerFragment,
                navController = findNavController(),
            )
        }

        btn_login_chooseLoginActivity.setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_chooseLoginFragment_to_loginFragment,
                navController = findNavController(),
            )
        }
    }


}