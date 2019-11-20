package com.jgt.autotext.utils;

import android.app.Application;

public class AppContext extends Application {
    private static AppContext instance;

    public AppContext() {
        instance = this;
    }

    public static AppContext getContext() {
        return instance;
    }
}
