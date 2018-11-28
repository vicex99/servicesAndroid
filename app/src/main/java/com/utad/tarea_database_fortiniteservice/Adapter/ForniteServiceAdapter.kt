package com.utad.tarea_database_fortiniteservice.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.utad.tarea_database_fortiniteservice.models.ForniteUsers
import android.view.LayoutInflater
import com.utad.tarea_database_fortiniteservice.R
import android.widget.TextView
import com.utad.tarea_database_fortiniteservice.models.dataRank


class ForniteServiceAdapter(val dataList: List<dataRank>) : RecyclerView.Adapter<ForniteServiceAdapter.GameViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: ForniteUsers)
    }

    // Create new card
    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): GameViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = layoutInflater.inflate(R.layout.data_cell, viewGroup, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(myHolder: GameViewHolder, index: Int) {
        myHolder.setData(dataList[index])

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    // TODO("eliminar si es muy tarde")
//    private fun clickableTxt(jobsViewHolder: GameViewHolder, item: ForniteUsers) {
//        if (item.getCompany_url() == null) {
//            jobsViewHolder.txtNoticeBrief.text = "No URL"
//        } else {
//            jobsViewHolder.txtNoticeBrief.isClickable = true
//            jobsViewHolder.txtNoticeBrief.setOnClickListener { v -> listener.onItemClick(item) }
//        }
//    }

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtTitle: TextView = itemView.findViewById(R.id.lblTitle)
        val txtValue: TextView = itemView.findViewById(R.id.lblValue)
        val txtRank: TextView = itemView.findViewById(R.id.lblRank)

        fun setData(userStatus: dataRank){
            txtTitle.text = userStatus.title
            txtValue.text = userStatus.value
            txtRank.text = userStatus.rank
        }
    }
}