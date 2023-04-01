package com.example.retrofit.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.model.response.GitHubData
import com.google.android.material.textview.MaterialTextView


class GitHubAdapter(private val mList: List<GitHubData>) :
    RecyclerView.Adapter<GitHubAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GitHubAdapter.ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.textView1.text = ItemsViewModel.title
        holder.textView.text = ItemsViewModel.created_at
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView1: MaterialTextView = itemView.findViewById(R.id.text_title)
        val textView: MaterialTextView = itemView.findViewById(R.id.text_date)
    }
}