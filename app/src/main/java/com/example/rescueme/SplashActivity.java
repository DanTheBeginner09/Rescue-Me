package com.example.rescueme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent to start the main activity
                Intent Intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(Intent);
                finish(); // Close the splash activity so it's not accessible after the main activity starts
            }
        }, SPLASH_DELAY);
    }
}