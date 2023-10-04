package com.example.bottom_bar.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionManager {
    private SharedPreferences prefs;

    public SessionManager(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setToken(String token){
        prefs.edit().putString("token",token).apply();
    }
    public String getToken(){
        return prefs.getString("token","");
    }
}
