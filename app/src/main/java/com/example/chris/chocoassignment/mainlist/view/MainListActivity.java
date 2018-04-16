package com.example.chris.chocoassignment.mainlist.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.chris.chocoassignment.R;
import com.example.chris.chocoassignment.core.common.constant.BundleKey;
import com.example.chris.chocoassignment.core.common.model.Drama;
import com.example.chris.chocoassignment.detail.view.DetailActivity;
import com.example.chris.chocoassignment.mainlist.presenter.MainListPresenter;
import com.example.chris.chocoassignment.mainlist.view.mainlist.MainListAdapter;
import com.example.chris.chocoassignment.mainlist.view.mainlist.OnItemClickListener;

import java.util.List;

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

    @BindView(R.id.queryEditText)
    EditText queryEditText;

    @BindView(R.id.noDataHintTextView)
    TextView noDataHintTextView;

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

        // Fetching data
        presenter.fetchDramaInfoList();

        // TextWatcher
        queryEditText.addTextChangedListener(textWatcher);

        initRecyclerView();

        if (savedInstanceState != null) {
            Log.i(TAG, "Restore savedInstanceState");

            String keyword = savedInstanceState.getString(BundleKey.KEYWORD_BUNDLE);

            queryEditText.setText(keyword);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        Log.i(TAG, "onSaveInstanceState");

        super.onSaveInstanceState(outState);

        outState.putString(BundleKey.KEYWORD_BUNDLE, getTextFromQueryEditText());
    }

    @Override
    public void gotoDetailActivity(Drama data) {
//        (1) 顯示該劇的縮圖 (thumb)、名稱 (name)、評分 (rating)、出版日期 (created_at)、觀看次數(total_views)
//        (2) 可讓瀏覽器或其他 App 透過 http://www.example.com/dramas/:id 當 :id 帶入 1 時，開啟資料中 drama_id 為 1 的戲劇。
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(BundleKey.DRAMA_BUNDLE, data);
        startActivity(intent);
    }

    @Override
    public void showMainList() {

        String keyword = "%" + getTextFromQueryEditText() + "%";

        List<Drama> dramas = presenter.searchFromDbByKeyword(getApplicationContext(), keyword);

        mainListAdapter.setData(dramas);

        if (dramas == null || dramas.size() == 0) {
            noDataHintTextView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        } else {
            noDataHintTextView.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public String getTextFromQueryEditText() {
        return queryEditText.getText() == null ? "" : queryEditText.getText().toString();
    }

    @Override
    public void onItemClick(Drama drama) {
        gotoDetailActivity(drama);
    }

    TextWatcher textWatcher = new TextWatcher() {
        String keyword = "";

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (null != s) {
                keyword = "%" + s.toString() + "%";

                List<Drama> dramas = presenter.searchFromDbByKeyword(getApplicationContext(), keyword);

                mainListAdapter.setData(dramas);

                if (dramas == null || dramas.size() == 0) {
                    noDataHintTextView.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.INVISIBLE);
                } else {
                    noDataHintTextView.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    /**
     * Init RecyclerView
     */
    private void initRecyclerView() {
        mainListAdapter = new MainListAdapter();
        mainListAdapter.setOnItemClickListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mainListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
