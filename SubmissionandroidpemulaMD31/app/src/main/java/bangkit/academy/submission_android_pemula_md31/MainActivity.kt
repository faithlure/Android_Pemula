package bangkit.academy.submission_android_pemula_md31

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rv_Buku: RecyclerView
    private val list = ArrayList<Buku>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            title = getString(R.string.home)
        }

        rv_Buku = findViewById(R.id.rv_buku)
        rv_Buku.setHasFixedSize(true)

        list.addAll(getListBuku())
        showRecyclerList()
    }

    private fun getListBuku(): ArrayList<Buku> {
        val dataName = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_sinopsis)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataHarga = resources.getIntArray(R.array.data_harga)
        val dataPenerbit = resources.getStringArray(R.array.data_penerbit)
        val listBuku = ArrayList<Buku>()
        for (i in dataName.indices) {
            val buku = Buku(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataHarga[i], dataPenerbit[i])
            listBuku.add(buku)
        }
        return listBuku
    }

    private fun showRecyclerList() {
        rv_Buku.layoutManager = LinearLayoutManager(this)
        val listBukuAdapter = ListBukuAdapter(list)
        rv_Buku.adapter = listBukuAdapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rv_Buku.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rv_Buku.layoutManager = GridLayoutManager(this, 2)
            }

            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

