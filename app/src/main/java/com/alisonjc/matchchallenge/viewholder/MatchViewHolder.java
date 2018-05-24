package com.alisonjc.matchchallenge.viewholder;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alisonjc.matchchallenge.R;
import com.alisonjc.matchchallenge.model.Datum;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

public class MatchViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView username;
    private TextView age;
    private TextView cityState;
    private TextView matchPercent;
    private View layout;

    public MatchViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.user_image);
        username = itemView.findViewById(R.id.username_text);
        age = itemView.findViewById(R.id.age_text);
        cityState = itemView.findViewById(R.id.city_state_text);
        matchPercent = itemView.findViewById(R.id.percentage_text);
        layout = itemView.findViewById(R.id.clickable_layout);
    }

    public void onBind(Datum datum, View.OnClickListener listener){
        username.setText(datum.getUsername());
        age.setText(String.valueOf(datum.getAge()));
        cityState.setText(String.format("%s, %s", datum.getCityName(), datum.getStateCode()));
        matchPercent.setText(String.format("%s%% ", getPercentageString(datum.getMatch())));

        if(datum.getLiked()){
            layout.setSelected(true);
        } else {
            layout.setSelected(false);
        }

        Picasso.with(itemView.getContext())
                .load(datum.getPhoto().getThumbPaths().getLarge())
                .error(R.drawable.image_not_available)
                .into(imageView);


        itemView.setOnClickListener(listener);
    }

//    private void loadImage(Datum datum){
//        Glide.with(itemView.getContext())
//            .asBitmap()
//            .load(datum.getPhoto().getThumbPaths().getLarge())
//            .into(imageView);
//    }

    private String getPercentageString(Integer match){
        return String.valueOf(match / 100);
    }
}
