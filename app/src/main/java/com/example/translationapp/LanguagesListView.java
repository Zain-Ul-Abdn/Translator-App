package com.example.translationapp;

import java.util.ArrayList;

public class LanguagesListView {
    private LanguageSelector myLanguages;
    private ArrayList<String> list = new ArrayList<>();

    private String [] languages = {"English","Urdu"};
    private String [] langCode  = {"en","ur"};

    private LanguageSelector lanSelector;

    LanguagesListView (){
        myLanguages = new LanguageSelector();
        AddLanguages();
    }

    public ArrayList<String> languagesList(){
        list = myLanguages.listAllLanguages();
        return list;
    }

    private void AddLanguages(){
        for (int i = 0; i < languages.length; i++) {
            lanSelector.setLanguage(languages[i],langCode[i]);
        }
    }
}
