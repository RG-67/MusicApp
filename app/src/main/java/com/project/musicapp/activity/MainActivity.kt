package com.project.musicapp.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView
import com.project.musicapp.R
import com.project.musicapp.databinding.ActivityMainBinding
import com.project.musicapp.fragment.mainFragment.HomeFragment
import com.project.musicapp.fragment.mainFragment.MyMusicFragment
import com.project.musicapp.fragment.mainFragment.PremiumFragment
import com.project.musicapp.fragment.mainFragment.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeFragment = HomeFragment()
    private val myMusicFragment = MyMusicFragment()
    private val searchFragment = SearchFragment()
    private val premiumFragment = PremiumFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment).commit()
        binding.bottomNav.setOnItemSelectedListener(object :
            NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                when (p0.itemId) {
                    R.id.home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, homeFragment).commit()
                        return true
                    }

                    R.id.search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, searchFragment).commit()
                        return true
                    }

                    R.id.myMusic -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, myMusicFragment).commit()
                        return true
                    }

                    R.id.premium -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, premiumFragment).commit()
                        return true
                    }

                    else -> return false
                }
            }

        })

    }
}