package com.alisonjc.matchchallenge.util;


import android.content.Context;
import android.content.SharedPreferences;

import com.alisonjc.matchchallenge.Constants;
import com.alisonjc.matchchallenge.model.Datum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SharedPrefHandler {

    public static void writeDatumToPrefs(Context context, Datum datum) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.SHARED_PREFS_MATCHES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        String json = serializeDatum(datum);
        editor.putString(Constants.SHARED_PREFS_DATUM, json).apply();
    }

    public static Datum readDatumFromPrefs(Context context) {
        SharedPreferences mPrefs = context.getSharedPreferences(Constants.SHARED_PREFS_MATCHES, Context.MODE_PRIVATE);
        return deserializeLocations(mPrefs.getString(Constants.SHARED_PREFS_DATUM, ""));
    }

    public static String serializeDatum(Datum list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    public static Datum deserializeLocations(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<Datum>() {}.getType());
    }
}
