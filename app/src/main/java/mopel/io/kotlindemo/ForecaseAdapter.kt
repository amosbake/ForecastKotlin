package mopel.io.kotlindemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * Author: mopel
 * Date : 2017/5/21
 */
class ForecaseAdapter(val items:List<Forecast>,val listener:(Forecast) -> Unit):
        RecyclerView.Adapter<ForecaseAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
      return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.view_forecast,parent,false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
      holder?.bind(items.get(position),listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       val contentView = itemView.findViewById(R.id.forecast_content) as TextView
        fun bind(forecast: Forecast,listener: (Forecast) -> Unit)= with(itemView){
            contentView.text = forecast.toString()
            contentView.setOnClickListener {
                listener(forecast)
            }
        }
    }
}