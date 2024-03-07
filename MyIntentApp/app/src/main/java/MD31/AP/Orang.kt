package MD31.AP

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Orang(
    val name: String?,
    val age: Int?,
    val city: String?,
    val email: String?
    ) : Parcelable
