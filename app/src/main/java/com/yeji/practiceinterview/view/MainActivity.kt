package com.yeji.practiceinterview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeji.practiceinterview.R
import com.yeji.practiceinterview.data.model.WeatherResponse
import com.yeji.practiceinterview.databinding.ActivityMainBinding
import com.yeji.practiceinterview.viewmodel.WeatherViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var viewmodel: WeatherViewModel
    lateinit var mAdapter:WeatherApdater
    lateinit var mBinding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
    }

    private fun init() {

        mAdapter = WeatherApdater(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = mAdapter

        viewmodel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        viewmodel.curLocWeather(33.441792, -94.037689).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer)

    }

    private val observer = object : DisposableSingleObserver<WeatherResponse>() {
        override fun onSuccess(t: WeatherResponse) {
//            Log.d("aaa", t.toString())

//            var sdf = SimpleDateFormat("MM/dd/yyyy")
//            var date = Date(t.current.dt.toLong() * 1000)
//
//            text_view_date.text = "Date: ${sdf.format(date)}"

            mBinding.weather = t

//            text_view_lat.text = "Latitude: " + t.lat.toString()
//            text_view_lon.text = "Longitude: " + t.lon.toString()
//            text_view_timezone.text = "TimeZone: " + t.timezone.toString()
//
//            text_view_temp.text = "Temperature: " + t.current.temp.toString()
//            text_view_feel_like.text = "Feel like: " + t.current.feels_like.toString()
//            text_view_pressure.text = "Pressure: " + t.current.pressure.toString()
//            text_view_humidity.text = "Humidity: " + t.current.humidity.toString()

            Log.d("aaa", t.daily.toString())
            mAdapter.setData(t.daily)
        }

        override fun onError(e: Throwable) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
        }

    }

}