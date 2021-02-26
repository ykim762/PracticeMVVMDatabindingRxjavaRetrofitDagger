package com.yeji.practiceinterview.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeji.practiceinterview.R
import com.yeji.practiceinterview.data.model.Daily
import kotlinx.android.synthetic.main.row_weather_daily_adapter.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class WeatherApdater(val mContext:Context):RecyclerView.Adapter<WeatherApdater.ViewHolder>() {

    var mList = ArrayList<Daily>()

    inner class ViewHolder(var itemview:View):RecyclerView.ViewHolder(itemview){
        fun bind(daily: Daily){

            var sdf = SimpleDateFormat("MM/dd/yyyy")
            var date = Date(daily.dt.toLong() * 1000)

            itemview.text_view_date.text = "Date: ${sdf.format(date)}"
            itemview.text_view_sunrise.text = "Sunrise: " + daily.sunrise.toString()
            itemview.text_view_sunset.text = "Sunset: " + daily.sunset.toString()
            itemview.text_view_temp.text = "Temperature: " + daily.temp.day.toString()
            itemview.text_view_feel_like.text = "Feel like: " + daily.feels_like.day.toString()
        }
    }

    fun setData(list:ArrayList<Daily>){
        mList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_weather_daily_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var weather = mList[position]
        holder.bind(weather)
    }
}