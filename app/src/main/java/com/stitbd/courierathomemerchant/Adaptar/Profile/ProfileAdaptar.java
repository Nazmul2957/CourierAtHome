package com.stitbd.courierathomemerchant.Adaptar.Profile;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.Profile.ServiceCharge;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class ProfileAdaptar extends RecyclerView.Adapter<ProfileAdaptar.Viewholders> {

    List<ServiceCharge> servicecharge = new ArrayList<>();

    public ProfileAdaptar(List<ServiceCharge> servicecharge) {
        this.servicecharge = servicecharge;
        Log.e("coverragearea", "adaptar");
    }

    @NonNull
    @NotNull
    @Override
    public Viewholders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_page_sample_design, parent, false);

        return new ProfileAdaptar.Viewholders(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Viewholders holder, int i) {
        holder.Area.setText(String.valueOf(servicecharge.get(i).getName()));
        holder.Charge.setText(String.valueOf(servicecharge.get(i).getCharge()));

        Log.e("profile", String.valueOf(servicecharge.get(i).getName()));
    }

    @Override
    public int getItemCount() {
        return servicecharge.size();
    }

    public class Viewholders extends RecyclerView.ViewHolder {

        TextView Area, Charge;

        public Viewholders(@NonNull @NotNull View itemView) {
            super(itemView);

            Area = itemView.findViewById(R.id.area_name);
            Charge = itemView.findViewById(R.id.charge);
        }
    }


}
