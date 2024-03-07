package MD31.AP

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil :$selectedValue"
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObjectActivity: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObjectActivity.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Aditya Prayoga")
                moveIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_object -> {
                val orang = Orang(
                    "Aditya Prayoga",
                    20,
                    "Bandung",
                    "belajarkotlin@academy.bangkit.com"
                )

                val moveIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveIntent.putExtra(MoveWithObjectActivity.EXTRA_ORANG, orang)
                startActivity(moveIntent)
            }

            R.id.btn_dial_number -> {
                val nomerTelp = "0123456789"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$nomerTelp"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent =
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }
}