package com.stitbd.courierathomemerchant.Adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.GetWeightPackage;

import java.util.ArrayList;
import java.util.List;

public class PakcagesSpinnerAdapter extends BaseAdapter {

    List<GetWeightPackage> packagelist = new ArrayList<>();
    LayoutInflater inflter;

    public PakcagesSpinnerAdapter(List<GetWeightPackage> districtList, Context applicationContext) {
        this.packagelist = districtList;
        inflter = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return packagelist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return packagelist.get(position).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.custome_spinner, null);
        TextView name=view.findViewById(R.id.textView);
        name.setText(packagelist.get(i).getId());
        return null;
    }
}
