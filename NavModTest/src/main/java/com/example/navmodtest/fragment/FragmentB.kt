package com.example.navmodtest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navmodtest.R
import com.example.navmodtest.fragment.adapter.NewsAdapter
import com.example.navmodtest.fragment.viewmodel.NewsViewModel
import com.example.navmodtest.model.Article
import com.example.navmodtest.util.Resource

class FragmentB : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsAdapter
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        newsList()
        return view
    }

    private fun newsList() {
        viewModel.getNewsHeadLines("us", 1)
        viewModel.newsHeadLines.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    Toast.makeText(activity, "Loading.....", Toast.LENGTH_LONG).show()
                }

                is Resource.Success -> {
                    response.data?.let {
                        Toast.makeText(activity, "Success.....", Toast.LENGTH_LONG).show()
                        showRecyclerView(it.articles.toList())
                    }
                }

                is Resource.Error -> {
                    response.message?.let {
                        Toast.makeText(activity, "error occurred $it", Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }

    private fun showRecyclerView(list: List<Article>) {
        adapter = NewsAdapter(list)
        recyclerView.adapter = adapter
    }

}

