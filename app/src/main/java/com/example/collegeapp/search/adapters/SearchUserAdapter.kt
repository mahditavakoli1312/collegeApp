package com.example.collegeapp.search.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.search.entities.UserSearchEntity

class SearchUserAdapter :
    ListAdapter<UserSearchEntity, SearchUserAdapter.SearchUserHolder>(SearchUserDiffCallback) {

    class SearchUserHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val textUser: TextView =
            itemView.findViewById(R.id.tv_username_item_userSearchViewHolder)

        fun bind(userSearchEntity: UserSearchEntity) {

            textUser.text = userSearchEntity.nameUser

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchUserHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_serarchviewholder, parent, false)
        return SearchUserHolder(view)
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