package com.loyo.myapplication.materialDesign.bottomNavigationViewAndViewPager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment private constructor() : Fragment() {
    companion object {
        fun instasnce(text: String): Fragment {
            val testFragment = TestFragment()
            val bundle = Bundle()
            bundle.putString("name", text)
            testFragment.arguments = bundle
            return testFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val s = requireArguments().get("name")
            textview.text = s.toString()
        }
    }
}
