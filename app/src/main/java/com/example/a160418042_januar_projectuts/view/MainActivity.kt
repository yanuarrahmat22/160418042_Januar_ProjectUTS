    package com.example.a160418042_januar_projectuts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.a160418042_januar_projectuts.R
import kotlinx.android.synthetic.main.activity_main.*

    class MainActivity : AppCompatActivity() {

        private lateinit var navController: NavController

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            navController = Navigation.findNavController(this, R.id.fragmentHost)

            NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
            NavigationUI.setupWithNavController(navView, navController)

            bottomNav.setupWithNavController(navController)

        }


        override fun onSupportNavigateUp(): Boolean {
            return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
        }

    }