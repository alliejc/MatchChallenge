package com.alisonjc.matchchallenge.util;


import android.content.Context;
import android.content.SharedPreferences;

import com.alisonjc.matchchallenge.model.Datum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class SharedPrefHandler {

    public static void writeDatumToPrefs(Context context, Datum datum) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.SHARED_PREFS_MATCHES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        String json = serializeDatum(datum);
        editor.putString(datum.getUserid(), json).apply();
    }

//    public static Datum readAllDatumFromPrefs(Context context) {
//        SharedPreferences mPrefs = context.getSharedPreferences(Constants.SHARED_PREFS_MATCHES, Context.MODE_PRIVATE);
//        return deserializeDatumList(mPrefs.getAll().toString());
//    }

    public static List<Datum> readDatumFromPrefs(Context context) {
        SharedPreferences mPrefs = context.getSharedPreferences(Constants.SHARED_PREFS_MATCHES, Context.MODE_PRIVATE);
        return deserializeDatumList(mPrefs.getString(Constants.SHARED_PREFS_DATUM, ""));
    }

    public static String serializeDatum(Datum datum) {
        Gson gson = new Gson();
        return gson.toJson(datum);
    }

    public static Datum deserializeDatum(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<Datum>() {}.getType());
    }

    public static List<Datum> deserializeDatumList(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<Datum>>() {}.getType());
    }
}
