package com.example.pc.swimapp4.layout.add;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.pc.swimapp4.R;
import com.example.pc.swimapp4.layout.addCar.AddCarFragment;
import com.example.pc.swimapp4.layout.addTruck.AddTruckFragment;
import com.example.pc.swimapp4.listeners.OnTypeSelectedListener;


public class AddFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private final static int CAR = 0;
    private final static int TRUCK = 1;

    private Fragment attached;
    private OnTypeSelectedListener mListener;
    private Context mContext;
    private AddCarFragment carFragment;
    private AddTruckFragment truckFragment;
    private FragmentTransaction fragmentTransaction;

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.vehicles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        carFragment = new AddCarFragment();
        truckFragment = new AddTruckFragment();
        attached = carFragment;
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, truckFragment);
        fragmentTransaction.detach(truckFragment);
        fragmentTransaction.add(R.id.container, carFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch(position){
            case CAR:
                showFragment(carFragment);
                break;

            case TRUCK:
                showFragment(truckFragment);
                break;
        }
    }

    private void showFragment (Fragment toAttach){
        fragmentTransaction = getFragmentManager().beginTransaction();
        if(!toAttach.equals(attached)) {
            fragmentTransaction.detach(attached);
            fragmentTransaction.attach(toAttach);
            fragmentTransaction.commit();
            attached = toAttach;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
