package com.example.shoestore_starter.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.ActivityMainBinding
import com.example.shoestore_starter.ui.fragments.F_Login
import com.example.shoestore_starter.ui.fragments.F_LoginDirections

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
private lateinit var navController: NavController
private lateinit var config: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setSupportActionBar(binding.toolbar)

        navController = binding.myNavHostFragment.getFragment<NavHostFragment>().navController
        NavigationUI.setupActionBarWithNavController(this, navController)
//        config = AppBarConfiguration(navController.graph)

//        setSupportActionBar(binding.toolbar)

//        NavigationUI.setupWithNavController(binding.toolbar, navController)
//        binding.toolbar.setupWithNavController(navController, config) // soon
//        setupActionBarWithNavController(navController, config)

        /*// Add menu items without overriding methods in the Activity
        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.main_mainu, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
//                navController.popBackStack(R.id.f_Welcome, false)
                NavigationUI.onNavDestinationSelected(menuItem, binding.myNavHostFragment.findNavController())
//                navController.navigate("F_Login")
//                navController.popBackStack()

//                navController.popBackStack(R.id.f_Login, false)
                return true
            }
        })*/
    }

    // when the upButton clicked
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }


}



/*

//        Timber.plant(Timber.DebugTree())

super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
 */

/*

        <com.google.android.material.appbar.AppBarLayout
            android:layout_height="wrap_content"
            android:layout_width="match_parent"
            android:theme="@style/AppTheme.AppBarOverlay">

            <androidx.appcompat.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                android:background="?attr/colorPrimary"
                app:popupTheme="@style/AppTheme.PopupOverlay" />

        </com.google.android.material.appbar.AppBarLayout>
*/