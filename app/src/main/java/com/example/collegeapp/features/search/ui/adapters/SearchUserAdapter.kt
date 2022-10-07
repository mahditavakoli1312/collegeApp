package com.example.collegeapp.features.search.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.databinding.ItemUserSerarchviewholderBinding
import com.example.collegeapp.features.search.ui.model.SearchUserView

class SearchUserAdapter(
    private val onItemClick: (userId: Int, userName: String) -> Unit
) :
    ListAdapter<SearchUserView, SearchUserAdapter.SearchUserHolder>(SearchUserDiffCallback) {

    class SearchUserHolder(val itemBinding: ItemUserSerarchviewholderBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(searchUserView: SearchUserView) {
            itemBinding.userSearch = searchUserView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchUserHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserSerarchviewholderBinding.inflate(inflater, parent, false)
        return SearchUserHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchUserHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
        holder.itemBinding.root.setOnClickListener { onItemClick(user.id, user.nameUser) }
    }

}

object SearchUserDiffCallback : DiffUtil.ItemCallback<SearchUserView>() {
    override fun areItemsTheSame(oldItem: SearchUserView, newItem: SearchUserView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SearchUserView, newItem: SearchUserView): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}