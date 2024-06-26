package com.alexdevs.menu

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout =
            findViewById(R.id.drawerLayout)
        val navView: NavigationView =
            findViewById(R.id.nav_view)
        toggle = ActionBarDrawerToggle(
            this, drawerLayout,
            R.string.open, R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> startActivity(
                    Intent(
                        this,
                        MainActivity::class.java
                    )
                )

                R.id.nav_message -> startActivity(
                    Intent(
                        this,
                        MainActivity2::class.java
                    )
                )

                R.id.nav_encuesta -> startActivity(
                    Intent(
                        this,
                        MenuEncuesta::class.java
                    )
                )

                R.id.nav_sync ->
                    Toast.makeText(
                        applicationContext, "Clicked Sync",
                        Toast.LENGTH_SHORT
                    ).show()

                R.id.nav_trash ->
                    Toast.makeText(
                        applicationContext, "Clicked Trash",
                        Toast.LENGTH_SHORT
                    ).show()

                R.id.nav_setting ->
                    Toast.makeText(
                        applicationContext, "Clicked Setting",
                        Toast.LENGTH_SHORT
                    ).show()

                R.id.nav_login ->
                    Toast.makeText(
                        applicationContext, "Clicked Login",
                        Toast.LENGTH_SHORT
                    ).show()

                R.id.nav_share ->
                    Toast.makeText(
                        applicationContext, "Clicked Share",
                        Toast.LENGTH_SHORT
                    ).show()

                R.id.nav_rate_us ->
                    Toast.makeText(
                        applicationContext, "Clicked Rate Us",
                        Toast.LENGTH_SHORT
                    ).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
