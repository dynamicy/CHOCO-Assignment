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

    private DramaInfo[] data;

    public DramaInfo[] getData() {
        return data;
    }

    public void setData(DramaInfo[] data) {
        this.data = data;
    }
}
