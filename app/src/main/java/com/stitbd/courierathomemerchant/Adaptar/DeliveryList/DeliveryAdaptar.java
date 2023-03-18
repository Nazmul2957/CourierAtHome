package com.stitbd.courierathomemerchant.Adaptar.DeliveryList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.DeliveryPercelList.DeliveryPercelList;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAdaptar extends RecyclerView.Adapter<DeliveryAdaptar.Viewholders> {

    List<DeliveryPercelList> deliverypercelList = new ArrayList<>();

    public DeliveryAdaptar(List<DeliveryPercelList> deliverypercelList) {
        this.deliverypercelList = deliverypercelList;
        Log.e("coverragearea", "adaptar");
    }

    @NotNull
    @Override
    public DeliveryAdaptar.Viewholders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.delivery_list_sample_page, parent, false);

        return new Viewholders(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DeliveryAdaptar.Viewholders holder, int i) {

        holder.PercelInvoice.setText(String.valueOf(deliverypercelList.get(i).getParcelInvoice()));
        holder.TotalCollectAmount.setText(String.valueOf(deliverypercelList.get(i).getTotalCollectAmount()));
        holder.CodPercent.setText(String.valueOf(deliverypercelList.get(i).getCodPercent()));
        holder.CodCharge.setText(String.valueOf(deliverypercelList.get(i).getCodCharge()));
        holder.Package.setText(String.valueOf(deliverypercelList.get(i).getWeightPackageCharge()));
        holder.DeliveryCharge.setText(String.valueOf(deliverypercelList.get(i).getDeliveryCharge()));
        holder.ReturnCharge.setText(String.valueOf(deliverypercelList.get(i).getReturnCharge()));
        holder.CustomerCollectAmount.setText(String.valueOf(deliverypercelList.get(i).getCustomerCollectAmount()));
        holder.Total_cahrge.setText(String.valueOf(deliverypercelList.get(i).getTotalCharge()));
        holder.Paid_amount.setText(String.valueOf(deliverypercelList.get(i).getMerchantPaidAmount()));

        Log.e("datata", String.valueOf(deliverypercelList.get(i).getParcelInvoice()));

    }

    @Override
    public int getItemCount() {
        return deliverypercelList.size();
    }

    public class Viewholders extends RecyclerView.ViewHolder {

        TextView PercelInvoice, TotalCollectAmount, CodPercent, CodCharge, Package, DeliveryCharge, ReturnCharge,
                CustomerCollectAmount, Total_cahrge, Paid_amount;


        public Viewholders(@NonNull @NotNull View itemView) {
            super(itemView);

            PercelInvoice = itemView.findViewById(R.id.percel_invoice);
            TotalCollectAmount = itemView.findViewById(R.id.total_collect_amount);
            CodPercent = itemView.findViewById(R.id.cod_percent);
            CodCharge = itemView.findViewById(R.id.cod_charge);
            Package = itemView.findViewById(R.id.delivery_package);
            DeliveryCharge = itemView.findViewById(R.id.delivery_charge_page);
            ReturnCharge = itemView.findViewById(R.id.return_charge);
            CustomerCollectAmount = itemView.findViewById(R.id.customer_collect_amount);
            Total_cahrge = itemView.findViewById(R.id.delivery_total_charge);
            Paid_amount = itemView.findViewById(R.id.paid_amount);


        }
    }
}
