package com.tilak.apps.testproject.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.tilak.apps.testproject.databinding.FragmentUserBinding

class UserFragment : Fragment() {
    private val userAdapter = UserAdapter()
    lateinit var binding: FragmentUserBinding
    private val viewModel: UserViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchUserList()

        binding.rlUserList.apply {
            adapter = userAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
        viewModel.getUserList().observeForever { it ->
            userAdapter.UpdateUserList(it)
            userAdapter.notifyDataSetChanged()
        }
    }


}