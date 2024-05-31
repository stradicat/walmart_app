package dev.dmayr.shoppingapp.domain.remote

import dev.dmayr.shoppingapp.domain.data.model.APIResponseGson
import retrofit2.Response
import retrofit2.http.GET

interface APIretrofit {
    @GET("products")
    suspend fun productsAll(): Response<ArrayList<APIResponseGson.APIResponseGsonItem>>
}
