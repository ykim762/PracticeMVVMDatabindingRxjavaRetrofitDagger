package com.yeji.practiceinterview.app

import java.text.SimpleDateFormat
import java.util.*

class Helper {
    companion object{
        fun convertDate(time:Int): String {
            var sdf = SimpleDateFormat("MM/dd/yyyy")
            var date = Date(time.toLong() * 1000)
            return sdf.format(date)
        }
    }
}