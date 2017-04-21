package com.example.pc.swimapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    }


    public void showSummary(View view) {
        GridLayout layout = (GridLayout) findViewById(R.id.grid_layout);
        StringBuffer message = new StringBuffer("checked buttons:");

        for (int i = 0; i < layout.getChildCount(); i++) {
            ToggleButton child = (ToggleButton) layout.getChildAt(i);

            if(child.isChecked()){
                message.append(child.getTag().toString());
                message.append(",");
            }
        }
        message.deleteCharAt(message.length()-1);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void backToMainActivity(View view) {
       finish();


    }
}
