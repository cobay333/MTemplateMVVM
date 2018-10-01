package com.template.data.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Resource<T> {
    @Nullable
    public final T data;
    @Nullable
    public final String message;
    public final int code;
    @NonNull
    private final Status status;

    private Resource(@NonNull Status status, @Nullable T data, @Nullable String message, int code) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(Status.SUCCESS, data, null, 0);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data, int code) {
        return new Resource<>(Status.ERROR, data, msg, code);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(Status.LOADING, data, null, 0);
    }

    public boolean isSuccess() {
        return status == Status.SUCCESS;
    }

    public boolean isLoading() {
        return status == Status.LOADING;
    }
}