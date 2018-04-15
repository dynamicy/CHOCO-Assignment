package com.example.chris.chocoassignment.data.db.converter;

import android.arch.persistence.room.TypeConverter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Title: com.example.chris.chocoassignment.data.db.converter.ConversionFactory<br>
 * Description: ConversionFactory
 *
 * @author chris
 * @version 1.0
 */
public class ConversionFactory {

    @TypeConverter
    public Date toDate(Long timeStamp) {
        return timeStamp == null ? null : new Date(timeStamp);
    }

    @TypeConverter
    public Long toTimeStamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public BigDecimal toBigDecimal(String value) {
        return value == null ? null : new BigDecimal(value);
    }

    @TypeConverter
    public String toString(BigDecimal data) {
        return data == null ? null : data.toString();
    }
}
