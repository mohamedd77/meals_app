package com.hamalawey.mealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.hamalawey.domain.usecase.GetMealz
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel:MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         viewModel.getMeals()
        val mealsadp=MealsAdapter()
        val recy:RecyclerView=findViewById(R.id.category_rv)
        lifecycleScope.launch {
            viewModel.categories.collect{
             mealsadp.submitList(it?.categories)
                recy.adapter=mealsadp
            }
        }

    }
}