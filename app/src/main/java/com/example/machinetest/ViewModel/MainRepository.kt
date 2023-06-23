package com.example.machinetest.ViewModel

import com.example.machinetest.RetrofitService

class MainRepository  constructor(private val retrtofitService:RetrofitService){
    fun getAllLifes() =retrtofitService.getAllLifes()

   // class MainRepository constructor(private val retrofitService: RetrofitService) {
      //  fun getAllMovies() = retrofitService.getAllMovies()
  //  }

}