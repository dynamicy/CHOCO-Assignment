package com.example.chris.chocoassignment.mainlist.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.chris.chocoassignment.R;
import com.example.chris.chocoassignment.core.common.model.Drama;
import com.example.chris.chocoassignment.core.common.model.DramaData;
import com.example.chris.chocoassignment.data.db.AppDataBase;
import com.example.chris.chocoassignment.data.db.DramaEntity;
import com.example.chris.chocoassignment.mainlist.presenter.MainListPresenter;
import com.example.chris.chocoassignment.mainlist.view.mainlist.MainListAdapter;
import com.example.chris.chocoassignment.mainlist.view.mainlist.OnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//import com.example.chris.chocoassignment.core.common.model.Drama;

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

        // db
        saveToRoomDb(getApplicationContext(), data);
    }

    @Override
    public void onItemClick(View v, int position) {

    }

    /**
     * Save data to room db
     *
     * @param context appContext
     * @param data    drama data
     */
    private void saveToRoomDb(Context context, DramaData data) {
        AppDataBase db = AppDataBase.getInstance(context);

        List<Drama> dramaList = Arrays.asList(data.getData());
        List<DramaEntity> dramaEntityList = new ArrayList<>();
        for (Drama drama : dramaList) {
            DramaEntity dramaEntity = new DramaEntity();
            dramaEntity.setCreated_at(drama.getCreated_at());
            dramaEntity.setDrama_id(drama.getDrama_id());
            dramaEntity.setName(drama.getName());
            dramaEntity.setRating(drama.getRating());
            dramaEntity.setThumb(drama.getThumb());
            dramaEntity.setTotal_views(drama.getTotal_views());
            dramaEntityList.add(dramaEntity);
        }

        db.dramaDao().insertAll(dramaEntityList);
    }
}
