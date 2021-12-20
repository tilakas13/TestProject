package com.tilak.apps.testproject.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.tilak.apps.testproject.R
import com.tilak.apps.testproject.databinding.FragmentDashboardBinding
import com.tilak.apps.testproject.ui.customer.CustomerFragment
import com.tilak.apps.testproject.ui.user.UserFragment

class DashboardFragment : Fragment() {

    lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCustomer1.setOnClickListener {
            addFragment(CustomerFragment())
        }

        binding.btnUsers.setOnClickListener {
            addFragment(UserFragment())
        }
    }

    private fun addFragment(fragment: Fragment) {
        val fragmentManger = requireActivity().supportFragmentManager
        val ft: FragmentTransaction = fragmentManger.beginTransaction()
        ft.add(R.id.fl_fragment_container, fragment).addToBackStack(null)
        ft.commit()
    }


}