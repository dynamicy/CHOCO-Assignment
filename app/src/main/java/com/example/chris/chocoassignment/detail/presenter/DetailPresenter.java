package com.example.chris.chocoassignment.detail.presenter;

import com.example.chris.chocoassignment.core.common.model.Drama;
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
}
