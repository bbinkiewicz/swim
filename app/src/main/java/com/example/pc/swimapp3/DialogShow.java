package com.example.pc.swimapp3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.swimapp3.beans.ListItem;

import java.util.Locale;


public class DialogShow extends DialogFragment {
    Button closeButton;
    private ImageView backgroundColorView;
    private TextView textSizeView;
    private ImageView headerColorView;

    public DialogShow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialog_show, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backgroundColorView = (ImageView) view.findViewById(R.id.dialog_background_color);
        headerColorView = (ImageView) view.findViewById(R.id.dialog_text_color);
        textSizeView = (TextView) view.findViewById(R.id.dialog_text_size);

        Bundle bundle = getArguments();
        if(bundle.containsKey("item")){
            ListItem item = (ListItem) bundle.getSerializable("item");
            if(item!=null){
                backgroundColorView.setBackgroundColor(item.getBackgroundColor());
                headerColorView.setBackgroundColor(item.getHeaderColor());
                textSizeView.setText(String.format(Locale.US,"%d",item.getHeaderSize()));
            }
        }

        closeButton = (Button) view.findViewById(R.id.dialog_close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
