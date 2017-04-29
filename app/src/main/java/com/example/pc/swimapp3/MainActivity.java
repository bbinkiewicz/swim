package com.example.pc.swimapp3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
    private Button customizeButton;
    private TextView header;
    private ImageView backgroundColorView;
    private TextView textSizeView;
    private ImageView headerColorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header = (TextView) findViewById(R.id.tv_header);
        headerColorView = (ImageView) findViewById(R.id.view_text_color);
        textSizeView = (TextView) findViewById(R.id.tv_text_size);
        backgroundColorView = (ImageView) findViewById(R.id.view_background_color);
        customizeButton = (Button) findViewById(R.id.btn_customize);
        customizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PickerActivity.class);
                startActivity(intent);
            }
        });
       Button showListButton = (Button) findViewById(R.id.btn_show_list);
        showListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void loadPreferences() {
        super.loadPreferences();
        SharedPreferences pref = getSharedPreferences("appStyle", MODE_PRIVATE);
        int headerColor = pref.getInt(PreferencesName.HEADER_COLOR, Color.BLACK);
        int backgroundColor = pref.getInt(PreferencesName.BACKGROUND_COLOR, Color.WHITE);
        String status = pref.getString(PreferencesName.STATUS, "ACTIVE");
        String headerText = pref.getString(PreferencesName.HEADER_TEXT, "SwimApp3");


        header.setTextColor(headerColor);
        header.setText(headerText);
        headerColorView.setBackgroundColor(headerColor);
        textSizeView.setText(status);
        backgroundColorView.setBackgroundColor(backgroundColor);


    }
}
