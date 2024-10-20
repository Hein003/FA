package com.example.finalassigment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class SportDetailActivity : AppCompatActivity() {

    private lateinit var tvSportName: TextView
    private lateinit var tvPlayerCount: TextView
    private lateinit var tvFieldType: TextView
    private lateinit var tvOlympicSport: TextView
    private lateinit var tvDescription: TextView

    private val sportDetailViewModel: SportDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sports_detail)

        // Initialize views
        tvSportName = findViewById(R.id.tvSportName)
        tvPlayerCount = findViewById(R.id.tvPlayerCount)
        tvFieldType = findViewById(R.id.tvFieldType)
        tvOlympicSport = findViewById(R.id.tvOlympicSport)
        tvDescription = findViewById(R.id.tvDescription)

        // Retrieve the data from the intent
        val sportName = intent.getStringExtra("sportName") ?: "Sport"
        val playerCount = intent.getIntExtra("playerCount", 0)
        val fieldType = intent.getStringExtra("fieldType") ?: "Unknown"
        val olympicSport = intent.getBooleanExtra("olympicSport", false)
        val description = intent.getStringExtra("SPORT_DESCRIPTION") ?: "No description available"

        // Pass the data to the ViewModel
        sportDetailViewModel.setSportDetails(sportName, playerCount, fieldType, olympicSport, description)

        // Observe the ViewModel data and update the UI
        sportDetailViewModel.sportName.observe(this, Observer { sportName ->
            tvSportName.text = sportName
        })

        sportDetailViewModel.playerCount.observe(this, Observer { playerCount ->
            tvPlayerCount.text = "Player Count: $playerCount"
        })

        sportDetailViewModel.fieldType.observe(this, Observer { fieldType ->
            tvFieldType.text = "Field Type: $fieldType"
        })

        sportDetailViewModel.olympicSport.observe(this, Observer { olympicSport ->
            tvOlympicSport.text = "Olympic Sport: ${if (olympicSport) "Yes" else "No"}"
        })

        sportDetailViewModel.description.observe(this, Observer { description ->
            tvDescription.text = description
        })
    }

    fun goBackToDashboard(view: View) {
        finish()
    }
}
