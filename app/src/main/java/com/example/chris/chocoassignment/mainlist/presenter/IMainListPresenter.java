package com.example.chris.chocoassignment.mainlist.presenter;

import android.content.Context;

import com.example.chris.chocoassignment.core.common.model.Drama;

/**
 * Title: com.example.chris.chocoassignment.mainlist.presenter.IMainListPresenter<br>
 * Description: IMainListPresenter
 *
 * @author chris
 * @version 1.0
 */
public interface IMainListPresenter {

//    需要儲存前次抓取結果，讓這個頁面可以在離線狀態進入 App 也能觀看。
//    需有依照部分劇名過濾出含有關鍵字的戲劇且 App 在離開後下次開啟依然可顯示在上次搜尋後的狀態。請在整個搜尋戲劇流程操作上盡量優化使用體驗。

    //    列表要有該劇的名稱 (name)、評分 (rating)、出版日期 (created_at)、縮圖(thumb)
    void fetchDramaInfoList();

    /**
     * Save data to db
     *
     * @param context context
     * @param data    DramaData
     */
    void saveToRoomDb(Context context, Drama[] data);

    /**
     * Load data from db
     *
     * @param context context
     * @return Drama[]
     */
    Drama[] loadDataFromRoomDb(Context context);
}
