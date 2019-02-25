package com.gp.highweather

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.gp.highweather.domain.RequestForecastCommand

//Activities或者Fragments的Android Extensions以kotlin.android.synthetic开头，针对include布局，我们也需要增加手工的import
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_main_include.*
//Views的Android Extensions  kotlinx.android.synthetic.view_item.view.*
//view.textView.text = "Hello"
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var forecastList:RecyclerView = findViewById(R.id.forecastList)
        forecastList.layoutManager = LinearLayoutManager(this)

        message.text
//        image.setImageBitmap()

        async() {
//            Request(url).run()
//            uiThread { toast("javaClass.simpleName,Request performed") }

            val result = RequestForecastCommand("94043").execute()
            uiThread{
                forecastList.adapter = ForecastListAdapter(result) {toast(it.date)}
            }
        }

        supportsLollipop {
            window.setStatusBarColor(Color.BLACK)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

}