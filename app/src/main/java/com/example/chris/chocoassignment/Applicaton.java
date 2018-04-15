package com.example.chris.chocoassignment;

import android.app.Application;

import com.example.chris.chocoassignment.data.db.AppDataBase;

/**
 * Title: com.example.chris.chocoassignment.data.db.AppDataBase<br>
 * Description: AppDataBase
 *
 * @author chris
 * @version 1.0
 */
public class Applicaton extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Init db
        AppDataBase.getInstance(getApplicationContext());
    }
}
