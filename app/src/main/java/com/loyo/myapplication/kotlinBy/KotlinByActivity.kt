package com.loyo.myapplication.kotlinBy

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.loyo.myapplication.R
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty

class KotlinByActivity : AppCompatActivity() {
    /***
     * 1.延迟加载 lazy
     * 2.可观察属性 Delegates.observable
     * 3.满足条件才赋值的可观察属性 Delegates.vetoable
     * 4.Not Null
     * 5.将多个属性保存在一个map内
     * 6.自定义委托
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_by)
        //1.延迟加载 里面传一个lamnda表达式
        //注意var属性不能使用延迟加载，应为lazy中没有setValue方法
        //lazy是线程安全的
        val s: String by lazy { "kaylee" }


        //2.可观察属性 第一个参数是初始化值，第二个是属性值变化事件的响应器(handler).这种形式的委托，采用了观察者模式，其会检测可观察属性的变化，当被观察属性的setter()方法被调用的时候，响应器(handler)都会被调用(在属性赋值处理完成之后)并自动执行执行的lambda表达式，同时响应器会收到三个参数：被赋值的属性, 赋值前的旧属性值, 以及赋值后的新属性值。
        var name: String by Delegates.observable("kaylee") { kProperty, oldName, newName ->
            Log.i(
                "KotlinByActivity",
                "kProperty:${kProperty.name} oldName:$oldName newName:$newName"
            )
        }
        //打印日志 KotlinByActivity: kProperty:name oldName:kaylee newName:andy
        name = "andy"

        //3.Vetoable 可观察属性(Observable)的一个特例，不同的是在响应器指定的自动执行执行的lambda表达式中在保存新值之前做一些条件判断，来决定是否将新值保存。
        var age: Int by Delegates.vetoable(20) { property, oldValue, newValue ->
            Log.i(
                "KotlinByActivity",
                "kProperty:${property.name} oldName:$oldValue newName:$newValue"
            )
            newValue > 19
        }
        //18不大于19，不会赋值给age
        age = 18
        Log.i("KotlinByActivity", "age:$age")
        //21大于19，赋值给age
        age = 21
        Log.i("KotlinByActivity", "age:$age")

        //4.Not Null委托会含有一个可null的变量并会在我们设置这个属性的时候分配一个真实的值。如果这个值在被获取之前没有被分配，它就会抛出一个异常。
        var no: String by Delegates.notNull()
        //在没有赋值前进行调用抛异常
//        Log.i("KotlinByActivity", "no:$no")


        //5.将多个属性保存在一个map内 在Kotlin中，存在这么一种委托方式，类的构造器接受一个map实例作为参数，将map实例本身作为属性的委托，属性的名称与map中的key是一致的，也就是意味着我们可以很简单的从一个动态地map中创建一个对象实例。
        val mutableMap = mutableMapOf("name" to "kaylee", "age" to 18)
        val user = User(mutableMap)
        //修改mutableMap,user中的属性值会跟着变化
        mutableMap["name"] = "andy"
        mutableMap["sex"] = "男"
        user.age = 32
        Log.i("KotlinByActivity", "user:${user}")

        //6.自定义委托
        //Delegates的扩展函数
        fun <T : Any> Delegates.onlySetOneTime(): ReadWriteProperty<Any?, T> = MyEntrust()
        var myEntrust: String by Delegates.onlySetOneTime()
        myEntrust = "string"//第一次赋值成功
        myEntrust="String2"//第二次再赋值发现已经赋值了就不会赋值了，还是string
        Log.i("KotlinByActivity", myEntrust)



    }
}

