package com.loyo.myapplication.recyclerview.recyclerView_listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_paging.*

class RecyclerViewListAdaoterActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging)
        val adapter = MyListAdapter()
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        val listPerson = arrayListOf<Person>()
        //无论是增加还是更新或者删除， 我们只需要使用adapter.submitList(List)方法
        //这里如果使用listPerson，第一次点击button24的时候界面不会发生改变。
        adapter.submitList(arrayListOf())
        var i=0
        button24.setOnClickListener {
            i++
            listPerson.add(Person("andy$i",21+i))
            val listPerson2= arrayListOf<Person>()
            listPerson2.addAll(listPerson)
            //注意这里submitList传入的参数必须是一个新的列表，也就是说，如果你使用的是一个已经加载了的列表，那么将不会被加载。
            adapter.submitList(listPerson2)

        }

    }
}
