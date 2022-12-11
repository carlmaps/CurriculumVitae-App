package com.example.curriculumvitae

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.work_experience_list.view.*


class WorkRecyclerAdapter(var workExperienceList: ArrayList<WorkExperience>, var context: Context) : RecyclerView.Adapter<WorkRecyclerAdapter.WorkViewHolder>() {
    inner class WorkViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.work_experience_list, parent,false)
        return WorkViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkViewHolder, position: Int) {
        holder.itemView.jobTitle.text = workExperienceList[position].jobTitle
        holder.itemView.company.text = workExperienceList[position].company
        (workExperienceList[position].startDate + "-" + workExperienceList[position].endDate).also { holder.itemView.jobDuration.text = it }
        holder.itemView.jobDescription.text = workExperienceList[position].workContrib
        holder.itemView.image.setImageResource(getDrawableIntByFileName(context,workExperienceList[position].company.lowercase().replace("\\s".toRegex(), "")))
//        holder.itemView.image.setImageResource(R.drawable.ncr)

    }

    override fun getItemCount(): Int {
        return workExperienceList.size
    }

    fun getDrawableIntByFileName(context: Context, fileName: String): Int {
        return context.resources.getIdentifier(fileName, "drawable", context.packageName)
    }
}