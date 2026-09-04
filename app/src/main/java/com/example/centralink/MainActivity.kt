// ST10452404 OPSC6312 ICE TASK 2
package com.example.centralink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mapbox.common.MapboxOptions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize Mapbox Options with the public access token
        MapboxOptions.accessToken = getString(R.string.mapbox_access_token)

        setContentView(R.layout.activity_main)

        // Set up the Bottom Navigation with NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setupWithNavController(navController)

        // ICE Task 2: Initialize and test SQLite database
        DatabaseManager.manageUserData(this)
    }
}
