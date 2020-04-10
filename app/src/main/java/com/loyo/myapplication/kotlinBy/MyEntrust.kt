package com.loyo.myapplication.kotlinBy

import java.lang.NullPointerException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MyEntrust<T> :ReadWriteProperty<Any?,T>{
    var value:T?=null
    //如果value不为null,返回value,否则抛异常
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value?:throw NullPointerException("还没有进行赋值")
    }
    //如果value还没有赋值就进行赋值
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if (value!=null&&this.value==null){
            this.value=value
        }
    }
}