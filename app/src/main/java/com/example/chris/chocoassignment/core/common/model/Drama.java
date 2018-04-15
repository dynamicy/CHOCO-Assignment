package com.example.chris.chocoassignment.core.common.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Title: com.example.chris.chocoassignment.core.http.common.Drama<br>
 * Description: Drama
 *
 * @author chris
 * @version 1.0
 */
public class Drama implements Serializable {

    // ID
    @SerializedName("drama_id")
    private long dramaId;

    // 名稱 (name)
    @SerializedName("name")
    private String name;

    // 觀看次數(total_views)
    @SerializedName("total_views")
    private BigDecimal totalViews;

    // 出版日期 (created_at)
    @SerializedName("created_at")
    private Date createdAt;

    // 縮圖(thumb)
    @SerializedName("thumb")
    private String thumb;

    // 評分 (rating)
    @SerializedName("rating")
    private Double rating;

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