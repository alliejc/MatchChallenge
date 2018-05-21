package com.alisonjc.matchchallenge.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alisonjc.matchchallenge.R;
import com.alisonjc.matchchallenge.model.Datum;
import com.squareup.picasso.Picasso;


public class MatchViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView username;
    private TextView age;
    private TextView cityState;
    private TextView matchPercent;

    public MatchViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.user_image);
        username = itemView.findViewById(R.id.username_text);
        age = itemView.findViewById(R.id.age_text);
        cityState = itemView.findViewById(R.id.city_state_text);
        matchPercent = itemView.findViewById(R.id.percentage_text);
    }

    private String getCityStateString(Datum datum){
        StringBuilder builder = new StringBuilder();
        builder.append(datum.getCityName());
        builder.append(", ");
        builder.append(datum.getStateCode());

        return builder.toString();
    }

    public void onBind(Datum datum, View.OnClickListener listener){
        username.setText(datum.getUsername());
        age.setText(String.valueOf(datum.getAge()));
        cityState.setText(getCityStateString(datum));
        matchPercent.setText(String.valueOf(datum.getMatch()));
        Picasso.with(itemView.getContext())
                .load(datum.getPhoto().getBasePath()).error(R.drawable.ic_dot).into(imageView);

        listener.onClick(itemView);
    }
}
