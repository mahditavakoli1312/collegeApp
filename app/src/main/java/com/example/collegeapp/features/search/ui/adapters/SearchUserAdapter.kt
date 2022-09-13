package com.example.collegeapp.features.search.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.databinding.ItemUserSerarchviewholderBinding
import com.example.collegeapp.features.search.data.entities.UserSearchEntity

class SearchUserAdapter :
    ListAdapter<UserSearchEntity, SearchUserAdapter.SearchUserHolder>(SearchUserDiffCallback) {

    class SearchUserHolder(private val itemBinding: ItemUserSerarchviewholderBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(userSearchEntity: UserSearchEntity) {
            itemBinding.userSearch = userSearchEntity
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

    }


}


object SearchUserDiffCallback : DiffUtil.ItemCallback<UserSearchEntity>() {
    override fun areItemsTheSame(oldItem: UserSearchEntity, newItem: UserSearchEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: UserSearchEntity, newItem: UserSearchEntity): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}