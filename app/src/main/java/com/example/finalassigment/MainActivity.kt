package com.example.finalassigment

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var sportsAdapter: SportsAdapter

    // ViewModel declaration
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe the sports data
        mainViewModel.sportsData.observe(this) { sportsList ->
            // Set up the adapter with the retrieved data
            sportsAdapter = SportsAdapter(sportsList) // Assuming sportsList is of type List<Sport>
            recyclerView.adapter = sportsAdapter
        }

        // Observe error messages
        mainViewModel.errorMessage.observe(this) { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }

        // Fetch data from API through ViewModel
        mainViewModel.fetchSportsData()
    }
}
