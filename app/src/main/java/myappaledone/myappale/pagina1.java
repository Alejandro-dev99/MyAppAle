package myappaledone.myappale;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pagina1<view> extends AppCompatActivity {


    GridView gridView;

    String[] numberWord =
            {"The Cuban Spectrum”\nThis is a Caribbean afro-Cuban-Scandinavian jazz crossover band founded by Alejandro Gispert in 2015",
                    "“Spor av Dråper og Røde Nebb”\nThis performance is an offer through The Norwegian Cultural program for students in grades 1-7, " +
                            "It builds on the theme around being different and unique.",
                    "“Duo Ale & Patricia” \nBeautiful presentations of cuban traditional music for all ages but especially the elders.",
                    "“Private Lessons” \nDo you need help to come forward. This is the place for you, regardless of age, gender and level. " +
                            "The teaching takes place individually."};

    //String colorname = "white";
    int[] numberImage = {R.drawable.cubanspec, R.drawable.ext, R.drawable.aleypatriciaduo, R.drawable.alebass2};


    // Spannable spannable = SpannableUtil.setSpanCustomText(this, MESSAGE,0)
    //invento bbold
    // SpannableString ss = new SpannableString ("spectrum");
    //StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
    //ss = (boldSpan, 1, 19,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    // ForegroundColorSpan fcswhite = new ForegroundColorSpan(Color.WHITE);
    // ss.setSpan(fcswhite, 12, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    // numberWord.setgridView(ss);


    private Button btn1;
    private Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina1);


        gridView = findViewById(R.id.lamalla);

        btn1 = findViewById(R.id.buttonabout);
        btn2 = findViewById(R.id.invisiblebutton3);

        //aqui viene el lio de animacion

        ImageView imageView = findViewById(R.id.mediumheader);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
//hasta aqui


//adaptadorgrid

        //mi invento onclick, pero es on create
//@Override
//public void onCreate (Bundle savedInstanceState) {
        MainAdapter adapter = new MainAdapter(pagina1.this, numberWord, numberImage);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You Clicked: " + numberWord[+
                        position], Toast.LENGTH_SHORT).show();


            }
        });

        //hasta aqui

//forma1 de resolver esta situacion
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten1 = new Intent(pagina1.this, pagina2.class);
                startActivity(inten1);
            }
        });
//forma2 de crear un boton
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpagina3();
            }

        });
    }

    public void openpagina3() {
        Intent inten2 = new Intent(pagina1.this, pagina3.class);
        startActivity(inten2);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    //boton a pagina web
    public void MyWeb2(View View) {
        openUrl("https://alejandrogispert.com/contact/");
    }

    public void openUrl(String url) {
        Uri uri = Uri.parse(url);
        Intent launchWeb = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchWeb);


    }
}