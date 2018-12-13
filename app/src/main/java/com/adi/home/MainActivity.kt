package com.adi.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.adi.home.adapter.CategoriesAdapter
import com.adi.home.adapter.ProductListAdapter
import com.adi.home.adapter.PromoAdapter
import com.adi.home.adapter.SliderAdapter
import com.adi.home.model.*
import com.dev.adi.ecosystem.controler.Services
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response





class MainActivity : AppCompatActivity() {

    private val dataCategories: ArrayList<Category> = arrayListOf()
    private val dataPromo: ArrayList<Banner> = arrayListOf()
    private val dataPopular: ArrayList<Popular> = arrayListOf()

    lateinit var categoriesAdapter: CategoriesAdapter
    lateinit var popularListAdapter: ProductListAdapter
    lateinit var promoAdapter: PromoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "HOME"
        getBanner()
        getCategories()
        getPromo()
        getProduct()

        categoriesAdapter = CategoriesAdapter(dataCategories, this)
        rv_categories.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false)
        rv_categories.itemAnimator = DefaultItemAnimator()
        rv_categories.adapter = categoriesAdapter

        promoAdapter = PromoAdapter(dataPromo, this)
        rv_promo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_promo.itemAnimator = DefaultItemAnimator()
        rv_promo.adapter = promoAdapter

        popularListAdapter = ProductListAdapter(dataPopular, this)
        rv_product.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_product.itemAnimator = DefaultItemAnimator()
        rv_product.adapter = popularListAdapter

//        productAdapter = ProductAdapter(dataProduk, this)
//        rv_products.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        rv_products.itemAnimator = DefaultItemAnimator()
//        rv_products.adapter = productAdapter
    }



    private fun getBanner() {
        val service = Services().create()
        service.getBanner().enqueue(object : Callback<ResponseBanner> {
            override fun onResponse(call: Call<ResponseBanner>, response: Response<ResponseBanner>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        banner_slider.setAdapter(SliderAdapter(body.banners, baseContext))
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBanner>, t: Throwable) {
            }

        })
    }

    private fun getCategories() {
        val service = Services().create()
        service.getCategori().enqueue(object : Callback<ResponseCategories> {
            override fun onResponse(call: Call<ResponseCategories>, response: Response<ResponseCategories>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        dataCategories.addAll(body.categories)
                        categoriesAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseCategories>, t: Throwable) {
            }

        })
    }

    private fun getPromo() {
        val service = Services().create()
        service.getPromo().enqueue(object : Callback<ResponsePromo> {
            override fun onResponse(call: Call<ResponsePromo>, response: Response<ResponsePromo>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        dataPromo.addAll(body.promo_banners)
                        promoAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResponsePromo>, t: Throwable) {
            }

        })
    }

    private fun getProduct() {
        val service = Services().create()
        service.getProduct().enqueue(object : Callback<ResponsePopularProduct> {
            override fun onResponse(call: Call<ResponsePopularProduct>, response: Response<ResponsePopularProduct>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        dataPopular.addAll(body.populars)
                        popularListAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResponsePopularProduct>, t: Throwable) {
            }

        })
    }
}
