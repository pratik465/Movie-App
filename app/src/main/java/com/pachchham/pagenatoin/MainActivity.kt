package com.pachchham.pagenatoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import com.pachchham.pagenatoin.Adapter.PopularAdapter
import com.pachchham.pagenatoin.Client.ApiClient
import com.pachchham.pagenatoin.Interface.ApiInterface
import com.pachchham.pagenatoin.Modal.PopularMovieModel
import com.pachchham.pagenatoin.Modal.ResultsItem
import com.pachchham.pagenatoin.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var adapter = PopularAdapter()
    var page = 1
    var list = ArrayList<ResultsItem>()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.nested.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight){

                page++
                callApi(page)
            }
        })

        callApi(page)
    }

    private fun callApi(page: Int) {
        var api = ApiClient.getApiClient().create(ApiInterface::class.java)
        api.getPopularMovie(page).enqueue(object : Callback<PopularMovieModel> {
            override fun onResponse(
                call: Call<PopularMovieModel>,
                response: Response<PopularMovieModel>
            ) {
                if (response.isSuccessful) {
                    var popularList = response.body()?.results

                    list.addAll(popularList as ArrayList<ResultsItem>)

                    adapter.setListing(popularList)
                    binding.rcvPopular.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rcvPopular.adapter = adapter
                }
            }

            override fun onFailure(call: Call<PopularMovieModel>, t: Throwable) {

            }

        })
    }
}