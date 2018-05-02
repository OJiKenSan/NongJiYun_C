package com.example.lenovo.nongjiyun_c.Util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastMessage {
    public static void initToastMessage(String message, Context context) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
