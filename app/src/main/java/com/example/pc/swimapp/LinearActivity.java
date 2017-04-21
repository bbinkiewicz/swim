package com.example.pc.swimapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Locale;

public class LinearActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    private final int REQ_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        editText1 = (EditText) findViewById(R.id.edit_text_1);
        editText2 = (EditText) findViewById(R.id.edit_text_2);
    }

    public void showSummary(View view) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.edit_texts_container);

        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);

            if (child instanceof EditText) {
               EditText text = ((EditText) child);
                Toast.makeText(this,String.format(Locale.US, " %s: %s",
                        text.getHint().toString(), text.getText().toString()),Toast.LENGTH_SHORT).show();
            }
            else if(child instanceof CheckBox){
                CheckBox checkBox = ((CheckBox) child);
                Toast.makeText(this, String.format(Locale.US, "%s:%b",
                        checkBox.getText().toString(), checkBox.isChecked()),Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void sendData(View view){
        Bundle bundle = new Bundle();
        Intent intent = new Intent(Intent.ACTION_PICK);
        bundle.putString("editText1", editText1.getText().toString());
        bundle.putString("editText2", editText2.getText().toString());

        intent.putExtra("bundle", bundle);
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this, String.format("po modyfikacji: %s",
                    (String) data.getExtras().get("response")), Toast.LENGTH_LONG).show();
        }
    }

    public void backToMainActivity(View view) {
        finish();
    }
}
