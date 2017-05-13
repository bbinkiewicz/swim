package com.example.pc.swimapp4.layout.addCar;

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
import com.example.pc.swimapp4.model.Car;


public class AddCarFragment extends Fragment implements View.OnClickListener {

    private Button mAddButton;
    private EditText mBrand;
    private EditText mModel;
    private EditText mPower;



    public AddCarFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_car, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAddButton = (Button) view.findViewById(R.id.btn_add_car);
        mBrand = (EditText) view.findViewById(R.id.car_brand);
        mModel = (EditText) view.findViewById(R.id.car_model);
        mPower = (EditText) view.findViewById(R.id.car_horse_power);

        mAddButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String carBrand = mBrand.getText().toString();
        String carModel = mModel.getText().toString();
        String carPower = mPower.getText().toString();
        Car car = new Car(carBrand, carModel, carPower);
        Utils.addToDatabase(car);
    }

}
