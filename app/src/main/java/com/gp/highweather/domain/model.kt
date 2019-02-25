package com.gp.highweather.domain

/**
 * Created by guoping on 2018/2/22.
 */
data class ForecastList(val city: String, val country: String, val dailyForecast:List<Forecast>){
    operator fun get(position: Int): Forecast = dailyForecast[position]
    fun size(): Int = dailyForecast.size
}

//data class Forecast(val date: String, val description: String, val high: Int, val low: Int)
data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)