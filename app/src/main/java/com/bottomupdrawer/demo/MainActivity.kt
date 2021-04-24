package com.bottomupdrawer.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import lib.bottomupdrawer.BasicBottomSheet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
                .Begin(activity = this@MainActivity)
                .hide(false)
                .peekHeight(60)
                .addTitle(titleFragment)
                .addContents(bodyFragment)
                .addCallBack(callback)
                .commit()
    }
}