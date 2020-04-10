package com.loyo.myapplication.kotlinT

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.loyo.myapplication.R

class KotlinTActivity : AppCompatActivity() {
    /**
     * 1.泛型函数
     * 2.泛型参数
     * 3.泛型类/接口
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_t)
        //1.
        Log.i("KotlinTActivity", tFun(Byte.MAX_VALUE).toString())//返回0.0
        Log.i("KotlinTActivity", tFun(1f).toString())//返回1.0

        Log.i(
            "KotlinTActivity", tMoreThanOne(
                Byte.MAX_VALUE, 100f
            ).toString()
        )
        //2.
        val list = arrayListOf<Float>(1f, 2f, 3f)
        Log.i("KotlinTActivity", list.firstElement.toString())

        //3.
        Log.i("KotlinTActivity", User(1).toString())

    }

    //1.泛型函数
    //<T>声明该方法是泛型方法
    //判断传入的是否是Float,是就直接返回，不是就返回0.0
    private fun <T> tFun(t: T): Float {
        return if( t is Float) t else 0f
    }

    //多类型参数
    // <T : Number>中的：Number是泛型约束，要求为Number或Number的子类型；如果没有任何泛型约束就相当于是<T:Any?>表示为任何可空或不可空类型，如果限制为不可空类型则添加泛型约束<T:Any>
    //两个数相乘返回Long类型的结果
    fun <T : Number, R : Number> tMoreThanOne(t: T, r: R): Long {
        return (t.toFloat() * r.toFloat()).toLong()
    }

    //2.泛型属性
    //泛型属性必须是扩展属性（为已知的类扩展一个属性）
    var <T> ArrayList<T>.firstElement: T
        get() {
            return this[0]
        }
        set(value) {
            this.add(value)
        }

    //3.泛型类/接口
    class User<T>(var value: T) {
        override fun toString(): String {
            return when (value) {
                is Float -> "我是一个Float"
                else -> "我不是Float"
            }
        }
    }
}

