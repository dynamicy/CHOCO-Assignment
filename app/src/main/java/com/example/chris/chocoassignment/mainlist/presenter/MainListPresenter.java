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
public class MainListPresenter implements IMainListPresenter, ResponseListener {

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

    @Override
    public Drama[] loadDataFromRoomDb(Context context) {
        AppDataBase db = AppDataBase.getInstance(context);
        List<DramaEntity> dramaEntityList = db.dramaDao().getAll();

        List<Drama> dramaList = new ArrayList<>();
        for(DramaEntity dramaEntity : dramaEntityList) {
            Drama drama = new Drama();
            drama.setTotal_views(dramaEntity.getTotal_views());
            drama.setThumb(dramaEntity.getThumb());
            drama.setTotal_views(dramaEntity.getTotal_views());
            drama.setRating(dramaEntity.getRating());
            drama.setDrama_id(dramaEntity.getDrama_id());
            drama.setCreated_at(dramaEntity.getCreated_at());
            dramaList.add(drama);
        }

        Drama[] dramas = new Drama[dramaList.size()];

        return dramaList.toArray(dramas);
    }

    @Override
    public void onResponse(Object data) {
        DramaData dramaData = (DramaData) data;

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


