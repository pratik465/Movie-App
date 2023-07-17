package com.pachchham.pagenatoin.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pachchham.pagenatoin.Adapter.MoviesAdapter
import com.pachchham.pagenatoin.Client.ApiClient
import com.pachchham.pagenatoin.Interface.ApiInterface
import com.pachchham.pagenatoin.Interface.ApiInterface3
import com.pachchham.pagenatoin.Modal.MovieModel
import com.pachchham.pagenatoin.Modal.ResultsItem
import com.pachchham.pagenatoin.databinding.FragmentPopularBinding
import com.pachchham.pagenatoin.databinding.FragmentTopRatedBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRatedFragment : Fragment() {
    var page = 1
    var adapter = MoviesAdapter()
    lateinit var binding: FragmentTopRatedBinding
    var list = ArrayList<ResultsItem>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTopRatedBinding.inflate(layoutInflater)

        binding.nested.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {

                page++
                callApi(page)
            }
        })

        callApi(page)
        return binding.root
    }

    private fun callApi(page: Int) {
        var api = ApiClient.getApiClient().create(ApiInterface3::class.java)
        api.getTpoRated(this.page).enqueue(object : Callback<MovieModel> {
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {

                if (response.isSuccessful) {

                    var movieList = response.body()?.results

                    list.addAll(movieList as ArrayList<ResultsItem>)

                    adapter.setmovies(list)
                    binding.rcvMovie.layoutManager = LinearLayoutManager(context)
                    binding.rcvMovie.adapter = adapter
                }

            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {

            }

        })

    }
}


