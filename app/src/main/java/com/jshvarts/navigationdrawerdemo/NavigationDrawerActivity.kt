package com.jshvarts.navigationdrawerdemo

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_navigation_drawer.*


class NavigationDrawerActivity : AppCompatActivity() {

    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        drawerToggle = object : ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_closed) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                toolbar.title = getString(R.string.drawer_open_title)
            }
            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerOpened(drawerView)
                toolbar.title = getString(R.string.app_name)
            }
        }
        // open/close th drawer (with animation)
        drawerLayout.addDrawerListener(drawerToggle)

        navigationView.setNavigationItemSelectedListener({ menuItem ->
                    // set item as selected to persist highlight
                    menuItem.isChecked = true
                    // close drawer when item is tapped
                    drawerLayout.closeDrawers()

                    // Add code here to update the UI based on the item selected
                    // For example, swap UI fragments here
                    Toast.makeText(this, menuItem.title, Toast.LENGTH_SHORT).show()

                    true
                })
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                with(drawerLayout) {
                    when (isDrawerOpen(GravityCompat.START)) {
                        true -> closeDrawer(GravityCompat.START)
                        else -> openDrawer(GravityCompat.START)
                    }
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
  }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
