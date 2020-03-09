package com.example.instabus.ui.main

import Nearstations
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import com.example.instabus.data.Station
import com.sekou.instabuss.R


class ListStationAdapter ( private val stations: List<Nearstations>,
                           private val context: Context?=null
                                                  ) : BaseAdapter(){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val rowView = inflater.inflate(R.layout.fragment_text, parent, false)
        val titleTextView = rowView.findViewById(R.id.nameText) as TextView
        val station = getItem(position) as Nearstations
        titleTextView.text = station.street_name

        return rowView
    }

    override fun getItem(position: Int): Any {
        return stations[position]

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
       return stations.size
    }

}
