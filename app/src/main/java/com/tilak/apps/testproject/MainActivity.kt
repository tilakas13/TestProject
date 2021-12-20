package com.tilak.apps.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.tilak.apps.testproject.ui.dashboard.DashboardFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentManger = supportFragmentManager
        val ft: FragmentTransaction = fragmentManger.beginTransaction()
        ft.add(R.id.fl_fragment_container, DashboardFragment())
        ft.commit()
    }
}