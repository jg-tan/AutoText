package com.jgt.autotext.utils;

import com.jgt.autotext.BuildConfig;

public class Log {
    private static final boolean IS_DEBUG = BuildConfig.DEBUG;
    private static final String APPTAG = "AutoText :: ";

    public static void d(String tag, String message) {
        if(IS_DEBUG) {
            Log.d(tag, APPTAG + message);
        }
    }

    public static void i(String tag, String message) {
        Log.i(tag, APPTAG + message);
    }

    public static void v(String tag, String message) {
        Log.v(tag, APPTAG + message);
    }

    public static void e(String tag, String message, Throwable e) {
        Log.e(tag, APPTAG + message, e);
    }
}
