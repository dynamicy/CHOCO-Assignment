package com.example.chris.chocoassignment.data.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.chris.chocoassignment.core.common.model.Drama;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Title: com.example.chris.chocoassignment.data.db.DramaEntity<br>
 * Description: DramaEntity
 *
 * @author chris
 * @version 1.0
 */
@Entity(tableName = DatabaseContract.TABLE_NAME)
public class DramaEntity {

    // ID
    @PrimaryKey
    private long dramaId;

    // 名稱 (name)
    private String name;

    // 觀看次數(total_views)
    private BigDecimal totalViews;

    // 出版日期 (created_at)
    private Date createdAt;

    // 縮圖(thumb)
    private String thumb;

    // 評分 (rating)
    private Double rating;

    public DramaEntity() {
    }

    public DramaEntity(long dramaId, String name, BigDecimal totalViews, Date createdAt, String thumb, Double rating) {
        this.dramaId = dramaId;
        this.name = name;
        this.totalViews = totalViews;
        this.createdAt = createdAt;
        this.thumb = thumb;
        this.rating = rating;
    }

    public DramaEntity(Drama drama) {
        this.dramaId = drama.getDramaId();
        this.name = drama.getName();
        this.totalViews = drama.getTotalViews();
        this.createdAt = drama.getCreatedAt();
        this.thumb = drama.getThumb();
        this.rating = drama.getRating();
    }

    public long getDramaId() {
        return dramaId;
    }

    public void setDramaId(long dramaId) {
        this.dramaId = dramaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(BigDecimal totalViews) {
        this.totalViews = totalViews;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
