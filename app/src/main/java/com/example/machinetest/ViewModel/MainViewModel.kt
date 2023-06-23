package com.example.machinetest.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.machinetest.Model.Life
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val repository: MainRepository) : ViewModel(){
    val lifeList = MutableLiveData<List<Life>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllLifes(){
        val response = repository.getAllLifes()
        response.enqueue(object : Callback<List<Life>> {
            override fun onResponse(call: Call<List<Life>>, response: Response<List<Life>>) {
                lifeList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Life>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}