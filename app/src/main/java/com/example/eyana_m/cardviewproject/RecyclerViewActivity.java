package com.example.eyana_m.cardviewproject;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Person> persons;
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.bringToFront();

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        persons = new ArrayList<>();

        //must get data from database
        //this are just samples
        //photo size is not automatically optimized
        persons.add(new Person("James Dean", "Rebel Without A Cause", R.drawable.jamesdean));
        persons.add(new Person("Cary Grant", "North by Northwest", R.drawable.cary));
        persons.add(new Person("Marlon Brando", "A Streetcar Named Desire", R.drawable.marlonb));
        persons.add(new Person("Robert de Niro", "Taxi Driver", R.drawable.deniro));
        persons.add(new Person("Al Pacino", "Scarface", R.drawable.alpacino));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);

        rv.setAdapter(adapter);
    }


    

}
