package com.example.translationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Locale;

public class Dashboard extends AppCompatActivity {
    private MultiAutoCompleteTextView userText;
    private View translateBtn;
    private TextView translatedText;
    private String result;
    private TextView sourcelan;
    private TextView targetlan;
    private TranslationServiceManager serviceManager;
    private  Clipboard clipboard;
    private MyLanguages languages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Removing default top header of application
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); //This line hide default header

        setContentView(R.layout.activity_dashboard);

        //All Intents
        Intent shutdownIntent = new Intent(Dashboard.this,MainActivity.class);


        //Initialize variables
        languages = new MyLanguages();

        // Getting User Input text box
        userText = findViewById(R.id.translatedtextbox);

        //Getting Translate Button through which
        //user can translate text
        translateBtn = findViewById(R.id.translatetextbtn);

        //Text View where translated text display
        translatedText = findViewById(R.id.translatedTextView);

        //Getting source language from source language textView
        sourcelan = findViewById(R.id.sourcelanguage);

        //Getting target language from target language textView
        targetlan = findViewById(R.id.targetlanguage);

        translateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = sourcelan.getText().toString();
                String target = targetlan.getText().toString();

                String sourceLanCode = languages.languageCode(source);
                String targetLanCode = languages.languageCode(target);

                createThread(sourceLanCode,targetLanCode,userText.getText().toString());
                translatedText.setText(result);
            }
        });

        clipboard = new Clipboard(Dashboard.this);

        //Implement CopyText Logic for userText
        ImageView usertxt = findViewById(R.id.usertxtCopy);
        CharSequence usertext_to_copy = userText.getText().toString();

        usertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usertext_to_copy != null && usertext_to_copy != " "){
                    clipboard.SaveToClipboard(usertext_to_copy);
                }
                else{
                    Toast.makeText(Dashboard.this, "Runnong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Implement CopyText Logic for Translated Text
        ImageView translatedtxt = findViewById(R.id.translatedtxtCopy);
        CharSequence transtext_to_copy = userText.getText().toString();

        translatedtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!((String) transtext_to_copy).isEmpty()){
                    clipboard.SaveToClipboard(transtext_to_copy);
                }
            }
        });

        //Implement Listen text logic for user text
        ImageView listenUserText = findViewById(R.id.usertextListen);
        TextListner listner = new TextListner(this);

        listenUserText.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String text = userText.getText().toString();
                    listner.speak(text);
             }
         });

        //Implement Listen text logic for translated text
        ImageView listenTransText = findViewById(R.id.translatedttxtListen);

        listenTransText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = translatedText.getText().toString();
                listner.speak(text);
            }
        });

        //Shut Down feature
        //User navigate to startup screen
        ImageView shutdown = findViewById(R.id.shutdownImg);
        shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(shutdownIntent);
            }
        });
    }

   public void createThread(String source,String target, String text){

       serviceManager = new TranslationServiceManager();

        new Thread(() -> {
            try {
                result = serviceManager.translateText(source, target, text);

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

