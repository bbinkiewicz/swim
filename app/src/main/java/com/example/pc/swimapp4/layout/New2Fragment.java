package com.example.pc.swimapp4.layout;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.pc.swimapp4.R;

import java.util.Locale;

import static android.provider.AlarmClock.ACTION_SHOW_ALARMS;

/**
 * A simple {@link Fragment} subclass.
 */
public class New2Fragment extends Fragment implements View.OnClickListener {
    private View mRootView;
    private Button findLocationButton;
    private ImageButton dialButton;
    private Button showAlarmsButton;

    public New2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_new2, container, false);
        findLocationButton = (Button) mRootView.findViewById(R.id.find_location_btn);
        dialButton = (ImageButton) mRootView.findViewById(R.id.call_btn);
        showAlarmsButton = (Button) mRootView.findViewById(R.id.show_alarms_btn);
        showAlarmsButton.setOnClickListener(this);
        findLocationButton.setOnClickListener(this);
        dialButton.setOnClickListener(this);
        return mRootView;
    }

    private void findLocation(){
        EditText latitude = (EditText) mRootView.findViewById(R.id.latitude);
        EditText longitude = (EditText) mRootView.findViewById(R.id.longitude);
        String geo = String.format(Locale.US, "geo:%s,%s", latitude.getText().toString(),longitude.getText().toString());
        Uri uri = Uri.parse(geo);

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            startActivity(intent);

    }


    private void dialNumber(){
        EditText number = (EditText) mRootView.findViewById(R.id.phone_number);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number.getText().toString()));

        startActivity(intent);

    }

    private void displayAlarms() {
        Intent intent = new Intent(ACTION_SHOW_ALARMS);

            startActivity(intent);

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
}
