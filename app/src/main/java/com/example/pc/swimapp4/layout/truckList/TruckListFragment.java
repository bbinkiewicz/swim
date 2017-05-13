package com.example.pc.swimapp4.layout.truckList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc.swimapp4.R;
import com.example.pc.swimapp4.model.Truck;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class TruckListFragment extends Fragment {
    private Realm mRealm;
    private RealmResults<Truck> mResults;
    private View mRootView;
    private TruckListAdapter mAdapter;


    private RealmChangeListener callback = new RealmChangeListener() {
        @Override
        public void onChange(Object element) {

        }
    };


    public TruckListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView =  inflater.inflate(R.layout.fragment_truck_list, container, false);
        mRealm = Realm.getDefaultInstance();
        mResults = mRealm.where(Truck.class).findAllAsync();
        mAdapter = new TruckListAdapter(mResults);
        RecyclerView recycler = (RecyclerView) mRootView.findViewById(R.id.truck_list_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(mAdapter);
        return mRootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mResults.addChangeListener(callback);
    }

    @Override
    public void onStop() {
        super.onStop();
        mResults.removeAllChangeListeners();

    }

}
