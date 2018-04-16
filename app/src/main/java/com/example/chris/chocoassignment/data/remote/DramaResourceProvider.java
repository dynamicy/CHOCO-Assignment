package com.example.chris.chocoassignment.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Title: com.example.chris.chocoassignment.data.remote.DramaResourceProvider<br>
 * Description: DramaResourceProvider
 *
 * @author chris
 * @version 1.0
 */
public class DramaResourceProvider {

    private DramaResourceProvider() {
    }

    private static class LazyHolder {
        private static final DramaResourceProvider INSTANCE = new DramaResourceProvider();
    }

    public static DramaResourceProvider getInstance() {
        return LazyHolder.INSTANCE;
    }

    public IDramaInfoResource getDramaResourceProvider() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DramaResourceContract.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IDramaInfoResource.class);
    }
}
