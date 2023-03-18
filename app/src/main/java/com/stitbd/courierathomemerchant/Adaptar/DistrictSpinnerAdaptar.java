package com.stitbd.courierathomemerchant.Adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.District;

import java.util.ArrayList;
import java.util.List;

public class DistrictSpinnerAdaptar extends BaseAdapter {
    List<District> districtList=new ArrayList<>();
    LayoutInflater inflter;

    public DistrictSpinnerAdaptar(List<District> districtList, Context applicationContext) {
        this.districtList = districtList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return districtList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return districtList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custome_spinner, null);
        TextView name=view.findViewById(R.id.textView);

        name.setText(districtList.get(i).getName());
        return view;
    }
}
