package com.example.chris.chocoassignment.mainlist.view;

import com.example.chris.chocoassignment.core.common.model.Drama;

import java.util.List;

/**
 * Title: com.example.chris.chocoassignment.mainlist.view.IMainListView<br>
 * Description: IMainListView
 *
 * @author chris
 * @version 1.0
 */
public interface IMainListView {

    /**
     * Go to detail activity
     *
     * @param data Drama
     */
    void gotoDetailActivity(Drama data);

    /**
     * Show list based on data
     *
     * @param data List<Drama>
     */
    void showMainList(List<Drama> data);

    /**
     * @return String
     */
    String getTextFromQueryEditText();
}
