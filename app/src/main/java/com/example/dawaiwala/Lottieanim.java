package com.example.dawaiwala;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Lottieanim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottieanim);
        Thread thread = new Thread() {

            public void run() {
                try {
                    sleep(2000);

                } catch (Exception e) {
                    e.getStackTrace();
                } finally {
                    Intent intent = new Intent(Lottieanim.this, MyDose.class);

                    startActivity(intent);
                }
            }


        };
        thread.start();
    }
}