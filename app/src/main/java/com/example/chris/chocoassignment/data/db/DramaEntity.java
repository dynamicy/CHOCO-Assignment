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
@Entity(tableName = "drama")
public class DramaEntity {

    // ID
    @PrimaryKey
    private long drama_id;

    // 名稱 (name)
    private String name;

    // 觀看次數(total_views)
    private BigDecimal total_views;

    // 出版日期 (created_at)
    private Date created_at;

    // 縮圖(thumb)
    private String thumb;

    // 評分 (rating)
    private Double rating;

    public DramaEntity() {
    }

    public DramaEntity(long drama_id, String name, BigDecimal total_views, Date created_at, String thumb, Double rating) {
        this.drama_id = drama_id;
        this.name = name;
        this.total_views = total_views;
        this.created_at = created_at;
        this.thumb = thumb;
        this.rating = rating;
    }

    public DramaEntity(Drama drama) {
        this.drama_id = drama.getDrama_id();
        this.name = drama.getName();
        this.total_views = drama.getTotal_views();
        this.created_at = drama.getCreated_at();
        this.thumb = drama.getThumb();
        this.rating = drama.getRating();
    }

    public long getDrama_id() {
        return drama_id;
    }

    public void setDrama_id(long drama_id) {
        this.drama_id = drama_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotal_views() {
        return total_views;
    }

    public void setTotal_views(BigDecimal total_views) {
        this.total_views = total_views;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
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
