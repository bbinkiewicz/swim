package com.example.pc.swimapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class RelativeActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    SeekBar seekBar;
    RadioGroup radioGroup;
    Button responseButton;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        textView1 = (TextView) findViewById(R.id.text_view_1);
        textView2 = (TextView) findViewById(R.id.text_view_2);

        responseButton = (Button) findViewById(R.id.btn_response);
        responseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                if (bundle!=null){
                    result.putExtra("response", bundle.get("editText1").toString() + bundle.get("editText2").toString());
                }
                setResult(RESULT_OK, result);
                finish();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        showData();

    }

    private void showData(){
        Intent intent = getIntent();
        bundle = intent.getBundleExtra("bundle");

        if(bundle!=null) {
            if (!bundle.isEmpty()) {
               responseButton.setEnabled(true);
                textView1.setText(String.format(Locale.US,"odebrano: %s",bundle.get("editText1").toString()));
                textView2.setText(String.format(Locale.US,"odebrano: %s",bundle.get("editText2").toString()));
            }
        }
    }

    public void showSummary(View view){
        int id = radioGroup.getCheckedRadioButtonId();
        String message;
        RadioButton radioButton = (RadioButton) findViewById(id);
        message = "seek bar:" + seekBar.getProgress();

        if (radioButton != null) {
            message += ", radioGroup: " + radioButton.getText().toString();
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
