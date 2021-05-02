package com.example.visiblepractice

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val context: Context,
    private val dateList: List<String>,
    private val garbageList: List<String>
) :
    RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        Log.d("kiyotalog","onCreateViewHolder")
        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.item_date_and_garbage, parent, false)
        return RecyclerViewHolder(mView)
    }

    override fun getItemCount(): Int {
        Log.d("kiyotalog","getItemCount:"+dateList.size)
        return dateList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        Log.d("kiyotalog","onBindViewHolder")
        holder.let {
            it.dateTitle.text = dateList[position]
            it.garbageKind.text = garbageList[position]
        }
    }
}

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val dateTitle: TextView = view.findViewById(R.id.date_title)
    val garbageKind: TextView = view.findViewById(R.id.garbage_kind)
}