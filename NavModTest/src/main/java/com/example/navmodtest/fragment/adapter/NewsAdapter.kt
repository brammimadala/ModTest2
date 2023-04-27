package com.example.navmodtest.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navmodtest.R
import com.example.navmodtest.model.Article


class NewsAdapter(private val list: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val newsItem = list[position]
        holder.title.text = newsItem.title
        holder.description.text = newsItem.description
        holder.publishAt.text = newsItem.publishedAt
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title: AppCompatTextView = itemView.findViewById(R.id.title)
        val description: AppCompatTextView = itemView.findViewById(R.id.description)
        val publishAt: AppCompatTextView = itemView.findViewById(R.id.publishAt)

    }
}