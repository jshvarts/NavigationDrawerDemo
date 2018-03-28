package com.jshvarts.navigationdrawerdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_navigation_drawer.*

class NavigationDrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        val websites = resources.getStringArray(R.array.websites)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, websites)
        websitesListView.adapter = adapter
    }
}
