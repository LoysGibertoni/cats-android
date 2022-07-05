package br.com.example.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import br.com.example.kotlin.data.CatApi
import br.com.example.kotlin.data.Retrofit
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val catApi = Retrofit.create(CatApi::class.java)

    private var recyclerView: RecyclerView? = null
    private val catBreedsAdapter = CatBreedsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            adapter = catBreedsAdapter
        }

        loadData()
    }

    private fun loadData() {
        lifecycleScope.launch {
            val catBreeds = catApi.getBreeds()
            catBreedsAdapter.items = catBreeds
        }
    }

    override fun onDestroy() {
        recyclerView = null
        super.onDestroy()
    }

    private fun showError(exception: Exception) {
        recyclerView?.let {
            Snackbar.make(it, "Erro ao carregar dados: ${exception.message}", Snackbar.LENGTH_SHORT).show()
        }
    }
}