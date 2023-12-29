package com.example.translationapp;

import java.util.ArrayList;

public class LanguagesListView {
    private LanguageSelector myLanguages;
    String[] languages = {
            "Afrikaans", "Albanian", "Amharic", "Arabic", "Armenian", "Azerbaijani",
            "Basque", "Belarusian", "Bengali", "Bosnian", "Bulgarian", "Catalan",
            "Cebuano", "Chichewa", "Chinese (Simplified)", "Chinese (Traditional)",
            "Corsican", "Croatian", "Czech", "Danish", "Dutch",
            "English", "Esperanto", "Estonian", "Filipino", "Finnish", "French",
            "Frisian", "Galician", "Georgian", "German", "Greek", "Gujarati",
            "Haitian Creole", "Hausa", "Hawaiian", "Hebrew", "Hindi", "Hmong",
            "Hungarian", "Icelandic", "Igbo", "Indonesian", "Irish", "Italian",
            "Japanese", "Javanese", "Kannada", "Kazakh", "Khmer", "Kinyarwanda",
            "Korean", "Kurdish (Kurmanji)", "Kyrgyz", "Lao", "Latin", "Latvian",
            "Lithuanian", "Luxembourgish", "Macedonian", "Malagasy", "Malay",
            "Malayalam", "Maltese", "Maori", "Marathi", "Mongolian", "Myanmar (Burmese)",
            "Nepali", "Norwegian", "Odia (Oriya)", "Pashto", "Persian", "Polish",
            "Portuguese", "Punjabi", "Romanian", "Russian", "Samoan", "Scots Gaelic",
            "Serbian", "Sesotho", "Shona", "Sindhi", "Sinhala", "Slovak", "Slovenian",
            "Somali", "Spanish", "Sundanese", "Swahili", "Swedish", "Tajik", "Tamil",
            "Tatar", "Telugu", "Thai", "Turkish", "Turkmen", "Ukrainian", "Urdu",
            "Uyghur", "Uzbek", "Vietnamese", "Welsh", "Xhosa", "Yiddish", "Yoruba",
            "Zulu", "Hebrew", "Chinese (Simplified)"};
    private String [] langCode  =  {"af", "sq", "am", "ar", "hy", "az", "eu", "be", "bn", "bs", "bg", "ca",
            "ceb", "ny", "zh-CN", "zh-TW", "co", "hr", "cs", "da", "nl",
            "en", "eo", "et", "tl", "fi", "fr",
            "fy", "gl", "ka", "de", "el", "gu",
            "ht", "ha", "haw", "iw", "hi", "hmn",
            "hu", "is", "ig", "id", "ga", "it",
            "ja", "jw", "kn", "kk", "km", "rw",
            "ko", "ku", "ky", "lo", "la", "lv",
            "lt", "lb", "mk", "mg", "ms", "ml",
            "mt", "mi", "mr", "mn", "my", "ne",
            "no", "or", "ps", "fa", "pl", "pt",
            "pa", "ro", "ru", "sm", "gd", "sr",
            "st", "sn", "sd", "si", "sk", "sl",
            "so", "es", "su", "sw", "sv", "tg",
            "ta", "tt", "te", "th", "tr", "tk",
            "uk", "ur", "ug", "uz", "vi", "cy",
            "xh", "yi", "yo", "zu", "he", "zh"};

    LanguagesListView (){
        myLanguages = new LanguageSelector();
        AddLanguages();
    }

//    public String [] languagesList(){
//        String [] list  = myLanguages.listAllLanguages();
//        return list;
//    }

    public ArrayList<String> languagesList(){
        ArrayList<String> list;
        list = myLanguages.listAllLanguages();
        return list;
    }

    private void AddLanguages(){
        for (int i = 0; i < languages.length; i++) {
            myLanguages.setLanguage(languages[i],langCode[i]);
        }
    }
}
