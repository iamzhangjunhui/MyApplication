package com.loyo.myapplication.navigation.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.loyo.myapplication.R
import com.loyo.myapplication.navigation.TestResultActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        text.setOnClickListener {
            val actionHomeFragmentToDetailFragment2 =
                HomeFragmentDirections.actionHomeFragmentToDetailFragment2("kaylee")
            Navigation.findNavController(it).navigate(actionHomeFragmentToDetailFragment2)
        }
        button23.setOnClickListener {
            startActivityForResult(Intent(activity, TestResultActivity::class.java), 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 100){
            if (data != null) {
                Toast.makeText(activity,data.getStringExtra("name"),Toast.LENGTH_SHORT).show()
            }
        }
    }
}
