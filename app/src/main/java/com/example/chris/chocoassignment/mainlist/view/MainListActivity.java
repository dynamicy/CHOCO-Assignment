package com.example.chris.chocoassignment.mainlist.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.chris.chocoassignment.R;
import com.example.chris.chocoassignment.core.common.model.DramaData;
import com.example.chris.chocoassignment.mainlist.presenter.MainListPresenter;
import com.example.chris.chocoassignment.mainlist.view.mainlist.MainListAdapter;
import com.example.chris.chocoassignment.mainlist.view.mainlist.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title: com.example.chris.chocoassignment.mainlist.view.MainListActivity<br>
 * Description: MainListActivity
 *
 * @author chris
 * @version 1.0
 */
public class MainListActivity extends AppCompatActivity implements IMainListView, OnItemClickListener {

    private static final String TAG = MainListActivity.class.getSimpleName();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private MainListPresenter presenter;
    private MainListAdapter mainListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Butterknife
        ButterKnife.bind(this);

        // Init presenter
        presenter = new MainListPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.fetchDramaInfoList();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void gotoDetailActivity() {
        // Intent to
    }

    @Override
    public void showMainList(DramaData data) {
        // Recyclierview
        mainListAdapter = new MainListAdapter(data);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mainListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(View v, int position) {

    }
}
