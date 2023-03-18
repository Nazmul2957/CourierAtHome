package com.stitbd.courierathomemerchant.Adaptar.CanclePercel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.DashBoardClick.DashBoardClick;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CancleParcelAdapter extends RecyclerView.Adapter<CancleParcelAdapter.ViewHolders> {

    List<DashBoardClick> cancelparcel = new ArrayList<>();
    Context context;

    public CancleParcelAdapter(List<DashBoardClick> cancelparcel, Context context) {
        this.cancelparcel = cancelparcel;
        this.context = context;
    }

    @NotNull
    @Override
    public ViewHolders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cancelparcel, parent, false);

        return new CancleParcelAdapter.ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolders holder, int position) {


        holder.percer_invoice.setText(String.valueOf(cancelparcel.get(position).getParcelInvoice()));
        holder.customer_name.setText(String.valueOf(cancelparcel.get(position).getCustomerName()));
        holder.phn_no.setText(String.valueOf(cancelparcel.get(position).getCustomerContactNumber()));
        holder.address.setText(String.valueOf(cancelparcel.get(position).getCustomerAddress()));
        holder.total_charge.setText(String.valueOf(cancelparcel.get(position).getTotalCharge()));
        holder.percel_status.setText(String.valueOf(cancelparcel.get(position).getParcelStatus()));
        holder.Percel_brief.setText(String.valueOf(cancelparcel.get(position).getProductDetails()));
        holder.Total_Collection_Amonunt.setText(String.valueOf(cancelparcel.get(position).getCollectableAmount()));

    }

    @Override
    public int getItemCount() {
        return cancelparcel.size();
    }

    public class ViewHolders extends RecyclerView.ViewHolder {

        TextView percer_invoice, customer_name, phn_no, address, total_charge,
                percel_status, Total_Collection_Amonunt, Percel_brief;

        public ViewHolders(@NonNull @NotNull View itemView) {
            super(itemView);

            percer_invoice = itemView.findViewById(R.id.no);
            customer_name = itemView.findViewById(R.id.name_customer);
            phn_no = itemView.findViewById(R.id.phn_no_show);
            address = itemView.findViewById(R.id.area_name_show);
            total_charge = itemView.findViewById(R.id.total);
            percel_status = itemView.findViewById(R.id.delivery_status);
            Total_Collection_Amonunt = itemView.findViewById(R.id.total_collection_amount);
            Percel_brief = itemView.findViewById(R.id.percel_brief);
        }
    }
}
