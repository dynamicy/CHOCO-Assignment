package com.example.chris.chocoassignment.detail.view;

import com.example.chris.chocoassignment.core.common.model.Drama;

/**
 * Title: com.example.chris.chocoassignment.detail.view.IDetailView<br>
 * Description: IDetailView
 *
 * @author chris
 * @version 1.0
 */
public interface IDetailView {

    /**
     * Show detail view
     *
     * @param data Drama
     */
    void showDetailView(Drama data);

    /**
     * No data display
     */
    void noDataDisplay();

    /**
     * With data display
     */
    void withDataDisplay();
}
