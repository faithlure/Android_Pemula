package bangkit.academy.submission_android_pemula_md31

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_buku)

        supportActionBar?.apply {
            title = getString(R.string.detail)
        }

        val dataBuku = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Buku>("key_buku", Buku::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Buku>("key_buku")
        }

        if(dataBuku!=null){

            val tvDetailTitle = findViewById<TextView>(R.id.tv_item_title)
            val tvDetailSinopsis = findViewById<TextView>(R.id.tv_item_sinopsis)
            val ivDetailPhoto = findViewById<ImageView>(R.id.img_item_photo)
            val itemHarga = findViewById<TextView>(R.id.item_harga)
            val itemPenerbit = findViewById<TextView>(R.id.item_penerbit)

            tvDetailTitle.text = dataBuku.title
            tvDetailSinopsis.text = dataBuku.sinopsis
            ivDetailPhoto.setImageResource(dataBuku.photo)
            itemHarga.text = ("Rp" + dataBuku.harga)
            itemPenerbit.text=dataBuku.penerbit
        }

    }
}
