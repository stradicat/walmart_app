package dev.dmayr.shoppingapp.domain.api

import retrofit2.Response
import retrofit2.http.GET

interface APIretrofit {
    @GET("products")
    suspend fun productsAll(): Response<ArrayList<APIResponseGson.APIResponseGsonItem>>
}
