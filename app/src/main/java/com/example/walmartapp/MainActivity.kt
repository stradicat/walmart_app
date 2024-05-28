package com.example.walmartapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.FrameLayout
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
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.badge.ExperimentalBadgeUtils
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private val mainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(
            layoutInflater
        )
    }
    private val menuSwitchBinding: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(
            this,
            mainBinding.mainActivity,
            R.string.open,
            R.string.close
        )
    }
    private val productViewDestacadoBinding: ProductViewDestacadoBinding by lazy {
        ProductViewDestacadoBinding.inflate(
            LayoutInflater.from(this),
            mainBinding.pvgViewContainer,
            true
        )
    }
    private val customToolbarBinding: ActionbarLayoutBinding by lazy {
        ActionbarLayoutBinding.inflate(
            layoutInflater
        )
    }

    private lateinit var buttonWithBadge: MaterialButton
    private lateinit var buttonLayout: FrameLayout

    @ExperimentalBadgeUtils
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = mainBinding.root
        setContentView(view)
        Fresco.initialize(this)

        // Set up the custom ActionBar
        supportActionBar?.apply {
            displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            customView = customToolbarBinding.root
        }

        //
        buttonWithBadge = customToolbarBinding.btnCartTB
        buttonLayout = customToolbarBinding.cartButtonLayout

        // Test: Badge -> buttonWithBadge
        buttonWithBadge.setOnClickListener {
            setBadgeCount(1)
        }

        // Test de alteración de vista de producto
        val productTitle: TextView = productViewDestacadoBinding.pvdesProdTitle
        val productPrice: TextView = productViewDestacadoBinding.pvdesProdPrice
        val productImage: SimpleDraweeView = productViewDestacadoBinding.pvdesImage

        productTitle.text = "Café Tostado"
        var arbitraryPrice: Int = 3500
        productPrice.text = "\$ $arbitraryPrice"
        productImage.setImageResource(R.drawable.img_placement_nescafe)

        // Implementación del RecyclerView
        val recyclerView = mainBinding.rvProductosGenerales
        val adapter = mainBinding.rvProductosGenerales.adapter

        // Implementación de menú
        mainBinding.mainActivity.addDrawerListener(menuSwitchBinding)
        menuSwitchBinding.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mainBinding.navigationDrawer.setNavigationItemSelectedListener {
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

    @ExperimentalBadgeUtils
    private fun setBadgeCount(count: Int): Int {
        BadgeDrawable.createFromResource(this, R.xml.badge_style).apply {
            number = count
            BadgeUtils.attachBadgeDrawable(this, buttonWithBadge)
        }
        return count
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (menuSwitchBinding.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
