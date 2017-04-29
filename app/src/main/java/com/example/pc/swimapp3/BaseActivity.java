package com.example.pc.swimapp3;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public abstract class BaseActivity extends AppCompatActivity {
    TextView header;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header = (TextView) findViewById(R.id.tv_header);


    }

    @Override
    protected void onResume() {
        super.onResume();
        loadPreferences();
    }

    protected void loadPreferences(){
        SharedPreferences pref = getSharedPreferences("appStyle", MODE_PRIVATE);
        int backgroundColor = pref.getInt(PreferencesName.BACKGROUND_COLOR, Color.WHITE);
        getWindow().getDecorView().setBackgroundColor(backgroundColor);


    }

}
