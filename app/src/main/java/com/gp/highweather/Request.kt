package com.gp.highweather

import android.util.Log
import java.net.URL

/**
 * Created by guoping on 2018/2/22.
 */
class Request(val url: String) {
    fun run() {
        var forecastJsonStr = URL(url).readText()
        Log.i("maingp", forecastJsonStr)
    }
}
