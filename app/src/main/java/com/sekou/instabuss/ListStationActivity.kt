package com.example.instabus


import Json4Kotlin_Base
import Nearstations
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.instabus.ui.main.ListStationAdapter
import com.example.instabus.ui.main.PageViewModel
import com.example.instabus.ui.main.StationListViewModel



import com.google.gson.Gson
import com.sekou.instabuss.R


class ListStationActivity : Fragment () {

    companion object {
        fun newInstance() = ListStationActivity()
    }


    //private lateinit var swipeLayout: SwipeRefreshLayout
    //private lateinit var recyclerView: RecyclerView
    //private lateinit var viewModel: PageViewModel
    private lateinit var viewModel: StationListViewModel
    private lateinit var listview : ListView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {





        val rootView = inflater.inflate(R.layout.fragment_list_station, container, false)
        listview = rootView.findViewById(R.id.station_list_view)




        /*val json = getJson()
        val topic = Gson().fromJson(json, Json4Kotlin_Base::class.java)
        val monsterNames = StringBuilder()
        monsterNames.append("test")

        for (station in topic.data.nearstations) {
            monsterNames.append(station.street_name)
                .append("\n")

        }*/

        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(StationListViewModel::class.java)
        viewModel.cocktailsList.observe(viewLifecycleOwner, Observer{

            val adapter = ListStationAdapter(it.data.nearstations , context!!)
            listview.adapter= adapter

            /* listview.setOnItemClickListener { parent, view, position, id ->

                 val element = adapter.getItem(position) as Nearstations
                 val intent = Intent(activity, camera ::class.java).apply {
                     putExtra(EXTRA_MESSAGE, element.street_name )
                 }
                 startActivity(intent)
             }*/

        })


    }


    private fun getJson(): String? {
        val jsonString: String = getResources().openRawResource(R.raw.get_bus_station_request).bufferedReader().use { it.readText() }
        return jsonString
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }












    //val rootView = inflater.inflate(com.example.instabus.R.layout.fragment_list_station, container, false)

    /*recyclerView=findViewById(com.example.instabus.R.id.recycler_view)
    viewModel= StationsViewModel(this.application)
    viewModel.station.observe(this, Observer {
        val adapter = StationsAdapter(this@StationsListActivity,it,this@StationsListActivity)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
    })

    ------------

        viewModel = ViewModelProvider(this).get(PageViewModel::class.java)
        //AndroidViewModel = ViewModelProvider(this).get(StationListViewmodel::class.java)


        viewModel.cocktailsList.observe(viewLifecycleOwner, Observer{
            val monsterNames = StringBuilder()
            for ( nearstations in it) {
                monsterNames.append(nearstations.street_name)
                    .append("\n")
            }
             monsterNames
        })
*/


}
