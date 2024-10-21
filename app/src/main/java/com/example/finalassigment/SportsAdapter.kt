package com.example.finalassigment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassigment.data.Sport

class SportsAdapter(private val sportsList: List<Sport>) : RecyclerView.Adapter<SportsAdapter.SportsViewHolder>() {

    class SportsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // ViewHolder to hold references to the UI components
        val tvSportName: TextView = itemView.findViewById(R.id.tvSportName)  // TextView for sport name
        val tvPlayerCount: TextView = itemView.findViewById(R.id.tvPlayerCount)  // TextView for player count
        val tvFieldType: TextView = itemView.findViewById(R.id.tvFieldType)  // TextView for field type
        val tvOlympicSport: TextView = itemView.findViewById(R.id.tvOlympicSport)  // TextView for Olympic status
        val btnSeeDetail: Button = itemView.findViewById(R.id.btnSeeDetail)  // Button to see details
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        // Inflate the item layout and create ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sport, parent, false)
        return SportsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val sport = sportsList[position]  // Get the sport at the current position
        holder.tvSportName.text = sport.sportName  // Set sport name
        holder.tvPlayerCount.text = "Player Count: ${sport.playerCount}"  // Set player count
        holder.tvFieldType.text = "Field Type: ${sport.fieldType}"  // Set field type
        holder.tvOlympicSport.text = "Olympic Sport: ${if (sport.olympicSport) "Yes" else "No"}"  // Set Olympic status

        holder.btnSeeDetail.setOnClickListener {
            // Set up the detail view intent
            val context = holder.itemView.context
            val intent = Intent(context, SportDetailActivity::class.java).apply {
                putExtra("SPORT_DESCRIPTION", sport.description)  // Pass sport description
                putExtra("sportName", sport.sportName)  // Pass sport name
                putExtra("playerCount", sport.playerCount)  // Pass player count
                putExtra("fieldType", sport.fieldType)  // Pass field type
                putExtra("olympicSport", sport.olympicSport)  // Pass Olympic status
            }
            context.startActivity(intent)  // Start the detail activity
        }
    }

    override fun getItemCount(): Int {
        return sportsList.size  // Return the size of the sports list
    }
}
