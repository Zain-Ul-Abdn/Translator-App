package com.example.translationapp;

import java.util.ArrayList;
import java.util.HashMap;

public class LanguageSelector {
    //Language --> English
    //lan --> en

    private String sourcelan;
    private String targetlan;

    private HashMap<String,String> languageCodeMap = new HashMap<>();

    LanguageSelector(){
        sourcelan = "English";
        targetlan = "Urdu";
        languageCodeMap = new HashMap<>();
    }

    public String getSourcelan() {
        return sourcelan;
    }

    public void setSourcelan(String sourcelan) {
        this.sourcelan = sourcelan;
    }

    public String getTargetlan() {
        return targetlan;
    }

    public void setTargetlan(String targetlan) {
        this.targetlan = targetlan;
    }

    public void setLanguage(String language, String code){
        languageCodeMap.put(language,code);
    }


    public String getlanguageCode(String language){
        String languagecode = " ";

        for (String lang :languageCodeMap.keySet()
             ) {
                    if(lang.equals(language)){
                        languagecode = languageCodeMap.get(lang);
                    }
        }

        return  languagecode;
    }

    public ArrayList<String> listAllLanguages(){
        ArrayList<String> languages = new ArrayList<>();
        for (String language :
             languageCodeMap.keySet()  ) {
            languages.add(language);
        }
        return languages;
    }

}
