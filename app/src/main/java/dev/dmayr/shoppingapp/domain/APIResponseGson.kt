package dev.dmayr.shoppingapp.domain


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

class APIResponseGson : ArrayList<APIResponseGson.APIResponseGsonItem>() {
    @Parcelize
    data class APIResponseGsonItem(
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("title")
        val title: String = "",
        @SerializedName("price")
        val price: Double = 0.0,
        @SerializedName("description")
        val description: String = "",
        @SerializedName("category")
        val category: String = "",
        @SerializedName("image")
        val image: String = "",
        @SerializedName("rating")
        val rating: Rating = Rating()
    ) : Parcelable {
        @Parcelize
        data class Rating(
            @SerializedName("rate")
            val rate: Double = 0.0,
            @SerializedName("count")
            val count: Int = 0
        ) : Parcelable
    }
}
