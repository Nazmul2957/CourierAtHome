package com.stitbd.courierathomemerchant.Adaptar.CoverageArea;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.Coverage.Coverage;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CoverageAdaptar extends RecyclerView.Adapter<CoverageAdaptar.ViewHolders> {

    List<Coverage> coverarealist = new ArrayList<>();

    public CoverageAdaptar(List<Coverage> coverarealist) {
        this.coverarealist = coverarealist;
        Log.e("coverragearea", "adaptar");
    }


    @NotNull
    @Override
    public CoverageAdaptar.ViewHolders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coverage_area_list_sample_design, parent, false);

        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CoverageAdaptar.ViewHolders holder, int i) {
        holder.coverage_area.setText(String.valueOf(coverarealist.get(i).getCoverageArea()));
        holder.postcode.setText(String.valueOf(coverarealist.get(i).getPostCode()));
        holder.thana.setText(String.valueOf(coverarealist.get(i).getUpazilaName()));
        holder.district.setText(String.valueOf(coverarealist.get(i).getDistrictName()));
        holder.Service_area_name.setText(String.valueOf(coverarealist.get(i).getServiceAreaName()));
        holder.cod.setText(String.valueOf(coverarealist.get(i).getCodCharge()));


        Log.e("datata", String.valueOf(coverarealist.get(i).getCoverageArea()));

    }

    @Override
    public int getItemCount() {
        return coverarealist.size();
    }

    public class ViewHolders extends RecyclerView.ViewHolder {

        TextView coverage_area, postcode, thana, district, Service_area_name, cod;

        public ViewHolders(@NonNull @NotNull View itemView) {
            super(itemView);

            coverage_area = itemView.findViewById(R.id.area);
            postcode = itemView.findViewById(R.id.post_code);
            thana = itemView.findViewById(R.id.area_thana);
            district = itemView.findViewById(R.id.carea_district);
            Service_area_name = itemView.findViewById(R.id.service_area);
            cod = itemView.findViewById(R.id.cod_charge_carea);


        }
    }
}
