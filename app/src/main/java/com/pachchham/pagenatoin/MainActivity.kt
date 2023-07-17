package com.pachchham.pagenatoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import com.pachchham.pagenatoin.Adapter.MoviesAdapter
import com.pachchham.pagenatoin.Client.ApiClient
import com.pachchham.pagenatoin.Fragments.NowPlayingFragment
import com.pachchham.pagenatoin.Fragments.PopularFragment
import com.pachchham.pagenatoin.Fragments.TopRatedFragment
import com.pachchham.pagenatoin.Fragments.UpcomingFragment
import com.pachchham.pagenatoin.Interface.ApiInterface

import com.pachchham.pagenatoin.Modal.ResultsItem
import com.pachchham.pagenatoin.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var adapter = MoviesAdapter()
    var page = 1
    var list = ArrayList<ResultsItem>()
    lateinit var binding: ActivityMainBinding

    var item = arrayOf("Now Playing","Popular", "Top Rate", "Upcoming")
    var fragments = arrayOf(NowPlayingFragment(), PopularFragment(), TopRatedFragment(), UpcomingFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ViewPage.adapter = Fragment_Adapter(supportFragmentManager , fragments ,item)
        binding.TabLayout.setupWithViewPager(binding.ViewPage)
    }
}