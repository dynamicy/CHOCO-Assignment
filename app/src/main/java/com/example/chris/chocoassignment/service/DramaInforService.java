package com.example.chris.chocoassignment.service;

import android.support.annotation.NonNull;

import com.example.chris.chocoassignment.core.common.model.DramaData;
import com.example.chris.chocoassignment.data.remote.DramaResourceProvider;
import com.example.chris.chocoassignment.service.common.ResponseListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Title: com.example.chris.chocoassignment.service.DramaInforService<br>
 * Description: IDamaInfoService
 *
 * @author chris
 * @version 1.0
 */
public class DramaInforService implements IDamaInfoService {

    @Override
    public void queryDramaInfo(final ResponseListener<DramaData> listener) {
        Call<DramaData> call = DramaResourceProvider
                .getInstance()
                .getDramaResourceProvider()
                .getDramaInfoList("5a97c59c30000047005c1ed2");

        call.enqueue(new Callback<DramaData>() {
            @Override
            public void onResponse(@NonNull Call<DramaData> call, @NonNull Response<DramaData> response) {
                listener.onResponse(response.body());

            }

            @Override
            public void onFailure(@NonNull Call<DramaData> call, @NonNull Throwable t) {
                listener.onError(t);
            }
        });
    }
}

