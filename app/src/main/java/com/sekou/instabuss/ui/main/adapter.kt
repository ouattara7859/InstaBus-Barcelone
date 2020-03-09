package com.example.instabus.ui.main
/*
import Nearstations
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

import com.example.instabus.R

class adapter (private val context: Context,
               private val nearstations: List<Nearstations>?, val itemListener: StationsItemListener):
    RecyclerView.Adapter<adapter.ViewHolder>(){

    interface StationsItemListener {
        fun onStationsItemClick(nearstations: Nearstations)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val stationName: TextView? = itemView.findViewById(R.id.nameStation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_list_station, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nearstation = nearstations?.get(position)

        with(holder) {
            stationName?.tag = position
            stationName?.setOnClickListener {
                itemListener.onStationsItemClick(nearstation!!)
            }
            stationName?.text = nearstation?.street_name
            //Glide.with(context)
                //.load(nearstation?.street_name)
        }
    }

    override fun getItemCount() = nearstations?.size?:0



}
*/