package com.bottomupdrawer.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bottomupdrawer.demo.basic.BasicActivity
import com.bottomupdrawer.demo.databinding.ActivityMainBinding
import com.bottomupdrawer.demo.googleDrive.GoogleDriveActivity
import com.bottomupdrawer.demo.googleDrive.GoogleDriveFragment
import com.bottomupdrawer.demo.googlemap.GoogleMapActivity
import lib.bottomupdrawer.BasicBottomSheet

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this@MainActivity,BasicActivity::class.java))
        }

        binding.button2.setOnClickListener {
            startActivity(Intent(this@MainActivity,GoogleDriveActivity::class.java))
        }

        binding.button3.setOnClickListener {
            startActivity(Intent(this@MainActivity,GoogleMapActivity::class.java))
        }
    }
}