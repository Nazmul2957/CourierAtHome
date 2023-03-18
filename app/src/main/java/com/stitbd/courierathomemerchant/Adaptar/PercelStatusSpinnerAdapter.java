package com.stitbd.courierathomemerchant.Adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.stitbd.courierathomemerchant.Adaptar.listener.Clicklistener;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.PercelStatus;

import java.util.ArrayList;
import java.util.List;

public class PercelStatusSpinnerAdapter extends BaseAdapter {
    List<PercelStatus> areas=new ArrayList<>();
    LayoutInflater inflter;
    Clicklistener clicklistener;

    public PercelStatusSpinnerAdapter(List<PercelStatus> areas, Context applicationContext) {
        this.areas = areas;
        inflter = (LayoutInflater.from(applicationContext));
        this.clicklistener=clicklistener;
    }

    @Override
    public int getCount() {
        return areas.size();
    }

    @Override
    public Object getItem(int i) {
        return areas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return areas.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custome_spinner, null);
        TextView name=view.findViewById(R.id.textView);
        name.setText(areas.get(i).getName());

        return view;
    }
}
