package com.example.collegeapp.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.adapters.SearchPostAdapter
import com.example.collegeapp.Entities.ArticleEntity
import com.example.collegeapp.R
import com.example.collegeapp.data.searchPostLists
import com.google.android.material.chip.ChipGroup

class SearchFragment : Fragment(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chipGroup = view.findViewById<ChipGroup>(R.id.cg_searchChips_searchfragment)
        val checkedChipId = chipGroup.checkedChipId
        val checkedChipIds = chipGroup.checkedChipIds

        chipGroup.setOnCheckedChangeListener { group, checkedId -> }

        val searchPostAdapter = SearchPostAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_postssearch_searchfragment)
        recyclerView.adapter = searchPostAdapter

        searchPostAdapter.submitList(searchPostLists())


        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val data = ArrayList<ArticleEntity>()

        val adapter = SearchPostAdapter()


//        view.findViewById<Button>(R.id.btn_post_frSearch).setOnClickListener {
//            FragmentNavigationMethod.navigate(
//                action = R.id.action_searchFragment_to_childPostSearchFragment,
//                navController = findNavController()
//            )
//        }
//        view.findViewById<Button>(R.id.btn_tags_frSearch).setOnClickListener {
//            FragmentNavigationMethod.navigate(
//                action = R.id.action_searchFragment_to_childTagSearchFragment,
//                navController = findNavController()
//            )
//        }
//        view.findViewById<Button>(R.id.btn_users_frSearch).setOnClickListener {
//            FragmentNavigationMethod.navigate(
//                action = R.id.action_searchFragment_to_childUserSearchFragment2,
//                navController = findNavController()
//            )
//        }
    }
}