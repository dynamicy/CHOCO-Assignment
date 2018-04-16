package com.example.chris.chocoassignment.service;

import com.example.chris.chocoassignment.core.common.model.DramaData;
import com.example.chris.chocoassignment.service.common.ResponseListener;

/**
 * Title: com.example.chris.chocoassignment.service.IDamaInfoService<br>
 * Description: IDamaInfoService
 *
 * @author chris
 * @version 1.0
 */
public interface IDamaInfoService {

    /**
     * Query drama info
     *
     * @param listener ResponseListener
     */
    void queryDramaInfo(ResponseListener<DramaData> listener);
}
