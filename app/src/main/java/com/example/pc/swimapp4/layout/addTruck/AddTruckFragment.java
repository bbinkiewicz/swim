package com.example.pc.swimapp4.layout.addTruck;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.swimapp4.R;
import com.example.pc.swimapp4.common.Utils;
import com.example.pc.swimapp4.model.Truck;

import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddTruckFragment extends Fragment implements View.OnClickListener {
    private Button mAddButton;
    private EditText mBrand;
    private EditText mModel;
    private EditText mCapacity;


    public AddTruckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_truck, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAddButton = (Button) view.findViewById(R.id.btn_add_truck);
        mBrand = (EditText) view.findViewById(R.id.truck_brand);
        mModel = (EditText) view.findViewById(R.id.truck_model);
        mCapacity = (EditText) view.findViewById(R.id.truck_capacity);

        mAddButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Realm realm = Realm.getDefaultInstance();
        String truckBrand = mBrand.getText().toString();
        String truckModel = mModel.getText().toString();
        String capacity = mCapacity.getText().toString();
        Truck truck = new Truck(truckBrand, truckModel, capacity);
        Utils.addToDatabase(truck);
    }


}
