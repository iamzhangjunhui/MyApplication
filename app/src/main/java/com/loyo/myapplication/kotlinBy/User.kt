package com.loyo.myapplication.kotlinBy

class User(private val map: MutableMap<String, Any>) {
    //类的构造器中传的是可读写的MutableMap的话，类的属性可以是var，如果传的是只读Map,类的属性为val
    var name: String by map
    var age: Int by map
    override fun toString(): String {
        return "name: $name age：$age map:$map"
    }
}