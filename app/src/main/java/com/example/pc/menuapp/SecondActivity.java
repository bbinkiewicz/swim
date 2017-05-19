package com.example.pc.menuapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private ImageView mStarImageView;
    private int checkedItem;
    private TextView mPlaceholder;

    private ActionMode.Callback mActionCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.contextual_action_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.context_menu_normal:
                    mPlaceholder.setTextSize(15);
                    return true;
                case R.id.context_menu_large:
                    mPlaceholder.setTextSize(25);
                    return true;
                default:
                    return false;
            }

        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mStarImageView = (ImageView) findViewById(R.id.star_image_view);
        checkedItem = R.id.star_1;
        mPlaceholder = (TextView) findViewById(R.id.second_activity_tv);
        registerForContextMenu(mStarImageView);
        mPlaceholder.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActionMode(mActionCallback);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, 1, 0, "Gray");
        menu.add(Menu.NONE, 2, 0, "Cyan");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 1:
                getWindow().getDecorView().setBackgroundColor(Color.GRAY);
                return true;
            case 2:
                getWindow().getDecorView().setBackgroundColor(Color.CYAN);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.star_context_menu, menu);

        for (int i = 0; i < menu.size(); ++i) {
            MenuItem mi = menu.getItem(i);

            if (mi.getItemId() == checkedItem) {
                mi.setChecked(true);
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        item.setChecked(!item.isChecked());
        checkedItem = item.getItemId();
        switch (checkedItem){
            case R.id.star_1:
                    mStarImageView.setImageDrawable(getDrawable(android.R.drawable.star_big_on));
                return true;
            case R.id.star_2:
                mStarImageView.setImageDrawable(getDrawable(android.R.drawable.star_big_off));
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}
