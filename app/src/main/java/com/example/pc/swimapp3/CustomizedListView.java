package com.example.pc.swimapp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pc.swimapp3.beans.ListItem;
import com.example.pc.swimapp3.utils.FileManager;

import java.util.LinkedList;


public class CustomizedListView extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    DialogShowListener mListener;

    private LinkedList<ListItem> itemsList = new LinkedList<>();

    public CustomizedListView(Context context, DialogShowListener listener) {
        this.context = context;
        mListener = listener;
        update();

       inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final ListItem item = (ListItem) getItem(position);
        view = inflater.inflate(R.layout.item_row, null);

        TextView header = (TextView) view.findViewById(R.id.item_header);
        header.setText(item.getHeaderText());
        header.setTextColor(item.getHeaderColor());
        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.item_layout);
        layout.setBackgroundColor(item.getBackgroundColor());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.showDialog(item);
            }
        });
        return view;
    }

    private void update(){
        FileManager fileManager = new FileManager(context);
        itemsList = fileManager.read();
    }


}
