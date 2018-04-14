package com.example.chris.chocoassignment.mainlist.view;

import com.example.chris.chocoassignment.core.common.model.DramaData;

/**
 * Title: com.example.chris.chocoassignment.mainlist.view.IMainListView<br>
 * Description: IMainListView
 *
 * @author chris
 * @version 1.0
 */
public interface IMainListView {

    // Go to detail activity
    void gotoDetailActivity();

    // Show list based on data
    void showMainList(DramaData data);

}
