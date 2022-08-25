package com.example.collegeapp.Home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
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

        }

        btn_search_activityMain.setOnClickListener {

        }

        btn_home_activityMain.setOnClickListener {

        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                val now = System.currentTimeMillis()
                Log.d("back", ((now - lastClick).toString()))

                if (now - lastClick < 1000L) {
                    requireActivity().onBackPressed()
                } else {
                    Log.d("back", "cant")

                    Toast.makeText(requireContext(), "از خروج مطمئنید ؟", Toast.LENGTH_SHORT).show()
                    lastClick = now
                }
                isEnabled = false
            }

        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

    }


}