package com.example.pc.swimapp4.layout.carList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.swimapp4.R;
import com.example.pc.swimapp4.model.Car;

import io.realm.RealmResults;



public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.ViewHolder> {
    private RealmResults<Car> mResults;
    private Context mContext;

    public CarListAdapter(Context context, RealmResults<Car> results){
        mContext = context;
        mResults = results;
        update(mResults);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.car_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Car car = mResults.get(position);
        holder.mPower.setText(car.getHorsePower());
        holder.mModel.setText(car.getModel());
        holder.mBrand.setText(car.getBrand());

    }

    public void update(RealmResults<Car> result) {

        mResults = result;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        if(mResults!=null){
            return mResults.size();
        }
        else
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mBrand;
        private TextView mModel;
        private TextView mPower;

        public ViewHolder(View itemView) {
            super(itemView);
            mBrand = (TextView) itemView.findViewById(R.id.row_car_brand);
            mModel = (TextView) itemView.findViewById(R.id.row_car_model);
            mPower = (TextView) itemView.findViewById(R.id.row_car_horse_power);
        }
    }
}
