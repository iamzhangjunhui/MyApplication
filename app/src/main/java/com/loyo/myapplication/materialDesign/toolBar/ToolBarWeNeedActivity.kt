package com.loyo.myapplication.materialDesign.toolBar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_tool_bar_we_need.*

class ToolBarWeNeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_bar_we_need)
        //设置一个toolBar充当actionBar
        setSupportActionBar(toolbar2)
        //不显示标题
        supportActionBar?.setDisplayShowTitleEnabled(false)
        //显示导航图标
        toolbar2.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.view -> Toast.makeText(this, "第一页", Toast.LENGTH_SHORT).show()
            R.id.view2 -> Toast.makeText(this, "第二页", Toast.LENGTH_SHORT).show()
            R.id.view3 -> Toast.makeText(this, "第三页", Toast.LENGTH_SHORT).show()
            R.id.view4 -> Toast.makeText(this, "第四页", Toast.LENGTH_SHORT).show()
            R.id.view5 -> Toast.makeText(this, "第五页", Toast.LENGTH_SHORT).show()
            //这是导航图标的id(返回键)
            android.R.id.home -> {
                Toast.makeText(this, "返回", Toast.LENGTH_SHORT).show()
                finish()
            }


        }
        return true
    }
}
