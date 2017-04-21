package com.example.pc.swimapp2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

import static android.provider.AlarmClock.ACTION_SHOW_ALARMS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    final String ACTION_NAME = "com.example.action.START";
    Button launchButton;
    Button findLocationButton;
    ImageButton dialButton;
    Button showAlarmsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchButton = (Button) findViewById(R.id.launch_btn);
        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(ACTION_NAME);
                startActivity(intent);

            }
        });

        findLocationButton = (Button) findViewById(R.id.find_location_btn);
        dialButton = (ImageButton) findViewById(R.id.call_btn);
        showAlarmsButton = (Button) findViewById(R.id.show_alarms_btn);
        showAlarmsButton.setOnClickListener(this);
        findLocationButton.setOnClickListener(this);
        dialButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.find_location_btn:
                findLocation();
                break;
            case R.id.call_btn:
                dialNumber();
                break;
            case R.id.show_alarms_btn:
                displayAlarms();
                break;
        }
    }

    private void findLocation(){
        EditText latitude = (EditText) findViewById(R.id.latitude);
        EditText longitude = (EditText) findViewById(R.id.longitude);
        String geo = String.format(Locale.US, "geo:%s,%s", latitude.getText().toString(),longitude.getText().toString());
        Uri uri = Uri.parse(geo);

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }


    private void dialNumber(){
        EditText number = (EditText) findViewById(R.id.phone_number);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number.getText().toString()));

            startActivity(intent);

    }

    private void displayAlarms() {
        Intent intent = new Intent(ACTION_SHOW_ALARMS);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy called", Toast.LENGTH_SHORT).show();
    }
}
