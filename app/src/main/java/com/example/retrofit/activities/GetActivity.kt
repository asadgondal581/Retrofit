package com.example.retrofit.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.Adapters.GitHubAdapter
import com.example.retrofit.databinding.ActivityGetBinding
import com.example.retrofit.model.response.GitHubData
import com.example.retrofit.viewModel.GitViewModel

class GetActivity : AppCompatActivity() {

    private var githubInitViewModel: GitViewModel? = null
    private var binding: ActivityGetBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        loadData()
    }

    fun loadData() {
        githubInitViewModel = ViewModelProvider(this).get(GitViewModel::class.java)
        githubInitViewModel!!.getApiData()
        githubInitViewModel!!.gitHubDataList.observe(this, Observer {
            initAdapter(it)
        })
    }

    fun initAdapter(data: List<GitHubData>) {
        binding?.recyclerVi?.layoutManager = LinearLayoutManager(this)
        // This will pass the ArrayList to our Adapter
        val adapter = GitHubAdapter(data)
        // Setting the Adapter with the recyclerview
        binding?.recyclerVi?.adapter = adapter
    }
}