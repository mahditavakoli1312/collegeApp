package com.example.collegeapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.FragmentNavigationMethod
import com.example.collegeapp.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        private var lastClick = 0L
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_profile_activityMain.setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_mainFragment_to_profileFragment,
                navController = findNavController()
            )
        }

        btn_search_activityMain.setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_mainFragment_to_searchFragment,
                navController = findNavController()
            )
        }

        btn_home_activityMain.setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_mainFragment_to_homeFragment,
                navController = findNavController()
            )
        }


        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                val now = System.currentTimeMillis()
                if (now - lastClick < 1000L) {
                    findNavController().popBackStack()
                } else {
                    Toast.makeText(requireContext(), "از خروج مطمئنید ؟", Toast.LENGTH_SHORT).show()
                    lastClick = now
                }
                isEnabled = false
            }

        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

    }


}