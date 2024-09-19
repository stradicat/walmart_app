package dev.dmayr.shoppingapp

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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.badge.ExperimentalBadgeUtils
import com.google.android.material.button.MaterialButton
import dev.dmayr.shoppingapp.databinding.ActionbarLayoutBinding
import dev.dmayr.shoppingapp.databinding.ActivityMainBinding
import dev.dmayr.shoppingapp.databinding.ProductViewDestacadoBinding
import dev.dmayr.shoppingapp.domain.api.APIResponseGson
import dev.dmayr.shoppingapp.domain.repository.ProductRepo
import dev.dmayr.shoppingapp.ui.ProductAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    private val productRepo: ProductRepo by lazy { ProductRepo() }
    private lateinit var buttonWithBadge: MaterialButton
    private lateinit var buttonLayout: FrameLayout
    private lateinit var products: List<APIResponseGson.APIResponseGsonItem>

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

        // Armado del RecyclerView de productos generales
        lifecycleScope.launch(IO) {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                products = productRepo.fetchAllProducts()
                withContext(Dispatchers.Main) {
                    setupRecyclerView()
                }
            }
        }

        // Test de alteración de vista de producto destacado
        val productTitle: TextView = productViewDestacadoBinding.pvdesProdTitle
        val productPrice: TextView = productViewDestacadoBinding.pvdesProdPrice
        val productImage: SimpleDraweeView = productViewDestacadoBinding.pvdesImage

        productTitle.text = "Café Tostado"
        var arbitraryPrice: Int = 3500
        productPrice.text = "\$ $arbitraryPrice"
        productImage.setImageResource(R.drawable.img_placement_nescafe)
        //

        // Implementación de menú
        mainBinding.mainActivity.addDrawerListener(menuSwitchBinding)
        menuSwitchBinding.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Scaffolding del menú
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

    // Implementación del RecyclerView
    private fun setupRecyclerView() = mainBinding.rvProductosGenerales.apply {
        val productAdapter = ProductAdapter(products)

        mainBinding.rvProductosGenerales.adapter = productAdapter
        this.layoutManager = LinearLayoutManager(this@MainActivity)
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
