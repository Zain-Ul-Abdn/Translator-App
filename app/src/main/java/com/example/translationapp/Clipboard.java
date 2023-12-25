package com.example.translationapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class Clipboard {
    private static ClipboardManager clipboardManager;
    Clipboard(Context context){
        clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);

    }

    public static void SaveToClipboard(CharSequence text){
        try {

            if(!text.equals(" ")){
                ClipData clipData = ClipData.newPlainText("label", text);
                clipboardManager.setPrimaryClip(clipData);
            }
        }catch (Exception e){
            //hande exception
        }
    }

}
