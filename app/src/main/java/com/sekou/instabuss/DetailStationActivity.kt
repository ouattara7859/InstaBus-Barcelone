package com.sekou.instabuss

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.instabus.data.Station

class DetailStationActivity : AppCompatActivity() {

    private val picture: ImageView by lazy { findViewById<ImageView>(R.id.picture) }
    private val title: TextView by lazy { findViewById<TextView>(R.id.name) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail_station)

        if (intent.hasExtra("Cocktail")) {

            val station: Station = intent.getSerializableExtra("Cocktail") as Station


            title.text = station.strNameStation
        }
    }

    /*

    private fun goToCocktailDetails(position: Int) {
        val intent = Intent(this, CocktailsDetailsActivity::class.java)
        intent.putExtra("Cocktail", viewModel.cocktailsList.value?.get(position))
        startActivity(intent)
    }

    //Lorsque l'utolisateur clique sur un cocktail dans le RecyclerView, on affiche les détails du cocktail
    override fun onCocktailClick(position: Int) {
        goToCocktailDetails(position)
    }

     */
}