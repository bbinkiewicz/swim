package com.example.pc.swimapp3;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pc.swimapp3.beans.ListItem;
import com.example.pc.swimapp3.utils.FileManager;

import es.dmoral.coloromatic.ColorOMaticDialog;
import es.dmoral.coloromatic.IndicatorMode;
import es.dmoral.coloromatic.OnColorSelectedListener;
import es.dmoral.coloromatic.colormode.ColorMode;

public class PickerActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    Button mApplyButton;
    Button mChangeHeaderColorButton;
    Button mChangeHeaderSizeButton;
    Button mChangeBgColorButton;
    Button mChangeHeader;
    ArrayAdapter<CharSequence> mAdapter;
    SharedPreferences pref;
    EditText mHeaderEt;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        mChangeBgColorButton = (Button) findViewById(R.id.btn_bg_color);
        mChangeBgColorButton.setOnClickListener(this);
        mChangeHeaderColorButton = (Button) findViewById(R.id.btn_text_color);
        mChangeHeaderColorButton.setOnClickListener(this);
        mChangeHeader = (Button) findViewById(R.id.btn_change_header);
        mChangeHeader.setOnClickListener(this);

        Spinner spinner = (Spinner) findViewById(R.id.text_size_spinner);
        mAdapter = ArrayAdapter.createFromResource(this,
                R.array.text_sizes_array, android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(mAdapter);

        pref = getSharedPreferences("appStyle", MODE_PRIVATE);

        String currentValue = Integer.toString(pref.getInt(PreferencesName.HEADER_SIZE, 10));
        if(!currentValue.equals(null)){
            int positionToSet = mAdapter.getPosition(currentValue);
            spinner.setSelection(positionToSet);
        }
        spinner.setOnItemSelectedListener(this);
        mApplyButton = (Button) findViewById(R.id.btn_applay);
        mApplyButton.setOnClickListener(this);
        mHeaderEt = (EditText) findViewById(R.id.et_header);
        mHeaderEt.setText(pref.getString(PreferencesName.HEADER_TEXT,"App3"));



    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.btn_applay:
                savePreferencesToFile();

                break;
            case R.id.btn_bg_color:
                showColorDialog(PreferencesName.BACKGROUND_COLOR);
                break;
            case R.id.btn_text_color:
                showColorDialog(PreferencesName.HEADER_COLOR);
                break;
            case R.id.btn_change_header:
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(PreferencesName.HEADER_TEXT, mHeaderEt.getText().toString());
                editor.apply();
                break;

        }
        loadPreferences();
    }
    private void showColorDialog(final String name){
        new ColorOMaticDialog.Builder()
                .initialColor(Color.WHITE)
                .colorMode(ColorMode.RGB) // RGB, ARGB, HVS
                .indicatorMode(IndicatorMode.HEX) // HEX or DECIMAL; Note that using HSV with IndicatorMode.HEX is not recommended
                .onColorSelected(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(@ColorInt int color) {
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putInt(name, color);
                        editor.apply();
                        loadPreferences();

                    }
                })
                .showColorIndicator(true)
                .create()
                .show(getSupportFragmentManager(), "Dialog");

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        SharedPreferences.Editor editor = pref.edit();
        int size = Integer.parseInt(parent.getItemAtPosition(position).toString());
        editor.putInt(PreferencesName.HEADER_SIZE, size);
        editor.apply();
        loadPreferences();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void savePreferencesToFile(){
        FileManager fileManager = new FileManager(this);
        int headerColor = pref.getInt(PreferencesName.HEADER_COLOR, Color.BLACK);
        int backgroundColor = pref.getInt(PreferencesName.BACKGROUND_COLOR, Color.WHITE);
        int headerSize = pref.getInt(PreferencesName.HEADER_SIZE, 15);
        String headerText = pref.getString(PreferencesName.HEADER_TEXT, "SwimApp3");
        ListItem item = new ListItem(headerSize, backgroundColor, headerColor, headerText);
        fileManager.write(item);





    }
}
