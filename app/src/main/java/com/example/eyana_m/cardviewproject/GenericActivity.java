package com.example.eyana_m.cardviewproject;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v4.widget.DrawerLayout;


public class GenericActivity extends AppCompatActivity {

    public int photoId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }


        //Thanks http://stackoverflow.com/questions/4429036/passing-string-array-between-android-activities

        Intent intent = getIntent();

        Bundle mBundle = intent.getExtras();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");

        String[] personData= mBundle.getStringArray("personData");

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);

        TextView textView = (TextView) findViewById(R.id.person_name);
        textView.setTextSize(20);
        textView.setText(personData[0]);


        TextView textView2 = (TextView) findViewById(R.id.person_film);
        textView2.setTextSize(10);
        textView2.setText(personData[1]);

        ImageView imageView = (ImageView) findViewById(R.id.person_image);
        imageView.setImageBitmap(bitmap);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            return true;
        }
        return false;
    }
}
