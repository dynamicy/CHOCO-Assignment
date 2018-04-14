package com.example.chris.chocoassignment.data;

import com.example.chris.chocoassignment.core.common.model.DramaData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Title: com.example.chris.chocoassignment.service.IDramaInfoResource<br>
 * Description: IDramaInfoResource
 *
 * @author chris
 * @version 1.0
 */
public interface IDramaInfoResource {

//    http://www.mocky.io/v2/5a97c59c30000047005c1ed2

    @GET("{id}")
    Call<DramaData> getDramaInfoList(@Path("id") String id);
}