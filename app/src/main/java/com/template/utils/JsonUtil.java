package com.template.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class JsonUtil {

    private static Gson mGson = new Gson();

    /**
     * serialize string data
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String serialize(T object) {
        return mGson.toJson(object);
    }

    /**
     * deserialize String data
     * @param json
     * @param clz
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T deserialize(String json, Class<T> clz) throws JsonSyntaxException {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        return mGson.fromJson(json, clz);
    }

    /**
     * deserialize json data
     * @param json
     * @param clz
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T deserialize(JsonObject json, Class<T> clz) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return mGson.fromJson(json, clz);
    }

    /**
     * deserialize  json data
     * @param json
     * @param type
     * @param <T>
     * @return data
     * @throws JsonSyntaxException
     */
    public static <T> T deserialize(String json, Type type) throws JsonSyntaxException {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        return mGson.fromJson(json, type);
    }

    /**
     * Convert string to array
     * @param s
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr);
    }


}
