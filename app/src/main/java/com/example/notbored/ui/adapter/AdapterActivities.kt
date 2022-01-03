package com.example.notbored.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.R
import com.example.notbored.databinding.ItemsActivitiesBinding

class AdapterActivities (val listActivities: List<String>): RecyclerView.Adapter<ActivitiesHolder>(){

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener:onItemClickListener){
        mListener=listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesHolder {
        // creating view to ActivitiesHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_activities, parent,false)
        return ActivitiesHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: ActivitiesHolder, position: Int) {
        // Set texts for specific position in the list
        holder.bind(listActivities[position])
    }

    override fun getItemCount(): Int {
        // return size list
        return listActivities.size
    }
}

class ActivitiesHolder(view: View, listener:AdapterActivities.onItemClickListener): RecyclerView.ViewHolder(view){
    // Refresh itemFragment with API
    val binding = ItemsActivitiesBinding.bind(view)

    fun bind(activity: String){
        binding.tvActivity.text = activity
    }
    init {
        view.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}