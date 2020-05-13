package com.loyo.test.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.loyo.test.R
import kotlinx.android.synthetic.main.fragment_home_test.*

class TestHomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("生命周期：", "TestHomeFragment onCreateView")
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home_test, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            text_home.text = it
        })
        return root
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("生命周期：", "TestHomeFragment onDestroy")
    }
}
