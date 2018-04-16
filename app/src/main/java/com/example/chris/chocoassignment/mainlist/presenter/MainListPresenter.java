package com.example.chris.chocoassignment.mainlist.presenter;

import android.content.Context;
import android.util.Log;

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
 * Description: MainListPresenter, 需要儲存前次抓取結果，
 * 讓這個頁面可以在離線狀態進入 App 也能觀看。需有依照部分劇名
 * 過濾出含有關鍵字的戲劇且 App 在離開後下次開啟依然可顯示在上次
 * 搜尋後的狀態。請在整個搜尋戲劇流程操作上盡量優化使用體驗。
 *
 * @author chris
 * @version 1.0
 */
public class MainListPresenter implements ResponseListener<DramaData> {

    private static final String TAG = MainListPresenter.class.getSimpleName();

    private DramaInforService dramaInforService;
    private IMainListView view;

    // Init
    public MainListPresenter(IMainListView view) {
        this.dramaInforService = new DramaInforService();
        this.view = view;
    }

    /**
     * Fetch drama info list, 列表要有該劇的名稱 (name)、評分 (rating)、出版日期 (created_at)、縮圖(thumb)
     */
    public void fetchDramaInfoList() {
        // fetch drama info
        dramaInforService.queryDramaInfo(this);
    }

    /**
     * Search data from db
     *
     * @param context context
     * @param keyWord String
     * @return Drama[]
     */
    public List<Drama> searchFromDbByKeyword(Context context, String keyWord) {
        AppDataBase db = AppDataBase.getInstance(context);

        List<DramaEntity> dramaEntityList = db.dramaDao().searchDramaByKeyWord(keyWord);

        List<Drama> dramaList = new ArrayList<>();
        for (DramaEntity dramaEntity : dramaEntityList) {
            Drama drama = entityToModel(dramaEntity);
            dramaList.add(drama);
        }

        return dramaList;
    }

    /**
     * Save data to db
     *
     * @param context   context
     * @param dramaList List<Drama>
     */
    public void saveToRoomDb(Context context, List<Drama> dramaList) {
        AppDataBase db = AppDataBase.getInstance(context);

        List<DramaEntity> dramaEntityList = new ArrayList<>();
        for (Drama drama : dramaList) {
            DramaEntity dramaEntity = modelToEntity(drama);
            dramaEntityList.add(dramaEntity);
        }

        db.dramaDao().insertAll(dramaEntityList);
    }

    /**
     * Load data from db
     *
     * @param context context
     * @return List<Drama>
     */
    public List<Drama> loadDataFromRoomDb(Context context) {
        AppDataBase db = AppDataBase.getInstance(context);
        List<DramaEntity> dramaEntityList = db.dramaDao().getAll();

        List<Drama> dramaList = new ArrayList<>();
        for (DramaEntity dramaEntity : dramaEntityList) {
            Drama drama = entityToModel(dramaEntity);
            dramaList.add(drama);
        }

        return dramaList;
    }

    @Override
    public void onResponse(DramaData dramaData) {

        List<Drama> dramaList = Arrays.asList(dramaData.getData());

        // db
        saveToRoomDb((Context) view, dramaList);

        view.showMainList();
    }

    @Override
    public void onError(Throwable t) {
        Log.e(TAG, "[onError] ", t);

        view.showMainList();
    }

    /**
     * DramaEntity -> Drama
     *
     * @param dramaEntity DramaEntity
     * @return Drama
     */
    private Drama entityToModel(DramaEntity dramaEntity) {
        Drama drama = new Drama();
        drama.setTotalViews(dramaEntity.getTotalViews());
        drama.setThumb(dramaEntity.getThumb());
        drama.setRating(dramaEntity.getRating());
        drama.setName(dramaEntity.getName());
        drama.setDramaId(dramaEntity.getDramaId());
        drama.setCreatedAt(dramaEntity.getCreatedAt());
        return drama;
    }

    /**
     * Drama -> DramaEntity
     *
     * @param drama Drama
     * @return DramaEntity
     */
    private DramaEntity modelToEntity(Drama drama) {
        DramaEntity dramaEntity = new DramaEntity();
        dramaEntity.setCreatedAt(drama.getCreatedAt());
        dramaEntity.setDramaId(drama.getDramaId());
        dramaEntity.setName(drama.getName());
        dramaEntity.setRating(drama.getRating());
        dramaEntity.setThumb(drama.getThumb());
        dramaEntity.setTotalViews(drama.getTotalViews());
        return dramaEntity;
    }
}


