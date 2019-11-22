package com.jgt.autotext.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private static SharedPref instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SharedPref() {
        sharedPreferences = AppContext.getContext().getSharedPreferences(Constants.SHARED_PREF, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPref get() {
        if(null == instance) {
            synchronized (SharedPref.class) {
                instance = new SharedPref();
            }
        }
        return instance;
    }

    public void setSmsEnabled(boolean enabled) {
        editor.putBoolean(Constants.PREF_SMS_ENABLED, enabled);
        editor.commit();
    }

    public boolean getSmsEnabled() {
        return sharedPreferences.getBoolean(Constants.PREF_SMS_ENABLED, false);
    }
}
