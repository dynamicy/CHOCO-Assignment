package com.example.chris.chocoassignment.detail.presenter;

import com.example.chris.chocoassignment.core.common.model.Drama;

/**
 * Title: com.example.chris.chocoassignment.detail.presenter.IDetailPresenter<br>
 * Description: IDetailPresenter
 *
 * @author chris
 * @version 1.0
 */
public interface IDetailPresenter {

    /**
     * Show drama detail
     *
     * @param data Drama
     */
    void showDetail(Drama data);

    /**
     * Get drama data
     *
     * @return Drama
     */
    Drama getDrama();

    /**
     * Set drama data
     *
     * @param drama Drama
     */
    void setDrama(Drama drama);
}
