package com.example.dawaiwala;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {



public FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);




        Thread thread=new Thread(){

            public void run(){
                try{
                    sleep(2000);

                }
                catch(Exception e)
                {
                    e.getStackTrace();
                }
                finally {
                    mAuth = FirebaseAuth.getInstance();
                    FirebaseUser currentUser = mAuth.getCurrentUser();
                    if (currentUser != null) {

                        Intent i = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(i);


                    } else {

                        Intent intent = new Intent(SplashScreen.this, SignupActivity.class);
                        startActivity(intent);

                    }

                }





            }




        };thread.start();








    }
}