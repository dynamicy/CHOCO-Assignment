package com.example.chris.chocoassignment.core.common.model;

import java.io.Serializable;

/**
 * Title: com.example.chris.chocoassignment.core.common.model.DramaData<br>
 * Description: DramaData
 *
 * @author chris
 * @version 1.0
 */
public class DramaData implements Serializable {

    // 戲劇資訊
    private Drama[] data;

    public Drama[] getData() {
        return data;
    }

    public void setData(Drama[] data) {
        this.data = data;
    }
}
