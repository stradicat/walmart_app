package com.example.walmartapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.walmartapp.databinding.ActionbarLayoutBinding
import com.example.walmartapp.databinding.ActivityMainBinding
import com.example.walmartapp.databinding.ProductViewDestacadoBinding
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val menuSwitch: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(
            this,
            binding.mainActivity,
            R.string.open,
            R.string.close
        )
    }
    private val productViewDestacadoBinding: ProductViewDestacadoBinding by lazy {
        ProductViewDestacadoBinding.inflate(
            LayoutInflater.from(this),
            binding.pvgViewContainer,
            true
        )
    }
    private val customToolbar: ActionbarLayoutBinding by lazy {
        ActionbarLayoutBinding.inflate(
            layoutInflater
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = binding.root
        setContentView(view)
        Fresco.initialize(this)

        // Set up the custom ActionBar
        supportActionBar?.apply {
            displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            customView = customToolbar.root
        }


        val productTitle: TextView = productViewDestacadoBinding.pvdesProdTitle
        val productPrice: TextView = productViewDestacadoBinding.pvdesProdPrice
        val productImage: SimpleDraweeView = productViewDestacadoBinding.pvdesImage


        productTitle.text = "Cafesoso Negruzco"
        var arbitraryPrice: Int = 3500
        productPrice.text = "\$ $arbitraryPrice"
        productImage.setImageResource(R.drawable.img_placement_nescafe)

        // Implementación de menú
        binding.mainActivity.addDrawerListener(menuSwitch)
        menuSwitch.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navigationDrawer.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.productosTodos -> Toast.makeText(
                    applicationContext,
                    "Todos los productos seleccionados",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.producto1 -> Toast.makeText(
                    applicationContext,
                    "Selección: Producto 1",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.producto2 -> Toast.makeText(
                    applicationContext,
                    "Selección: Producto 2",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.producto3 -> Toast.makeText(
                    applicationContext,
                    "Selección: Producto 3",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.producto4 -> Toast.makeText(
                    applicationContext,
                    "Selección: Producto 4",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.producto5 -> Toast.makeText(
                    applicationContext,
                    "Selección: Producto 5",
                    Toast.LENGTH_SHORT
                ).show()

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (menuSwitch.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
