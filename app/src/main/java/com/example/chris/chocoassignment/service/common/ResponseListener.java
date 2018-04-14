package com.example.chris.chocoassignment.service.common;

/**
 * Title: com.example.chris.chocoassignment.service.common.ResponseListener<br>
 * Description: ResponseListener
 *
 * @author chris
 * @version 1.0
 */
public interface ResponseListener<T> {

    void onResponse(T data);

    void onError(Throwable t);
}