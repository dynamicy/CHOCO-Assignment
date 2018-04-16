package com.example.chris.chocoassignment.detail.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chris.chocoassignment.R;
import com.example.chris.chocoassignment.core.common.constant.BundleKey;
import com.example.chris.chocoassignment.core.common.model.Drama;
import com.example.chris.chocoassignment.detail.presenter.DetailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title: com.example.chris.chocoassignment.detail.view.DetailActivity<br>
 * Description: DetailActivity
 *
 * @author chris
 * @version 1.0
 */
public class DetailActivity extends AppCompatActivity implements IDetailView {

    @BindView(R.id.nameTextView)
    TextView nameTextView;

    @BindView(R.id.createdAtTextView)
    TextView createdAtTextView;

    @BindView(R.id.ratingTextView)
    TextView ratingTextView;

    @BindView(R.id.totalViewsTextView)
    TextView totalViewsTextView;

    @BindView(R.id.thumbTmageView)
    ImageView thumbTmageView;

    @BindView(R.id.noDataHintTextView)
    TextView noDataHintTextView;

    private DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Butterknife
        ButterKnife.bind(this);

        // Init presenter
        presenter = new DetailPresenter(this);

        // Deep Links
        Intent intent = getIntent();
        String action = intent.getAction();

        if (null != action) {
            Uri intentData = intent.getData();
            if (intentData == null) {
                noDataDisplay();
            } else {
                String id = intentData.getQueryParameter("id");
                Drama data = presenter.getDramaById(getApplicationContext(), id);
                if (data == null) {
                    // Wrong id number
                    noDataDisplay();
                } else {
                    presenter.setDrama(data);
                    withDataDisplay();
                    presenter.showDetail(presenter.getDrama());
                }
            }
        } else {
            // Get bundle
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                Drama data = (Drama) bundle.getSerializable(BundleKey.DRAMA_BUNDLE);
                presenter.setDrama(data);
                withDataDisplay();
                presenter.showDetail(presenter.getDrama());
            }
        }

    }

    @Override
    public void showDetailView(Drama data) {

        nameTextView.setText(data.getName());

        createdAtTextView.setText(getString(R.string.created_at, data.getCreatedAt().toString()));

        ratingTextView.setText(getString(R.string.ratings, String.valueOf(data.getRating())));

        totalViewsTextView.setText(getString(R.string.total_views, String.valueOf(data.getTotalViews())));

        Glide.with(getBaseContext())
                .load(data.getThumb())
                .into(thumbTmageView);
    }

    @Override
    public void noDataDisplay() {
        noDataHintTextView.setVisibility(View.VISIBLE);
        nameTextView.setVisibility(View.INVISIBLE);
        createdAtTextView.setVisibility(View.INVISIBLE);
        ratingTextView.setVisibility(View.INVISIBLE);
        totalViewsTextView.setVisibility(View.INVISIBLE);
        thumbTmageView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void withDataDisplay() {
        noDataHintTextView.setVisibility(View.INVISIBLE);
        nameTextView.setVisibility(View.VISIBLE);
        createdAtTextView.setVisibility(View.VISIBLE);
        ratingTextView.setVisibility(View.VISIBLE);
        totalViewsTextView.setVisibility(View.VISIBLE);
        thumbTmageView.setVisibility(View.VISIBLE);
    }
}
