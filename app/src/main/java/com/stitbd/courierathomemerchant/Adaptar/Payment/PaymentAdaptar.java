package com.stitbd.courierathomemerchant.Adaptar.Payment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.courierathomemerchant.Activity.PaymentListDetails;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.Payment.Payment;
import com.stitbd.courierathomemerchant.util.Constant;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PaymentAdaptar extends RecyclerView.Adapter<PaymentAdaptar.ViewHolders> {
    Context context;

    List<Payment> paymentslist = new ArrayList<>();

    public PaymentAdaptar(List<Payment> paymentslist,Context context) {
        this.paymentslist = paymentslist;
        this.context=context;
        Log.e("coverragearea", "adaptar");
    }

    @NotNull
    @Override
    public PaymentAdaptar.ViewHolders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.payment_list_show_sample_design, parent, false);

        return new PaymentAdaptar.ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PaymentAdaptar.ViewHolders holder, int i) {
        holder.marchent_invoice.setText(String.valueOf(paymentslist.get(i).getMerchantPaymentInvoice()));
        holder.status.setText(String.valueOf(paymentslist.get(i).getStatus()));
        holder.total_payment_amonut.setText(String.format("%1$,.0f",paymentslist.get(i).getTotalPaymentAmount()));
        holder.total_payment_percel.setText(String.valueOf(paymentslist.get(i).getTotalPaymentParcel()));
        holder.receive_percel.setText(String.valueOf(paymentslist.get(i).getTotalPaymentReceivedParcel()));
        holder.Date_show.setText(String.valueOf(paymentslist.get(i).getDateTime()));
        holder.total_rcv_payment_amount.setText(String.format("%1$,.0f",paymentslist.get(i).getTotalPaymentReceivedAmount()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context.getApplicationContext(), PaymentListDetails.class);
                intent.putExtra(Constant.PERCELID,paymentslist.get(i).getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });

        Log.e("datata", String.valueOf(paymentslist.get(i).getMerchantPaymentInvoice()));
    }

    @Override
    public int getItemCount() {
        return paymentslist.size();
    }

    public class ViewHolders extends RecyclerView.ViewHolder {

        TextView marchent_invoice,status,total_payment_percel,
        receive_percel,total_payment_amonut,total_rcv_payment_amount,Date_show;

        public ViewHolders(@NonNull @NotNull View itemView) {

            super(itemView);

            marchent_invoice=itemView.findViewById(R.id.payment_invoice);
            status=itemView.findViewById(R.id.percel_status);
            total_payment_amonut=itemView.findViewById(R.id.payment_amt);
            total_payment_percel=itemView.findViewById(R.id.payment_percel);
            receive_percel=itemView.findViewById(R.id.receive_percel);
            total_rcv_payment_amount=itemView.findViewById(R.id.receive_rcv_amonut);
            Date_show=itemView.findViewById(R.id.date_show);

        }
    }
}
