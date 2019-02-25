package com.gp.highweather

import android.content.Context
import android.os.Build
import android.widget.TextView
import android.widget.Toast
import java.util.*

/**
 * Created by guoping on 2018/2/11.
 */
fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

var TextView.text: CharSequence
    get() = getText()
    set(v) = setText(v)


inline fun supportsLollipop(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        code()
    }
}

data class Forecast1(val date: Date, val temperature: Float, val details: String)
//val f1 = Forecast1(Date(), 27.5f, "Shiny day")
//val f2 = f1.copy(temperature = 30f)

fun main(args: Array<String>) {
    val f1 = Forecast1(Date(), 27.5f, "Shiny day")
    //复制一个数据类
    val f2 = f1.copy(temperature = 30f)


    //多声明，映射对象的每一个属性到一个变量中
    val (date, temperature, details) = f1

//    val date = f1.component1()
//    val temperature = f1.component2()
//    val details = f1.component3()
}


//1.多声明
//2.inline 内联函数，noinline，非内联函数