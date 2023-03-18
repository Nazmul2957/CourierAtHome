package com.stitbd.courierathomemerchant.Adaptar.ServiceCharge;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.WeightPackage;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Service_Charge_Adaptar extends RecyclerView.Adapter<Service_Charge_Adaptar.ViewHolders> {

    List<WeightPackage> weightlist = new ArrayList<>();

    public Service_Charge_Adaptar(List<WeightPackage> weightlist) {
        this.weightlist = weightlist;
        Log.e("coverragearea", "adaptar");
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_charge_list_sample_design, parent, false);

        return new Service_Charge_Adaptar.ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolders holder, int i) {

        holder.Service.setText(String.valueOf(weightlist.get(i).getName()));
      //  holder.Weight.setText(String.valueOf(weightlist.get(i).getWeightType()));
        holder.Rate.setText(String.valueOf(weightlist.get(i).getRate()));
     if(weightlist.get(i).getWeightType()==1){
         holder.Weight.setText("KG");
     }
     else if(weightlist.get(i).getWeightType()==2){
         holder.Weight.setText("CFT");
     }
        Log.e("datata", String.valueOf(weightlist.get(i).getName()));

    }

    @Override
    public int getItemCount() {
        return weightlist.size();
    }


    public class ViewHolders extends RecyclerView.ViewHolder {

        TextView Service, Weight, Rate;
        public ViewHolders(@NonNull @NotNull View itemView){
            super(itemView);

            Service = itemView.findViewById(R.id.service_weight_name);
            Weight = itemView.findViewById(R.id.weight_type);
            Rate = itemView.findViewById(R.id.rate);
        }
    }
}
