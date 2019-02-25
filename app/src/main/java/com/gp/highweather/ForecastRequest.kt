package com.gp.highweather

import com.google.gson.Gson
import java.net.URL

/**
 * Created by guoping on 2018/2/11.
 */
class ForecastRequest(private val zipCode: String) {
    companion object {
        val APP_ID = "d00d34b8fb6042b36244b42f23b63b46"
        val APIURL = "http://api.openweathermap.org/data/2.5/" + "forecast/daily?mode=json&units=metric&cnt=7"
        val COMPLETE_URL = "$APIURL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}