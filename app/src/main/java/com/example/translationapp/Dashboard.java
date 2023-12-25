package com.example.translationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class Dashboard extends AppCompatActivity {
    private MultiAutoCompleteTextView userText;
    private View translateBtn;
    private TextView translatedText;
    private String result;
    TranslationServiceManager serviceManager = new TranslationServiceManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Removing default top header of application
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); //This line hide default header

        setContentView(R.layout.activity_dashboard);


        userText = findViewById(R.id.translatedtextbox);
        translateBtn  = findViewById(R.id.translatetextbtn);
        translatedText = findViewById(R.id.translatedTextView);

        translateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createThread();
                translatedText.setText(result);
            }
        });
    }

    public void createThread(){

        String sourceLanguage = "en";
        String targetLanguage = "ur";
        String textToTranslate = userText.getText().toString();


        new Thread(() -> {
            try {
                result = serviceManager.translateText(sourceLanguage, targetLanguage, textToTranslate);

                //Convert String to Json Object
                try {
                    String jsonString = result; // Your JSON string

                    JSONObject jsonObject = new JSONObject(jsonString);

                    //Get Nested Objects
                    JSONObject data = new JSONObject(jsonObject.getString("data"));
                    result = data.getString("translatedText");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
                // Handle any exceptions
            }
        }).start();
    }


    }

