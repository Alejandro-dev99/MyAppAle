package myappaledone.myappale;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;

import myappaledone.myappale.R;
import myappaledone.myappale.features.SplashScreenActivity;
import myappaledone.myappale.features.gameplay.GamePlayActivity;
import myappaledone.myappale.features.mainmenu.MainMenuActivity;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        Button btn = (Button) findViewById(R.id.buttonprimero);
        Button btn22 = (Button) findViewById(R.id.buttonsegundo);

        //gr

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenuActivity(); }
        });

        //fgvfv



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpagina1();
                Log.i("MyApp", "This is a magic log message!");
                Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT)
                        .show();


            }
        });

    }


    public void openMainMenuActivity() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);

    }


    public void openpagina1() {
                Intent intent = new Intent(this, pagina1.class);
                startActivity(intent);
            }
}

