package MD31.AP

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ORANG = "EXTRA_ORANG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject:TextView = findViewById(R.id.tv_object_received)

        val orang = if(Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Orang>(EXTRA_ORANG,Orang::class.java)
        } else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Orang>(EXTRA_ORANG)
        }

        if(orang!=null){
            val text = "Name : ${orang.name.toString()},\nEmail : ${orang.email},\nAge : ${orang.age},\nLocation : ${orang.city}"
            tvObject.text = text
        }

    }
}