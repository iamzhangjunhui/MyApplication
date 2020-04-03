package com.loyo.myapplication.useAssets


class Group{
    lateinit var groupName:String
    lateinit var pesons:ArrayList<Person>
    override fun toString(): String {
        return "Group(groupName='$groupName', pesons=$pesons)"
    }


}