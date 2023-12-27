package com.example.translationapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class Clipboard {
    private ClipboardManager clipboardManager;
    Clipboard(Context context){
        clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);

    }

    public void SaveToClipboard(CharSequence text){
        try {

            if(!text.equals(" ")){
                ClipData clipData = ClipData.newPlainText("User Text", text);
                clipboardManager.setPrimaryClip(clipData);
            }
        }catch (Exception e){
            //hande exception
        }
    }

}
