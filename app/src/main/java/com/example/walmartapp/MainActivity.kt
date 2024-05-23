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
import com.example.walmartapp.databinding.ProductViewGeneralBinding
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var menuSwitch: ActionBarDrawerToggle
    private lateinit var productViewGeneralBinding: ProductViewGeneralBinding
    private lateinit var customToolbar: ActionbarLayoutBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        val view = binding.root
        setContentView(view)
        Fresco.initialize(this)

        // Custom toolbar
        // Set up the custom ActionBar
        customToolbar = ActionbarLayoutBinding.inflate(layoutInflater)
        supportActionBar?.apply {
            displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            customView = customToolbar.root
        }

        // Inflate product view and add it to the container
        val inflater = LayoutInflater.from(this)
        productViewGeneralBinding =
            ProductViewGeneralBinding.inflate(inflater, binding.pvgViewContainer, true)

        // Access views from the included layout
        val productTitle: TextView = productViewGeneralBinding.pvgProdTitle
        val productPrice: TextView = productViewGeneralBinding.pvgProdPrice
        val productImage: SimpleDraweeView = productViewGeneralBinding.pvgImage

        // Set values or listeners
        productTitle.text = "Cafesoso Negruzco"
        var arbitraryPrice: Int = 3500
        productPrice.text = "\$ $arbitraryPrice"
        productImage.setImageResource(R.drawable.img_placement_nescafe)

        // Implementación de menú
        menuSwitch =
            ActionBarDrawerToggle(this, binding.mainActivity, R.string.open, R.string.close)

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
