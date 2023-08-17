package com.kotlin.fashon.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.kotlin.fashon.data.model.Product
import com.kotlin.fashon.data.remote.Retrofit
import com.kotlin.fashon.databinding.ActivityHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var list: List<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE

        list = listOf()
        lifecycleScope.launch(Dispatchers.IO) {

            Log.d("updates", "Entered global scope ${Thread.currentThread().name}")
            val response = Retrofit.getClient().getProducts();
            withContext(Dispatchers.Main) {
                Log.d("updates", "Back to thread ${Thread.currentThread().name}")
                if (response.isSuccessful) {
                    list = response.body()!!
                    println(list)
                    val adapter = ProductAdapter(list)
                    binding.rvProducts.layoutManager = GridLayoutManager(this@HomeActivity, 2)
                    binding.rvProducts.adapter = adapter
                }
            }
        }
        Log.d("updates", "Entered ${Thread.currentThread().name}")
//        val list : List<Product> = listOf()
    }
}