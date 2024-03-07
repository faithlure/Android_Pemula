package bangkit.academy.submission_android_pemula_md31

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListBukuAdapter(private val listBuku: ArrayList<Buku>) :
    RecyclerView.Adapter<ListBukuAdapter.ListViewHolder>() {



    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val tvSinopsis: TextView = itemView.findViewById(R.id.tv_item_sinopsis)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_buku, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listBuku.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, sinopsis, photo) = listBuku[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvTitle.text = title
        holder.tvSinopsis.text = sinopsis
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_buku", listBuku[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }


}