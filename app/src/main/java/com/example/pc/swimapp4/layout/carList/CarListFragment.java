package com.example.pc.swimapp4.layout.carList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc.swimapp4.R;
import com.example.pc.swimapp4.model.Car;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarListFragment extends Fragment {

    private Realm mRealm;
    private RealmResults<Car> mResults;
    private View mRootView;
    private CarListAdapter mAdapter;

    private RealmChangeListener callback = new RealmChangeListener() {
        @Override
        public void onChange(Object element) {

            if (mResults!=null) {
                mAdapter.update(mResults);
            }
        }
    };

    public CarListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRealm = Realm.getDefaultInstance();
        mResults = mRealm.where(Car.class).findAllAsync();
        mRootView = inflater.inflate(R.layout.fragment_car_list, container, false);
       RecyclerView recycler = (RecyclerView) mRootView.findViewById(R.id.car_list_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new CarListAdapter(getContext(), mResults);
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
