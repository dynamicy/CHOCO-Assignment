package com.example.chris.chocoassignment.detail.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chris.chocoassignment.R;
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

    private final static String BUNDLE_KEY = "DATA";

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

    private DetailPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Butterknife
        ButterKnife.bind(this);

        // Init presenter
        presenter = new DetailPresenter(this);

        Intent intent = getIntent();
        String action = intent.getAction();

        if (null != action) {
            Uri intentData = intent.getData();
            String id = intentData.getQueryParameter("id");
            Drama data = presenter.getDramaById(getApplicationContext(), id);
            presenter.setDrama(data);
        } else {
            // Get bundle
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                Drama data = (Drama) bundle.getSerializable(BUNDLE_KEY);
                presenter.setDrama(data);
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.showDetail(presenter.getDrama());
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void showDetailView(Drama data) {
        nameTextView.setText(data.getName());
        createdAtTextView.setText(data.getCreatedAt().toString());
        ratingTextView.setText(String.valueOf(data.getRating()));
        totalViewsTextView.setText(String.valueOf(data.getTotalViews()));

        Glide.with(getBaseContext())
                .load(data.getThumb())
                .into(thumbTmageView);
    }
}
