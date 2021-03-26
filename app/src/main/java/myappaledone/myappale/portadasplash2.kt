package myappaledone.myappale

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class portadasplash2 : AppCompatActivity() {

    private val SPLASH_TIME: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitypantalla1)

        Handler().postDelayed( {
            startActivity(Intent (this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME)
    }
}

