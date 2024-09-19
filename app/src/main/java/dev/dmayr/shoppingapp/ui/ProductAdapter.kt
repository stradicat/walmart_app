package dev.dmayr.shoppingapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.dmayr.shoppingapp.databinding.ProductViewGeneralBinding
import dev.dmayr.shoppingapp.domain.api.APIResponseGson

class ProductAdapter(private val products: List<APIResponseGson.APIResponseGsonItem>) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    inner class ProductHolder(internal val binding: ProductViewGeneralBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view by lazy { LayoutInflater.from(parent.context) }
        val binding by lazy {
            ProductViewGeneralBinding.inflate(view, parent, false)
        }
        return ProductHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val imageUri by lazy {
            products[position].image
        }
        holder.binding.apply {
//            if(products[position].)
            pvgImage.setImageURI(imageUri)
        }

    }

}
