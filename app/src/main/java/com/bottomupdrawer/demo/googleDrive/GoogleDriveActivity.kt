package com.bottomupdrawer.demo.googleDrive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bottomupdrawer.demo.databinding.ActivityGoogledriveBinding
import lib.bottomupdrawer.BasicBottomSheet

class GoogleDriveActivity : AppCompatActivity() {
    lateinit var binding : ActivityGoogledriveBinding
    lateinit var bottomSheet: BasicBottomSheet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogledriveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            bottomSheet.hidden(false)
        }

        val googleDriveFragment = GoogleDriveFragment()
        bottomSheet = BasicBottomSheet
            .Begin(this@GoogleDriveActivity)
            .hide(true)
            .addContents(googleDriveFragment)
            .hidden(true)
            .commit()
    }
}