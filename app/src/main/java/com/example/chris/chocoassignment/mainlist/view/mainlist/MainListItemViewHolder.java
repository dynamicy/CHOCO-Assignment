package com.example.chris.chocoassignment.mainlist.view.mainlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chris.chocoassignment.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title: com.example.chris.chocoassignment.mainlist.view.mainlist.MainListItemViewHolder<br>
 * Description: MainListItemViewHolder
 *
 * @author chris
 * @version 1.0
 */
public class MainListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    // 名稱 (name)
    @BindView(R.id.nameTextView)
    TextView nameTextView;

    // 評分 (rating)
    @BindView(R.id.ratingTextView)
    TextView ratingTextView;

    // 出版日期 (created_at)
    @BindView(R.id.createdAtTextView)
    TextView createdAtTextView;

    // 縮圖(thumb)
    @BindView(R.id.thumbTmageView)
    ImageView thumbTmageView;

    MainListItemViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onClick(View v) {

    }
}

