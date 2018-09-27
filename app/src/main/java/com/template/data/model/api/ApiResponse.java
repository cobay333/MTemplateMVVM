package com.template.data.model.api;

public class ApiResponse<T> {


    public T data;

    public int status;
    public String error;
    public String message;
    public String exception;
    public String timestamp;
}


