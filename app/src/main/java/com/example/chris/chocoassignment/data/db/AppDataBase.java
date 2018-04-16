package com.example.chris.chocoassignment.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.chris.chocoassignment.data.db.converter.ConversionFactory;
import com.example.chris.chocoassignment.data.db.dao.DramaDao;

/**
 * Title: com.example.chris.chocoassignment.data.db.AppDataBase<br>
 * Description: AppDataBase
 *
 * @author chris
 * @version 1.0
 */
@Database(entities = {DramaEntity.class}, version = 1, exportSchema = false)
@TypeConverters(ConversionFactory.class)
public abstract class AppDataBase extends RoomDatabase {

    public abstract DramaDao dramaDao();

    /**
     * Get db instance
     *
     * @param context context
     * @return db instance
     */
    public static AppDataBase getInstance(Context context) {
        return buildDatabase(context);
    }

    /**
     * For creation
     *
     * @param context context
     * @return db instance
     */
    private static AppDataBase buildDatabase(final Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDataBase.class, DatabaseContract.DATABASE_NAME).allowMainThreadQueries().build();
    }
}
