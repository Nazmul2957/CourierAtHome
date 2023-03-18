package com.stitbd.courierathomemerchant.Adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.Upozila;

import java.util.ArrayList;
import java.util.List;

public class UpozilaSpinnerAdaptar extends BaseAdapter {
    List<Upozila> upozilaList=new ArrayList<>();
    LayoutInflater inflter;

    public UpozilaSpinnerAdaptar(List<Upozila> upozilaList, Context applicationContext) {
        this.upozilaList = upozilaList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return upozilaList.size();
    }

    @Override
    public Object getItem(int i) {
        return upozilaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return upozilaList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custome_spinner, null);
        TextView name=view.findViewById(R.id.textView);
        name.setText(upozilaList.get(i).getName());
        return view;
    }
}
