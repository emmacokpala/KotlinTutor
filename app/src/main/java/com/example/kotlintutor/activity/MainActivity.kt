package com.example.kotlintutor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.view.GravityCompat
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
import com.example.kotlintutor.model.NavigationItemModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var adapter: NavigationRvAdapter
    private lateinit var items: ArrayList<NavigationItemModel>

    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)

        items = arrayListOf(
            NavigationItemModel(getString(R.string.profile)),
            NavigationItemModel (getString(R.string.topics))
        )

        binding.menuImage.setOnClickListener { binding.drawerLayout.openDrawer(GravityCompat.START) }

        binding.navigationRv.layoutManager = LinearLayoutManager(this)
        binding.navigationRv.setHasFixedSize(true)

        updateAdapter()

        binding.navigationRv.addOnItemTouchListener(
            RecyclerTouchListener(
                this,
                object : ClickListener {
                    override fun onClick(view: View, position: Int) {
                        when (position) {
                            0 -> {
                                navController.navigate(R.id.profile)
                            }
                            1 -> {
                                navController.navigate(R.id.topics)
                            }
                        }
                        Handler(Looper.getMainLooper()).postDelayed({
                            binding.drawerLayout.closeDrawer(GravityCompat.START)
                        }, 400)
                    }
                }
            )
        )

        binding.signOutBtn.setOnClickListener {
            onDestroy()
        }
    }

    private fun updateAdapter() {
        adapter = NavigationRvAdapter(items, 0)
        binding.navigationRv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
