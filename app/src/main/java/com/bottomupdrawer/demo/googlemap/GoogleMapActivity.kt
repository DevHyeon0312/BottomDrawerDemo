package com.bottomupdrawer.demo.googlemap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bottomupdrawer.demo.databinding.ActivityGooglemapBinding
import lib.bottomupdrawer.BasicBottomSheet

class GoogleMapActivity : AppCompatActivity() , GoogleMapFragment.OnClickListener {
    lateinit var binding : ActivityGooglemapBinding
    lateinit var bottomSheet: BasicBottomSheet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGooglemapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val googleMapFragment = GoogleMapFragment()

        bottomSheet = BasicBottomSheet
            .Begin(this@GoogleMapActivity)
            .hide(false)
            .peekHeight(100)
            .addContents(googleMapFragment)
            .commit()
    }

    override fun onClicked() {
        bottomSheet.expend(false)
    }
}