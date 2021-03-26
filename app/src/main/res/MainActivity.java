package com.spectrum.manufactura;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


   private Button  a,h,c,d,e,f,g,a2;

   private SoundPool soundPool;
   private int sound_a, sound_h, sound_c, sound_d, sound_e, sound_f, sound_g, sound_a2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (Button) findViewById(R.id.a);
        h = (Button) findViewById(R.id.h);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        e = (Button) findViewById(R.id.e);
        f = (Button) findViewById(R.id.f);
        g = (Button) findViewById(R.id.g);
        a2 = (Button) findViewById(R.id.a2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        } else {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        sound_a = soundPool.load(this, R.raw.a, 1);
        sound_h = soundPool.load(this, R.raw.h,1);
        sound_c = soundPool.load(this, R.raw.c,1);
        sound_d = soundPool.load(this, R.raw.d,1);
        sound_e = soundPool.load(this, R.raw.e,1);
        sound_f = soundPool.load(this, R.raw.f,1);
        sound_g = soundPool.load(this, R.raw.g,1);
        sound_a2 = soundPool.load(this, R.raw.a2,1);


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_a, 1, 1, 0, 0, 1);

            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_h, 1, 1, 0, 0, 1);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_c, 1, 1, 0, 0, 1);

            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_d, 1, 1, 0, 0, 1);

            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_e, 1, 1, 0, 0, 1);

            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_f, 1, 1, 0, 0, 1);

            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_g, 1, 1, 0, 0, 1);

            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_a2, 1, 1, 0, 0, 1);

            }
        });

    }
}

























