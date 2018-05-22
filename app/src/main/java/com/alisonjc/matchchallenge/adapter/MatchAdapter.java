package com.alisonjc.matchchallenge.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alisonjc.matchchallenge.R;
import com.alisonjc.matchchallenge.callback.IMatchSelected;
import com.alisonjc.matchchallenge.model.Datum;
import com.alisonjc.matchchallenge.viewholder.MatchViewHolder;

import java.util.ArrayList;
import java.util.List;


public class MatchAdapter extends RecyclerView.Adapter<MatchViewHolder> {
    private List<Datum> mList = new ArrayList<Datum>();
    private IMatchSelected mListener;
    private Context mContext;

    public MatchAdapter(Context context, IMatchSelected listener) {
        mListener = listener;
        mContext = context;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final MatchViewHolder holder, int position) {
        final Datum datum = mList.get(holder.getAdapterPosition());
        holder.onBind(datum, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSelected(datum);
            }
        });
    }

    public void updateAdapter(List<Datum> list){
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }
}