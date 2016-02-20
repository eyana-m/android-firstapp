package com.example.eyana_m.cardviewproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.view.Menu;
import android.view.MenuItem;

public class InterestActivity extends AppCompatActivity {

    private List<Interest> interests;
    private RecyclerView rv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_interest);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InterestActivity.this, "Add Interest Action", Toast.LENGTH_SHORT).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

       

        rv2=(RecyclerView)findViewById(R.id.rv2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

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

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    private void initializeData(){
        interests = new ArrayList<>();

        interests.add(new Interest("Coffee", R.drawable.interest_coffee2));
        interests.add(new Interest("Food", R.drawable.interest_food2));
        interests.add(new Interest("Fashion", R.drawable.interest_fashion));
        interests.add(new Interest("Technology", R.drawable.interest_tech));
    }

    private void initializeAdapter(){
        RV2Adapter adapter = new RV2Adapter(interests);
        rv2.setAdapter(adapter);
    }

}
