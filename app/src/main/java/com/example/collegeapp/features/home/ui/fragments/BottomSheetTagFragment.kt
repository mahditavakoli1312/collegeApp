package com.example.collegeapp.features.home.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentBottomSheetTagsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetTagFragment : BottomSheetDialogFragment() {

    lateinit var bindin: FragmentBottomSheetTagsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindin = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_bottom_sheet_tags,
            container,
            false
        )
        return bindin.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindin.apply {
            imgCloseBottomSheetTag.setOnClickListener { dismiss() }
        }
    }

}