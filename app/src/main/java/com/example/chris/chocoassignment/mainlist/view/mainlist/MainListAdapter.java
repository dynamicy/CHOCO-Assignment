package com.example.chris.chocoassignment.mainlist.view.mainlist;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.chris.chocoassignment.R;
import com.example.chris.chocoassignment.core.common.model.Drama;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Title: com.example.chris.chocoassignment.mainlist.view.mainlist.MainListAdapter<br>
 * Description: MainListAdapter
 *
 * @author chris
 * @version 1.0
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListItemViewHolder> {

    private OnItemClickListener onItemClickListener;

    private List<Drama> data = new ArrayList<>();

    @NonNull
    @Override
    public MainListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MainListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainListItemViewHolder holder, int position) {
        String name = data.get(position).getName();
        String rating = String.valueOf(data.get(position).getRating());
        Date date = data.get(position).getCreatedAt();
        String imgUrl = data.get(position).getThumb();

        holder.itemView.setOnClickListener(v -> {
            Drama drama = data.get(holder.getAdapterPosition());
            onItemClickListener.onItemClick(drama);
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
        return data.size();
    }

    public List<Drama> getData() {
        return data;
    }

    public void setData(List<Drama> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}

