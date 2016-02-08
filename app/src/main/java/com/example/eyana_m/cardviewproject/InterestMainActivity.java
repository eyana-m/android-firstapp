package com.example.eyana_m.cardviewproject;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InterestMainActivity extends AppCompatActivity {

    TextView interestName;
    ImageView interestPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_interest);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        interestName = (TextView)findViewById(R.id.interest_name);
        interestPhoto = (ImageView)findViewById(R.id.interest_photo);

        interestName.setText("Coffee");
        interestPhoto.setImageResource(R.drawable.interest_coffee2);
    }

}
