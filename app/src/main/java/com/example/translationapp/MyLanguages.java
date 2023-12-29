package com.example.translationapp;

import java.util.ArrayList;

public class MyLanguages {

   private LanguageSelector lanSelector;

   MyLanguages(){
       lanSelector = new LanguageSelector();
   }

   public String languageCode(String lan){
      return lanSelector.getlanguageCode(lan);
   }

}
