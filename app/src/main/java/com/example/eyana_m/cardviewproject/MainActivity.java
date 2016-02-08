package com.example.eyana_m.cardviewproject;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView personName;
    TextView personFilm;
    ImageView personPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        personName = (TextView)findViewById(R.id.person_name);
        personFilm = (TextView)findViewById(R.id.person_film);
        personPhoto = (ImageView)findViewById(R.id.person_photo);

        personName.setText("James Dean");
        personFilm.setText("Rebel Without A Cause");
        personPhoto.setImageResource(R.drawable.jamesdean);
    }

}
