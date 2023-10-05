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

    public String getEmail(){
        return prefs.getString("email","");
    }

    public void setEmail(String email){
        prefs.edit().putString("email",email).apply();
    }

    public String getPhone(){
        return prefs.getString("phone","");
    }

    public void setPhone(String phone){
        prefs.edit().putString("phone",phone).apply();
    }
}
