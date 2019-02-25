package com.gp.highweather

import android.app.Application
import kotlin.properties.Delegates

/**
 * Created by guoping on 2018/3/27.
 */
class MyApp : Application() {

    companion object {
        var instance : MyApp by Delegates.notNull()
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}