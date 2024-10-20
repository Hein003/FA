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
        val tvSportName: TextView = itemView.findViewById(R.id.tvSportName)
        val tvPlayerCount: TextView = itemView.findViewById(R.id.tvPlayerCount)
        val tvFieldType: TextView = itemView.findViewById(R.id.tvFieldType)
        val tvOlympicSport: TextView = itemView.findViewById(R.id.tvOlympicSport)
        val btnSeeDetail: Button = itemView.findViewById(R.id.btnSeeDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sport, parent, false)
        return SportsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val sport = sportsList[position]
        holder.tvSportName.text = sport.sportName
        holder.tvPlayerCount.text = "Player Count: ${sport.playerCount}"
        holder.tvFieldType.text = "Field Type: ${sport.fieldType}"
        holder.tvOlympicSport.text = "Olympic Sport: ${if (sport.olympicSport) "Yes" else "No"}"

        holder.btnSeeDetail.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, SportDetailActivity::class.java).apply {
                putExtra("SPORT_DESCRIPTION", sport.description)
                putExtra("sportName", sport.sportName)
                putExtra("playerCount", sport.playerCount)
                putExtra("fieldType", sport.fieldType)
                putExtra("olympicSport", sport.olympicSport)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return sportsList.size
    }
}
