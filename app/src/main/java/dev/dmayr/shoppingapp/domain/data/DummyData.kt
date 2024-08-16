package dev.dmayr.shoppingapp.domain.data

import android.net.Uri
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import dev.dmayr.shoppingapp.R
import dev.dmayr.shoppingapp.domain.data.model.APIResponseGson
import kotlinx.parcelize.Parcelize
import java.io.File

object data1 : ArrayList<APIResponseGson.APIResponseGsonItem>() {
    @Parcelize
    class APIResponseGsonItem(
        @SerializedName("id")
        val id: Int = 1,
        @SerializedName("title")
        val title: String = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
        @SerializedName("price")
        val price: Double = 109.95,
        @SerializedName("description")
        val description: String = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
        @SerializedName("category")
        val category: String = "men's clothing",
        @SerializedName("image")
        val image: String = "${Uri.fromFile(File(R.drawable.img_bolso.toString()))}",
        @SerializedName("rating")
        val rating: Rating = Rating()
    ) : Parcelable {
        @Parcelize
        class Rating(
            @SerializedName("rate")
            val rate: Double = 3.9,
            @SerializedName("count")
            val count: Int = 120
        ) : Parcelable
    }
}
