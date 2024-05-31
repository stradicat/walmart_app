package dev.dmayr.shoppingapp.domain.usecases

import dev.dmayr.shoppingapp.domain.data.model.APIResponseGson
import dev.dmayr.shoppingapp.domain.repository.APIRetrofitInstance

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
