package mopel.io.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.util.*

class MainActivity : AppCompatActivity() {
    private val items = ArrayList<Forecast>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forcastList: RecyclerView = find(R.id.forecast_list)
        forcastList.layoutManager = LinearLayoutManager(this)
        forcastList.adapter = ForecaseAdapter(items) {
            Log.i("adapter", "clicked")
            toast("${it.temp} clicked")
        }

        async {
            ForecastRequst(url = "www.baidu.com").run()
            uiThread {
                toast("ForecastRequst Performed")
            }
        }
    }
}
