package com.example.mobiledevelopmentcourselabapp

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mobiledevelopmentcourselabapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val navView: BottomNavigationView? = binding?.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val mainTabsSet =  setOf(
            R.id.navigation_article,
            R.id.navigation_list,
            R.id.navigation_third
        )
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding?.navView?.isVisible = destination.id in mainTabsSet
        }
        val appBarConfiguration = AppBarConfiguration(mainTabsSet)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView?.setupWithNavController(navController)

        Log.d("Lifecycles", "${this::class.simpleName} - onCreate")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return false
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycles", "${this::class.simpleName} - onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycles", "${this::class.simpleName} - onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycles", "${this::class.simpleName} - onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycles", "${this::class.simpleName} - onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycles", "${this::class.simpleName} - onDestroy")

    }
}