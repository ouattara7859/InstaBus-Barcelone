package com.example.instabus.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.instabus.data.StationRepository

class StationListViewModel(app: Application) : AndroidViewModel(app) {

    private val dataRepository = StationRepository(app)
    val cocktailsList = dataRepository.cocktailsList
}