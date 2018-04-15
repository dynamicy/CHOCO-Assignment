package com.example.chris.chocoassignment.core.common.model;

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