package com.jgt.autotext.utils;

public class Utils {
    public static final String TAG = Utils.class.getSimpleName();

    private Utils() {}
    public static int getRowColCount(double a) {
        return (int) Math.ceil(Math.sqrt(a));
    }
}
