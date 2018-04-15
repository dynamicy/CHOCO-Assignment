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

    void showDetail(Drama data);

    Drama getDrama();

    void setDrama(Drama drama);
}
