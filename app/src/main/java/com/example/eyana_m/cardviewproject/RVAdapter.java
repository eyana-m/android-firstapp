package com.example.eyana_m.cardviewproject;

import android.content.Intent;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {
    ArrayList<RVAdapter> data;

    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cv;
        TextView personName;
        TextView personFilm;
        ImageView personPhoto;

        //Card attributed
        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personFilm = (TextView)itemView.findViewById(R.id.person_film);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            cv.setOnClickListener(this);

        }


        @Override
        public void onClick(View itemView) {


            //personName = (TextView)itemView.findViewById(R.id.person_name);
            String name = personName.getText().toString();
            String film = personFilm.getText().toString();
            Bitmap image=((BitmapDrawable)personPhoto.getDrawable()).getBitmap();


            Context mContext = itemView.getContext();



            String[] personData = {
                    name,
                    film
            };
            Toast.makeText(mContext, "You selected " + name + " from " + film, Toast.LENGTH_LONG).show();

            Bundle mBundle =new Bundle();
            mBundle.putStringArray("personData", personData);



            Intent intent = new Intent(mContext, GenericActivity.class);
            intent.putExtras(mBundle);
            intent.putExtra("photo", image);



            mContext.startActivity(intent);






        }
    }

    List<Person> persons;

    RVAdapter(List<Person> persons){
        this.persons = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        final PersonViewHolder pvh = new PersonViewHolder(v);

        return pvh;
    }

    //the data is shown in the UI.
    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personFilm.setText(persons.get(i).film);
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);


    }

    @Override
    public int getItemCount() {
        return persons.size();
    }


}

