package com.example.chris.chocoassignment.detail.presenter;

import android.content.Context;

import com.example.chris.chocoassignment.core.common.model.Drama;
import com.example.chris.chocoassignment.data.db.AppDataBase;
import com.example.chris.chocoassignment.data.db.DramaEntity;
import com.example.chris.chocoassignment.detail.view.IDetailView;

/**
 * Title: com.example.chris.chocoassignment.detail.presenter.DetailPresenter<br>
 * Description: DetailPresenter
 *
 * @author chris
 * @version 1.0
 */
public class DetailPresenter {

    private IDetailView view;

    private Drama drama;

    public DetailPresenter(IDetailView view) {
        this.view = view;
    }

    /**
     * Show drama detail
     *
     * @param data Drama
     */
    public void showDetail(Drama data) {
        view.showDetailView(data);
    }

    /**
     * Get drama data
     *
     * @return Drama
     */
    public Drama getDrama() {
        return drama;
    }

    /**
     * Set drama data
     *
     * @param drama Drama
     */
    public void setDrama(Drama drama) {
        this.drama = drama;
    }

    /**
     * Get data by id
     *
     * @param context context
     * @param id      id
     * @return drama
     */
    public Drama getDramaById(Context context, String id) {
        AppDataBase db = AppDataBase.getInstance(context);

        DramaEntity dramaEntity = db.dramaDao().getDataById(id);

        if (dramaEntity != null) {
            Drama drama = new Drama();
            drama.setTotalViews(dramaEntity.getTotalViews());
            drama.setThumb(dramaEntity.getThumb());
            drama.setRating(dramaEntity.getRating());
            drama.setName(dramaEntity.getName());
            drama.setDramaId(dramaEntity.getDramaId());
            drama.setCreatedAt(dramaEntity.getCreatedAt());
            return drama;
        } else {
            return null;
        }
    }
}
