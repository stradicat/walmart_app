package dev.dmayr.shoppingapp.domain.repository

import dev.dmayr.shoppingapp.domain.api.APIResponseGson

class ProductRepo {
    suspend fun fetchAllProducts(): ArrayList<APIResponseGson.APIResponseGsonItem> {
        val response = APIRetrofitInstance.productAPIservice.productsAll()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception("API request failed: ${response.code()}")
        }
    }

}
