package com.example.pc.swimapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pc.swimapp3.beans.ListItem;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;

    DialogShowListener mListener = new DialogShowListener() {
        @Override
        public void showDialog(ListItem item) {
            DialogShow dialogShow = new DialogShow();
            Bundle bundle = new Bundle();
            bundle.putSerializable("item", item);
            dialogShow.setArguments(bundle);
            dialogShow.show(getSupportFragmentManager(), "show");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView) findViewById(R.id.items_list_view);
        CustomizedListView adapter = new CustomizedListView(this, mListener);
        listView.setAdapter(adapter);
    }
}
