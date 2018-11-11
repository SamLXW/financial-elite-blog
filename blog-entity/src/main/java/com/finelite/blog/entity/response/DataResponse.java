package com.finelite.blog.entity.response;

public class DataResponse<T> extends BaseResponse {

    private T value;

    public T getValue(){ return value; }

    public void setValue(T value){ this.value = value; }
}
