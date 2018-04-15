package com.example.chris.chocoassignment.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.chris.chocoassignment.data.db.DramaEntity;

import java.util.List;

/**
 * Title: com.example.chris.chocoassignment.data.db.dao.DramaDao<br>
 * Description: DramaDao
 *
 * @author chris
 * @version 1.0
 */
@Dao
public interface DramaDao {

    /**
     * Query all drama
     *
     * @return drama list
     */
    @Query("SELECT * FROM drama")
    List<DramaEntity> getAll();

    /**
     * Query drama by keyword
     *
     * @param keyWord '%keyword%'
     * @return drama list
     */
    @Query("SELECT * FROM drama WHERE name LIKE :keyWord")
    List<DramaEntity> searchDramaByKeyWord(String keyWord);

    /**
     * Insert drama data sets
     *
     * @param dramaEntityList list
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DramaEntity> dramaEntityList);
}
