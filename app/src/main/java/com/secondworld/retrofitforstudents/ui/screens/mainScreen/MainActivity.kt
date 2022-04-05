package com.secondworld.retrofitforstudents.ui.screens.mainScreen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.secondworld.retrofitforstudents.data.models.ResponseCats
import com.secondworld.retrofitforstudents.data.repository.RepositoryImpl
import com.secondworld.retrofitforstudents.databinding.ActivityMainBinding
import com.secondworld.retrofitforstudents.domain.useCases.CatUseCase

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val repository = RepositoryImpl()
    private val viewModel : MainViewModel by viewModels{
        ViewModelFactory(CatUseCase(repository))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObservers()
        initData()
    }

    private fun initData() {
        swipeRefresh()
    }

    private fun initObservers() {
        viewModel.catInfo.observe(this){
            updateUi(it)
        }
    }

    private fun updateUi(catInfo: ResponseCats?) {
        Glide.with(this)
            .load("https://cataas.com/${catInfo?.url}")
            .into(binding.imageCat)

        binding.textCatId.text = "Id car: ${catInfo?.id ?: "нет id"}"
        binding.textDate.text = "Id car: ${catInfo?.createdAt ?: "нет даты"}"
    }

    private fun swipeRefresh() {
        binding.swipeRefreshContainer.setOnRefreshListener {
            viewModel.apply {
                viewModel.catInfo(true)
                binding.swipeRefreshContainer.isRefreshing = false
            }
        }
    }
}