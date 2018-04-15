package com.example.chris.chocoassignment.mainlist.view.mainlist;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.example.chris.chocoassignment.R;
import com.example.chris.chocoassignment.core.common.model.Drama;

import java.io.File;
import java.util.Date;

/**
 * Title: com.example.chris.chocoassignment.mainlist.view.mainlist.MainListAdapter<br>
 * Description: MainListAdapter
 *
 * @author chris
 * @version 1.0
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListItemViewHolder> {

    private OnItemClickListener onItemClickListener;

    private Drama[] data;

    public MainListAdapter(Drama[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MainListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MainListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainListItemViewHolder holder, int position) {
        String name = data[position].getName();
        String rating = data[position].getRating().toString();
        Date date = data[position].getCreated_at();
        String imgUrl = data[position].getThumb();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drama drama = data[holder.getAdapterPosition()];
                onItemClickListener.onItemClick(drama);
            }
        });

        holder.createdAtTextView.setText(date.toString());
        holder.nameTextView.setText(name);
        holder.ratingTextView.setText(rating);

        Glide.with(holder.thumbTmageView.getContext())
                .load(imgUrl)
                .into(holder.thumbTmageView);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public Drama[] getData() {
        return data;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}

