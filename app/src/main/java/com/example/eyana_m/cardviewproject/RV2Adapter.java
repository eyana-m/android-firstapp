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

public class RV2Adapter extends RecyclerView.Adapter<RV2Adapter.InterestViewHolder>  {
    ArrayList<RVAdapter> data;

    public static class InterestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cv;
        TextView interestName;
        ImageView interestPhoto;

        InterestViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv2);
            interestName = (TextView)itemView.findViewById(R.id.interest_name);
            interestPhoto = (ImageView)itemView.findViewById(R.id.interest_photo);
            cv.setOnClickListener(this);
        }

        @Override
        public void onClick(View itemView) {

            String name = interestName.getText().toString();
            Bitmap image=((BitmapDrawable)interestPhoto.getDrawable()).getBitmap();

            Context mContext = itemView.getContext();

            String[] interestData = {
                    name
            };
            Toast.makeText(mContext, "You selected " + name, Toast.LENGTH_LONG).show();
//
//            Bundle mBundle =new Bundle();
//            mBundle.putStringArray("interestData", interestData);

            Intent intent = new Intent(mContext, ByInterestActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("photo", image);

            mContext.startActivity(intent);

        }

    }

    List<Interest> interests;

    RV2Adapter(List<Interest> interests){
        this.interests = interests;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public InterestViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.interest, viewGroup, false);
        final InterestViewHolder pvh = new InterestViewHolder(v);

        return pvh;
    }

    //the data is shown in the UI.
    @Override
    public void onBindViewHolder(InterestViewHolder interestViewHolder, int i) {
        interestViewHolder.interestName.setText(interests.get(i).name);
        interestViewHolder.interestPhoto.setImageResource(interests.get(i).photoId);


    }

    @Override
    public int getItemCount() {
        return interests.size();
    }


}
