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
public class DetailPresenter implements IDetailPresenter {

    private IDetailView view;

    private Drama drama;

    public DetailPresenter(IDetailView view) {
        this.view = view;
    }

    @Override
    public void showDetail(Drama data) {
        view.showDetailView(data);
    }

    public Drama getDrama() {
        return drama;
    }

    public void setDrama(Drama drama) {
        this.drama = drama;
    }
}
