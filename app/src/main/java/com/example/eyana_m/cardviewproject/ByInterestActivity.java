package com.example.eyana_m.cardviewproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ByInterestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_interest);


        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        Intent intent = getIntent();

        //Bundle mBundle = intent.getExtras();
        String name = intent.getStringExtra("name");
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");

        //String[] interestData= mBundle.getStringArray("interestData");

        TextView textView = (TextView) findViewById(R.id.interest_name);
        textView.setTextSize(20);
        textView.setText(name);


        ImageView imageView = (ImageView) findViewById(R.id.interest_image);
        imageView.setImageBitmap(bitmap);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
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
