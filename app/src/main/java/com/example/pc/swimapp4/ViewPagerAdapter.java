package com.example.pc.swimapp4;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.pc.swimapp4.layout.add.AddFragment;
import com.example.pc.swimapp4.layout.carList.CarListFragment;
import com.example.pc.swimapp4.layout.truckList.TruckListFragment;

/**
 * Created by PC on 2017-05-08.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment selected;
        switch (position){
            case 0:
                selected = new AddFragment();
                break;
            case 1:
                selected = new CarListFragment();
                break;
            case 2:
                selected = new TruckListFragment();
                break;
            default:
                selected = new AddFragment();
        }
        return selected;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = mContext.getString(R.string.add);

                break;
            case 1:
                title = mContext.getString(R.string.cars);
                break;
            case 2:
                title = mContext.getString(R.string.trucks);
        }
        return title;
    }
}
