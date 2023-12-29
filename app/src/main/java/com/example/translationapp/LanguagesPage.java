package com.example.translationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LanguagesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Removing default top header of application
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); //This line hide default header

        setContentView(R.layout.activity_languages_page);

        String [] cities = {"Lahore","London"};

        LanguagesListView lanlistview = new LanguagesListView();
        ArrayList<String> languageslist = lanlistview.languagesList();

        String [] array = languageslist.toArray(new String[0]);

        ListView langList = findViewById(R.id.list1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LanguagesPage.this, android.R.layout.simple_dropdown_item_1line,cities);

        langList.setAdapter(adapter);
    }
}