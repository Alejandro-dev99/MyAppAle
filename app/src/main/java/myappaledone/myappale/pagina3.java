package myappaledone.myappale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import myappaledone.myappale.R;

import myappaledone.myappale.pagina1;

public class pagina3 extends AppCompatActivity {
  private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina3);


        Button btn = (Button) findViewById(R.id.invisiblebutton2);
        btn.setOnClickListener(new View.OnClickListener()   {

            @Override
            public void onClick(View v)   { openpagina1();
            }

        });
    }

    public void openpagina1() {
        Intent intent = new Intent(this, pagina1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void MycontactWeb (View View)
    {
        openUrl ("https://alejandrogispert.com/contact/");
    }
    public void openUrl(String url)
    {
        Uri uri=Uri.parse(url);
        Intent launchWeb=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(launchWeb);
    }

    public void MymusicsWeb (View View) { openUrl ("https://alejandrogispert.com/my-music/"); }
    public void MyprojectsWeb (View View) { openUrl ("https://alejandrogispert.com"); }
    public void MylearningWeb (View View) { openUrl ("https://alejandrogispert.com/undervisningen/"); }

};

//MymusicsWeb
//https://alejandrogispert.com/my-music/
//https://alejandrogispert.com