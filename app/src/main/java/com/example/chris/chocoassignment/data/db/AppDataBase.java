package com.example.chris.chocoassignment.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.chris.chocoassignment.data.db.converter.ConversionFactory;
import com.example.chris.chocoassignment.data.db.dao.DramaDao;

import java.util.List;

/**
 * Title: com.example.chris.chocoassignment.data.db.AppDataBase<br>
 * Description: AppDataBase
 *
 * @author chris
 * @version 1.0
 */
@Database(entities = {DramaEntity.class}, version = 1, exportSchema = true)
@TypeConverters(ConversionFactory.class)
public abstract class AppDataBase extends RoomDatabase {

    // DB name
    private static final String DATABASE_NAME = "drama.db";

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
        return Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, DATABASE_NAME).allowMainThreadQueries().build();
    }

    /**
     * Insert data sets to db
     *
     * @param dataBase db
     * @param dramas   Drama[]
     */
    private static void insertData(final AppDataBase dataBase, final List<DramaEntity> dramas) {
        dataBase.runInTransaction(() -> {
            dataBase.dramaDao().insertAll(dramas);
        });
    }
}
