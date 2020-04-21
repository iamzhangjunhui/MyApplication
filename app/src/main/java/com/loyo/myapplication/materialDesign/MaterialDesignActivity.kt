package com.loyo.myapplication.materialDesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.loyo.myapplication.R
import com.loyo.myapplication.databinding.ActivityMaterialDesignBindingImpl

class MaterialDesignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMaterialDesignBindingImpl>(
            this,
            R.layout.activity_material_design
        ).also {
            it.click =
                MaterialDesignActivityClick(
                    this
                )
        }
    }
}
