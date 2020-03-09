package com.example.instabus.data

import Data
import Json4Kotlin_Base

import retrofit2.Response
import retrofit2.http.GET

interface StationsService {
    @GET("/bus/nearstation/latlon/ 41.3985182/2.1917991/1.json")
    suspend fun getStationData(): Response<Json4Kotlin_Base>
}