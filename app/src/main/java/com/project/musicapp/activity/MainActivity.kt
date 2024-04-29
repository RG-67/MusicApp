package com.project.musicapp.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView
import com.project.musicapp.R
import com.project.musicapp.databinding.ActivityMainBinding
import com.project.musicapp.fragment.HomeFragment
import com.project.musicapp.fragment.MyMusicFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeFragment = HomeFragment()
    private val myMusicFragment = MyMusicFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        enableEdgeToEdge()
        setContentView(binding.root)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

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

                    R.id.myMusic -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, myMusicFragment).commit()
                        return true
                    }

                    R.id.tunes -> {
                        Toast.makeText(this@MainActivity, "Tunes selected..", Toast.LENGTH_SHORT)
                            .show()
                        return true
                    }

                    R.id.premium -> {
                        Toast.makeText(this@MainActivity, "Premium selected..", Toast.LENGTH_SHORT)
                            .show()
                        return true
                    }

                    else -> return false
                }
            }

        })
    }
}