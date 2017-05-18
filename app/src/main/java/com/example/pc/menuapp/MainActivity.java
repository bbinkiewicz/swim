package com.example.pc.menuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mMenu;
    private TextView mSubmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMenu = (TextView) findViewById(R.id.tv_menu);
        mSubmenu = (TextView) findViewById(R.id.tv_submenu);
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
