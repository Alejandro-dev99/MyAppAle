package myappaledone.myappale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import myappaledone.myappale.R;

public class pagina2 extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina2);


        btn1 = findViewById(R.id.buttonportfolio2);
        btn2 = findViewById(R.id.invisiblebutton1);

        //aqui viene la animacion

        ImageView imageView = findViewById(R.id.mediumheader22);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        //hasta aqui

//forma1 de crear boton
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten1 = new Intent(pagina2.this, pagina1.class);
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
        Intent inten2 = new Intent(pagina2.this, pagina3.class);
        startActivity(inten2);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }

    //boton a pagina web
    public void MyWeb(View View) {
        openUrl("https://alejandrogispert.com/press-kit/");
    }

    public void openUrl(String url) {
        Uri uri = Uri.parse(url);
        Intent launchWeb = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchWeb);


    }

    ;
}




