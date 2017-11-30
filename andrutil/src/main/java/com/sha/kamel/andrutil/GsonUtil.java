package com.sha.kamel.andrutil;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Sha on 10/25/17.
 */

public final class GsonUtil {

    public static String toJson(Object object){
        Gson gson = new GsonBuilder().create();
       return gson.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> clazz){
        try {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(json, clazz);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
