package com.example.chris.chocoassignment.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Title: com.example.chris.chocoassignment.data.DramaResourceProvider<br>
 * Description: DramaResourceProvider
 *
 * @author chris
 * @version 1.0
 */
public class DramaResourceProvider {

    private static final String BASE_URL = "http://www.mocky.io/v2/";

    private DramaResourceProvider() {}

    private static class LazyHolder {
        private static final DramaResourceProvider INSTANCE = new DramaResourceProvider();
    }

    public static DramaResourceProvider getInstance() {
        return LazyHolder.INSTANCE;
    }

    public IDramaInfoResource getDramaResourceProvider() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(IDramaInfoResource.class);
    }
}
