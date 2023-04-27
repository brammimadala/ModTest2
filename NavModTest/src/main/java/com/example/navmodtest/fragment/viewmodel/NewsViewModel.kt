package com.example.navmodtest.fragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navmodtest.api.NewsApiService
import com.example.navmodtest.api.RetrofitClient
import com.example.navmodtest.model.APIResponse
import com.example.navmodtest.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit


class NewsViewModel : ViewModel() {

    private var apiInterface: NewsApiService
    private var retrofit: Retrofit = RetrofitClient.getInstance()
    val newsHeadLines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    init {
        apiInterface = retrofit.create(NewsApiService::class.java)
    }

    fun getNewsHeadLines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadLines.postValue(Resource.Loading())
        try {
            val apiResult = apiInterface.getTopHeadLines(country, page)
            val result = responseToResource(apiResult)
            newsHeadLines.postValue(result)
        } catch (e: Exception) {
            newsHeadLines.postValue(Resource.Error(e.message.toString()))
        }
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {

        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

}