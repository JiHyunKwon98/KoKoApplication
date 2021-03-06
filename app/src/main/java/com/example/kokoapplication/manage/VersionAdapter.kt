package com.example.kokoapplication.manage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kokoapplication.R

class VersionAdapter(val versionList: List<Versions>) :
    RecyclerView.Adapter<VersionAdapter.VersionVH>(){
    class VersionVH(itemView: View) : RecyclerView.ViewHolder(itemView){

        var codeNameTxt : TextView = itemView.findViewById(R.id.code_name)
        var versionTxt : TextView = itemView.findViewById(R.id.version)
        var apiLevelTxt : TextView = itemView.findViewById(R.id.api_level)
        var descriptionTxt : TextView = itemView.findViewById(R.id.description)
        var targetTxt : TextView = itemView.findViewById(R.id.target_content)
        var linearLayout : LinearLayout = itemView.findViewById(R.id.linearLayout)
        var expandableLayout : RelativeLayout = itemView.findViewById(R.id.expandable_layout)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionVH {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return  VersionVH(view)
    }

    override fun onBindViewHolder(holder: VersionVH, position: Int) {
        val versions : Versions = versionList[position]
        holder.codeNameTxt.text = versions.codeName
        holder.versionTxt.text = versions.version
        holder.apiLevelTxt.text = versions.apiLevel
        holder.descriptionTxt.text = versions.description
        holder.targetTxt.text = versions.targetContent

        val isExpandable : Boolean = versionList[position].expandalbe
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener{
            val versions = versionList[position]
            versions.expandalbe = !versions.expandalbe
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return versionList.size
    }
}