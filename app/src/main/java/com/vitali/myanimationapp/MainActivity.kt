package com.vitali.myanimationapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.vitali.myanimationapp.vectordrawable.MainVectorDrawableActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId)
        {
            R.id.action_settings -> true

            R.id.action_fab -> toggleFab(item)

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun toggleFab(item: MenuItem): Boolean
    {
        if(fab.isOrWillBeShown)
        {
            item.title = getString(R.string.show_fab)
            fab.hide()
        }else
        {
            item.title = getString(R.string.hide_fab)
            fab.show()
        }

        return true
    }


    //-----------------------------------------------------------------------------
    // NavigationView.OnNavigationItemSelectedListener - implementation
    //-----------------------------------------------------------------------------
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var intent:Intent? = null

        when (item.itemId) {
            R.id.vector_drawable_animation -> {
                intent = Intent(this, MainVectorDrawableActivity::class.java)
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            /*R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }*/
        }

        intent?.let{
            startActivity(it)
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
