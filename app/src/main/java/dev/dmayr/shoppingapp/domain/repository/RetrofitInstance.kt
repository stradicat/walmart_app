package dev.dmayr.shoppingapp.domain.repository

import dev.dmayr.shoppingapp.domain.api.APIretrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIRetrofitInstance {
    private const val BASE_URL = "https://fakestoreapi.com/"

    private val retrofitInstance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val productAPIservice: APIretrofit by lazy {
        retrofitInstance.create(APIretrofit::class.java)
    }
}
