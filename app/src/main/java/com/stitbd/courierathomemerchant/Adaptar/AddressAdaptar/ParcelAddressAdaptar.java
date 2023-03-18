package com.stitbd.courierathomemerchant.Adaptar.AddressAdaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.stitbd.courierathomemerchant.R;

import java.util.ArrayList;

public class ParcelAddressAdaptar extends BaseAdapter {
    Context context;
    ArrayList<String> strings = new ArrayList<>();
    LayoutInflater inflter;

    public ParcelAddressAdaptar(ArrayList<String> strings, LayoutInflater inflter,Context context) {
        this.strings = strings;
        this.inflter = inflter;
        this.context = context;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.custome_spinner, null);
        TextView name=view.findViewById(R.id.textView);

        name.setText("Business Address");
        return view;
    }
}
