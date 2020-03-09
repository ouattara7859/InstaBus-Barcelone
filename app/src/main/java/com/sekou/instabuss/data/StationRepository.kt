
package com.example.instabus.data

import Json4Kotlin_Base
import Nearstations
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.instabus.WEB_SERVICE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//import com.example.myapplication.COCKTAILS_WEB_SERVICE_URL
//import com.squareup.moshi.Types
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.moshi.MoshiConverterFactory

//Repository, contient toutes les méthodes d'accès aux données
class StationRepository (val app: Application) {

    val cocktailsList = MutableLiveData<Json4Kotlin_Base>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            callwebservice()
        }
    }

    //Récupère les datas via l'API Cocktails
    /*@WorkerThread
    suspend fun callwebservice(){
        val moshi= Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder().baseUrl(WEB_SERVICE_URL).addConverterFactory(
            MoshiConverterFactory.create(moshi)).build()
        val service = retrofit.create(StationsService::class.java)
        val serviceData =service.getStationData().body()
        cocktailsList.postValue(serviceData?.nearstations)
    }*/
    @WorkerThread
    suspend fun callwebservice() {
        if (networkAvailable()) {
            val retrofit = Retrofit.Builder()
                .baseUrl(WEB_SERVICE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            val service = retrofit.create(StationsService::class.java)
            val serviceData = service.getStationData().body() ?: null
            cocktailsList.postValue(serviceData)
        }
    }

    @Suppress("DEPRECATION")
    private fun networkAvailable(): Boolean {
        val connectivityManager =
            app.getSystemService(Context.CONNECTIVITY_SERVICE)
                    as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false
    }

}

