package com.bottomupdrawer.demo.basic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bottomupdrawer.demo.databinding.ActivityBasicBinding
import com.bottomupdrawer.demo.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import lib.bottomupdrawer.BasicBottomSheet

class BasicActivity : AppCompatActivity() {
    lateinit var binding : ActivityBasicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /** Basic Sample */
        val titleFragment = TitleFragment()
        val bodyFragment = BodyFragment()

        val callback = (object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {}
                    BottomSheetBehavior.STATE_EXPANDED -> {}
                    BottomSheetBehavior.STATE_DRAGGING -> {}
                    BottomSheetBehavior.STATE_SETTLING -> {}
                    BottomSheetBehavior.STATE_HIDDEN -> {}
                    else -> {}
                }
            }
        })

        BasicBottomSheet
                .Begin(this@BasicActivity)
                .hide(false)
                .peekHeight(60)
                .addTitle(titleFragment)
                .addContents(bodyFragment)
                .addCallBack(callback)
                .commit()
    }
}