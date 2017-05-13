package com.example.pc.swimapp4.layout.truckList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.swimapp4.R;
import com.example.pc.swimapp4.model.Truck;

import io.realm.RealmResults;



public class TruckListAdapter extends RecyclerView.Adapter<TruckListAdapter.ViewHolder> {


    private RealmResults<Truck> mResults;

    public TruckListAdapter(RealmResults<Truck> results){
        mResults = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.truck_list_row, parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Truck truck = mResults.get(position);
        holder.brand.setText(truck.getBrand());
        holder.model.setText(truck.getModel());
        holder.capacity.setText(truck.getCapacity());

    }

    @Override
    public int getItemCount() {
        if(mResults != null){
            return mResults.size();
        }
        else{
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView brand;
        private TextView model;
        private TextView capacity;
        public ViewHolder(View itemView) {
            super(itemView);
            brand = (TextView) itemView.findViewById(R.id.row_truck_brand);
            model = (TextView) itemView.findViewById(R.id.row_truck_model);
            capacity = (TextView) itemView.findViewById(R.id.row_truck_capacity);

        }
    }
}
