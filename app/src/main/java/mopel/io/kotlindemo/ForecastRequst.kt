package mopel.io.kotlindemo

import android.util.Log
import com.google.gson.Gson
import java.net.URL


/**
 * Author: mopel
 * Date : 2017/5/22
 */
public class ForecastRequst(val zipcode:String){
    companion object{
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
        private val gson = Gson()
    }

    public fun run(){
        val forecastJsonStr = URL(zipcode).readText()
        Log.d(javaClass.simpleName,forecastJsonStr)
    }

    fun execute():ForecastResult{
        val forecastJsonStr = URL(COMPLETE_URL+zipcode).readText()
        return gson.fromJson(forecastJsonStr,ForecastResult::class.java)
    }
}

data class ForecastResult(val city: City, val list: List<Forecast>)
data class City(val id: Long, val name: String, val coord: Coordinates,
                val country: String, val population: Int)
data class Coordinates(val lon: Float, val lat: Float)
data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float,
                    val humidity: Int, val weather: List<Weather>,
                    val speed: Float, val deg: Int, val clouds: Int,
                    val rain: Float)
data class Temperature(val day: Float, val min: Float, val max: Float,
                       val night: Float, val eve: Float, val morn: Float)
data class Weather(val id: Long, val main: String, val description: String,
                   val icon: String)