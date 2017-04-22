package com.example.pc.swimapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button linearActivityButton;
    Button gridActivityButton;
    Button relativeActivityButton;
    Button newActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearActivityButton = (Button) findViewById(R.id.linear_activity);
        gridActivityButton = (Button) findViewById(R.id.grid_activity);
        relativeActivityButton = (Button) findViewById(R.id.relative_activity);
        newActivityButton = (Button) findViewById(R.id.new_activity);

        linearActivityButton.setOnClickListener(this);
        gridActivityButton.setOnClickListener(this);
        relativeActivityButton.setOnClickListener(this);
        newActivityButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.linear_activity:
                intent = new Intent(this, LinearActivity.class);
                break;

            case R.id.grid_activity:
                intent = new Intent(this, GridActivity.class);
                break;

            case R.id.relative_activity:
                intent = new Intent(this, RelativeActivity.class);
                break;

            case R.id.new_activity:
                intent = new Intent(this, NewActivity.class);
                break;

            default:
                intent = new Intent(this, MainActivity.class);
        }

        startActivity(intent);
    }
}
