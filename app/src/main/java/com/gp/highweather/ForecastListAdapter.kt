package com.gp.highweather

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gp.highweather.domain.ForecastList
import com.gp.highweather.domain.Forecast
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by guoping on 2018/2/11.
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit):
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder!!.textView.text = items[position]
//        with(weekForecast[position]) {
//            holder.textView.text = "$date - $description - $high/$low"
//        }
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

//    class TextViewHolder(val textView:TextView):RecyclerView.ViewHolder(textView)

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    interface OnItemClickListener {//Interface中包含单个函数可以被替代为一个函数
        operator fun invoke(forecast: Forecast)
    }
}