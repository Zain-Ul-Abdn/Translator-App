package com.example.translationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LanguagesPage extends AppCompatActivity {
    private LanguagesListView lanlistview;
    private EditText searchText;
    private  ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Removing default top header of application
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); //This line hide default header

        setContentView(R.layout.activity_languages_page);

        ListView langList = findViewById(R.id.list1);
        searchText = findViewById(R.id.searchtxt);

        try {
            lanlistview = new LanguagesListView();
            if(lanlistview!=null){
                ArrayList<String> array = lanlistview.languagesList();
                String [] languages = array.toArray(new String[0]);

                 adapter = new ArrayAdapter<>(LanguagesPage.this, android.R.layout.simple_dropdown_item_1line, languages);
                langList.setAdapter(adapter);
            }
            else{
                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
            }

        }catch(Exception e){
            Toast.makeText(this, "I am failed", Toast.LENGTH_SHORT).show();
        }

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (LanguagesPage.this).adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}