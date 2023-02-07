package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash_screen extends AppCompatActivity {

    protected static  int timer = 4000;
    ImageView imageView;
    TextView textView;
    Animation upperanimation, bottomanimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        imageView = findViewById(R.id.splashimage);
        textView = findViewById(R.id.splashtext);

        upperanimation= AnimationUtils.loadAnimation(this,R.anim.upper_animation);
        bottomanimation= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView.setAnimation(upperanimation);
        textView.setAnimation(bottomanimation);

        final Intent intent = new Intent(splash_screen.this, MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },timer);






    }
}