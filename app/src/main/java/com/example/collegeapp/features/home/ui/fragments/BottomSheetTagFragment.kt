package com.example.collegeapp.features.home.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.collegeapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetTagFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet_tags, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val close = view.findViewById<ImageView>(R.id.img_close_bottomSheetTag)
        close.setOnClickListener { dismiss() }
    }

}