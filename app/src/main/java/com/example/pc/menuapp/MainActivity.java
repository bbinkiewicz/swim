package com.example.pc.menuapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mMenu;
    private TextView mSubmenu;
    private Button mSecondActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMenu = (TextView) findViewById(R.id.tv_menu);
        mSubmenu = (TextView) findViewById(R.id.tv_submenu);

        registerForContextMenu(mMenu);
        registerForContextMenu(mSubmenu);
        mSecondActivityButton = (Button) findViewById(R.id.second_activity_btn);
        mSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.equals(mMenu)) {
            getMenuInflater().inflate(R.menu.context_menu, menu);
        }
        else if(v.equals(mSubmenu)){
            getMenuInflater().inflate(R.menu.context_submenu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {



        switch (item.getItemId()){
            case R.id.context_menu_delete:
                mMenu.setText(getString(R.string.blank_text));
                mMenu.setBackgroundColor(Color.TRANSPARENT);
                return true;
            case R.id.context_menu_highlight:
                mMenu.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.text_size_15:
                mSubmenu.setTextSize(15);
                return true;
            case R.id.text_size_35:
                mSubmenu.setTextSize(35);
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.menu_item_1:
            case R.id.menu_item_2:
            case R.id.menu_item_3:
                mMenu.setText(item.getTitle().toString());
                return true;
            case R.id.submenu_1:
            case R.id.submenu_2:
                mSubmenu.setText(item.getTitle());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
