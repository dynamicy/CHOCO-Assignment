package com.example.chris.chocoassignment.mainlist.presenter;

import com.example.chris.chocoassignment.core.common.model.DramaData;
import com.example.chris.chocoassignment.mainlist.view.IMainListView;
import com.example.chris.chocoassignment.service.DramaInforService;
import com.example.chris.chocoassignment.service.common.ResponseListener;

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
    public void checkDramaDetail() {

    }

    @Override
    public void fetchDramaInfoList() {
        // fetch drama info
        dramaInforService.queryDramaInfo(this);
    }


    @Override
    public void onResponse(Object data) {
        view.showMainList((DramaData) data);
    }

    @Override
    public void onError(Throwable t) {

    }
}


