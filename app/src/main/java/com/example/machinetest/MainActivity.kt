package com.example.machinetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.machinetest.Adapter.MainAdapter
import com.example.machinetest.ViewModel.MainRepository
import com.example.machinetest.ViewModel.MainViewModel
import com.example.machinetest.ViewModel.MyViewModelFactory
import com.example.machinetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)
        binding.recyclerview.adapter = adapter
        viewModel.lifeList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setLifeList(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllLifes()


        //......




    }
}