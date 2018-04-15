package com.example.chris.chocoassignment.mainlist.presenter;

import android.content.Context;

import com.example.chris.chocoassignment.core.common.model.Drama;
import com.example.chris.chocoassignment.core.common.model.DramaData;
import com.example.chris.chocoassignment.data.db.AppDataBase;
import com.example.chris.chocoassignment.data.db.DramaEntity;
import com.example.chris.chocoassignment.mainlist.view.IMainListView;
import com.example.chris.chocoassignment.service.DramaInforService;
import com.example.chris.chocoassignment.service.common.ResponseListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: com.example.chris.chocoassignment.mainlist.presenter.MainListPresenter<br>
 * Description: MainListPresenter
 *
 * @author chris
 * @version 1.0
 */
public class MainListPresenter implements IMainListPresenter, ResponseListener<DramaData> {

    private DramaInforService dramaInforService;
    private IMainListView view;

    // Init
    public MainListPresenter(IMainListView view) {
        this.dramaInforService = new DramaInforService();
        this.view = view;
    }

    @Override
    public void fetchDramaInfoList() {
        // fetch drama info
        dramaInforService.queryDramaInfo(this);
    }

    @Override
    public void saveToRoomDb(Context context, Drama[] data) {
        AppDataBase db = AppDataBase.getInstance(context);

        List<Drama> dramaList = Arrays.asList(data);
        List<DramaEntity> dramaEntityList = new ArrayList<>();
        for (Drama drama : dramaList) {
            DramaEntity dramaEntity = new DramaEntity();
            dramaEntity.setCreatedAt(drama.getCreatedAt());
            dramaEntity.setDramaId(drama.getDramaId());
            dramaEntity.setName(drama.getName());
            dramaEntity.setRating(drama.getRating());
            dramaEntity.setThumb(drama.getThumb());
            dramaEntity.setTotalViews(drama.getTotalViews());
            dramaEntityList.add(dramaEntity);
        }

        db.dramaDao().insertAll(dramaEntityList);
    }

    @Override
    public Drama[] loadDataFromRoomDb(Context context) {
        AppDataBase db = AppDataBase.getInstance(context);
        List<DramaEntity> dramaEntityList = db.dramaDao().getAll();

        List<Drama> dramaList = new ArrayList<>();
        for(DramaEntity dramaEntity : dramaEntityList) {
            Drama drama = new Drama();
            drama.setTotalViews(dramaEntity.getTotalViews());
            drama.setThumb(dramaEntity.getThumb());
            drama.setRating(dramaEntity.getRating());
            drama.setName(dramaEntity.getName());
            drama.setDramaId(dramaEntity.getDramaId());
            drama.setCreatedAt(dramaEntity.getCreatedAt());
            dramaList.add(drama);
        }

        Drama[] dramas = new Drama[dramaList.size()];

        return dramaList.toArray(dramas);
    }

    @Override
    public void onResponse(DramaData dramaData) {
        // db
        saveToRoomDb((Context) view, dramaData.getData());
        view.showMainList(dramaData.getData());
    }

    @Override
    public void onError(Throwable t) {
        Drama[] dramas = loadDataFromRoomDb((Context) view);
        view.showMainList(dramas);
    }
}


