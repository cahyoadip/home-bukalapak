package com.dev.adi.ecosystem.controler

import com.adi.home.model.ResponseBanner
import com.adi.home.model.ResponseCategories
import com.adi.home.model.ResponsePopularProduct
import com.adi.home.model.ResponsePromo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class Services {
    //your base url
    val URL = "https://api.bukalapak.com/"

    fun create(): ServicesInterface {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(URL)
                .build()
        return retrofit.create(ServicesInterface::class.java)
    }
}

interface ServicesInterface {

    //1
    @GET("/v2/flash_banners.json")
    fun getBanner(): Call<ResponseBanner>

    @GET("/v2/categories.json")
    fun getCategori(): Call<ResponseCategories>

    @GET("/v2/products/promo_banners.json?version=2")
    fun getPromo(): Call<ResponsePromo>

    @GET("/v2/products/populars_v2.json")
    fun getProduct(): Call<ResponsePopularProduct>

//
//    //2
//    @GET("")
//    fun getDetailProduct(
//        @Path("") xx: String
//    ): Call<ResponDetailProduct>
//
//    //2
//    @POST("")
//    fun replyFeed(
//        @Path("") xx : Int,
//        @Path("") xx : Int,
//        @Body content : JsonObject
//    ): Call<ResponseTweat>
}