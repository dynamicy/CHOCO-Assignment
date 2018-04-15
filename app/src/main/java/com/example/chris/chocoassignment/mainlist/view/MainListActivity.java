package com.example.chris.chocoassignment.mainlist.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chris.chocoassignment.R;
import com.example.chris.chocoassignment.core.common.model.Drama;
import com.example.chris.chocoassignment.detail.view.DetailActivity;
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

    private static final String BUNDLE_KEY = "DATA";

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
    public void gotoDetailActivity(Drama data) {
//        (1) 顯示該劇的縮圖 (thumb)、名稱 (name)、評分 (rating)、出版日期 (created_at)、觀看次數(total_views)
//        (2) 可讓瀏覽器或其他 App 透過 http://www.example.com/dramas/:id 當 :id 帶入 1 時，開啟資料中 drama_id 為 1 的戲劇。
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(BUNDLE_KEY, data);
        startActivity(intent);
    }

    @Override
    public void showMainList(Drama[] data) {
        // Recyclierview
        mainListAdapter = new MainListAdapter(data);
        mainListAdapter.setOnItemClickListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mainListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(Drama drama) {
        gotoDetailActivity(drama);
    }

}
