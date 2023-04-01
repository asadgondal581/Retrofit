package com.example.retrofit.network


import com.example.retrofit.model.response.GitHubData
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/repos/octocat/hello-world/issues")
    fun getDataFromApi(): Call<List<GitHubData>>
}