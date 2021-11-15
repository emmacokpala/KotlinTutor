package com.example.kotlintutor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlintutor.R
import com.example.kotlintutor.adapter.ClickListener
import com.example.kotlintutor.adapter.NavigationRvAdapter
import com.example.kotlintutor.adapter.RecyclerTouchListener
import com.example.kotlintutor.databinding.ActivityHomeScreenBinding
import com.example.kotlintutor.databinding.ActivityMainBinding
import com.example.kotlintutor.model.NavigationItemModel

class AuthenticationActivity : AppCompatActivity() {

    private lateinit var navCon : NavController
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navCon = navHost.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navCon.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {

    }
}
