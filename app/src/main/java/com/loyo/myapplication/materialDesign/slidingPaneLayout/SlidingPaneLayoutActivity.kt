package com.loyo.myapplication.materialDesign.slidingPaneLayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_sliding_pane_layout.*

class SlidingPaneLayoutActivity : AppCompatActivity() {
val TAG="SlidingPaneLayout"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding_pane_layout)
        slide.setPanelSlideListener(object: SlidingPaneLayout.PanelSlideListener{
            override fun onPanelSlide(panel: View, slideOffset: Float) {
                Log.i(TAG,"onPanelSlide")
            }

            override fun onPanelClosed(panel: View) {
                Log.i(TAG,"onPanelClosed")
            }

            override fun onPanelOpened(panel: View) {
                Log.i(TAG,"onPanelOpened")

                finish()
            }

        })

    }
}
