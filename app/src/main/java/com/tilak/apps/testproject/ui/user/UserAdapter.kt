package com.tilak.apps.testproject.ui.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tilak.apps.testproject.R
import com.tilak.apps.testproject.model.UserModel

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var listUsers = mutableListOf<UserModel>()

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title: TextView = view.findViewById(R.id.tv_user_name)
        var description: TextView = view.findViewById(R.id.tv_user_description)

        fun setData(userModel: UserModel) {
            title.text = userModel.name
            description.text = userModel.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.setData(listUsers[position])
    }

    override fun getItemCount(): Int {
        return listUsers.size
    }

    fun UpdateUserList(list: List<UserModel>) {
        this.listUsers.addAll(list)
    }


}