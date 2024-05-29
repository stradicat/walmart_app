package dev.dmayr.shoppingapp.domain


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

class APIResponseKotlinX : ArrayList<APIResponseKotlinX.APIResponseKotlinXItem>() {
    @Parcelize
    data class APIResponseKotlinXItem(
        val id: Int = 0,
        val title: String = "",
        val price: Double = 0.0,
        val description: String = "",
        val category: String = "",
        val image: String = "",
        val rating: Rating = Rating()
    ) : Parcelable {
        @Parcelize
        data class Rating(
            val rate: Double = 0.0,
            val count: Int = 0
        ) : Parcelable
    }
}
