package com.gp.highweather.domain

import com.gp.highweather.ForecastDataMapper
import com.gp.highweather.ForecastRequest

/**
 * Created by guoping on 2018/2/22.
 */
interface Command<T> {
    fun execute(): T
}

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}