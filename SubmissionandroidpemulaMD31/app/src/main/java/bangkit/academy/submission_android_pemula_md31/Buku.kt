package bangkit.academy.submission_android_pemula_md31

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Buku(
    val title: String,
    val sinopsis: String,
    val photo: Int,
    val harga: Int,
    val penerbit : String

) : Parcelable

