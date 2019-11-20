package com.jgt.autotext.sms;

import android.telephony.SmsManager;

public class AutoTextSmsManager {
    private static final String TAG = AutoTextSmsManager.class.getSimpleName();
    private static AutoTextSmsManager instance;

    public static AutoTextSmsManager getInstance() {
        if(null == instance) {
            synchronized (AutoTextSmsManager.class) {
                instance = new AutoTextSmsManager();
            }
        }
        return instance;
    }

    public void sendSms(String number, String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, message, null, null);
    }
}
