package com.stitbd.courierathomemerchant.Adaptar.PaymentListDetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.PaymentListDetails.DeliveryPaymentDetail;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PaymentDetailsAdaptar extends RecyclerView.Adapter<PaymentDetailsAdaptar.Viewholder> {

    Context context;
    List<DeliveryPaymentDetail> details = new ArrayList<>();

    public PaymentDetailsAdaptar(List<DeliveryPaymentDetail> details, Context context) {
        this.context = context;
        this.details = details;
    }

    @NonNull
    @NotNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.payment_details_sample, parent, false);

        return new PaymentDetailsAdaptar.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Viewholder holder, int position) {

        holder.Invoice.setText(String.valueOf(details.get(position).getParcelInvoice()));
//        holder.MerchantId.setText(String.valueOf(details.get(position).getMerchantOrderId()));
        holder.CollectAmount.setText(String.format("%1$,.2f",details.get(position).getCollectedAmount()));
        holder.CodCharge.setText(String.format("%1$,.2f",details.get(position).getCodCharge()));
        holder.DeliveryCharge.setText(String.format("%1$,.2f",details.get(position).getDeliveryCharge()));
        holder.WeightPacCharge.setText(String.format("%1$,.2f",details.get(position).getWeightPackageCharge()));
        //holder.ReturnCharge.setText(String.format("%1$,.2f",details.get(position).getReturnCharge()));
        holder.PaidAmount.setText(String.format("%1$,.2f",details.get(position).getPaidAmount()));
      //  holder.Note.setText(String.valueOf(details.get(position).getNote()));
        holder.Status.setText(String.valueOf(details.get(position).getStatus()));
        holder.CustomerName.setText(String.valueOf(details.get(position).getCustomer_name()));
        holder.CustomerPhn.setText(String.valueOf(details.get(position).getCustomer_contact_number()));




    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView Invoice, MerchantId, CollectAmount, CodCharge, DeliveryCharge,
                WeightPacCharge, ReturnCharge, PaidAmount, Note, Status,CustomerName,CustomerPhn;

        public Viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            Invoice = itemView.findViewById(R.id.percel_invoce_details);
            MerchantId = itemView.findViewById(R.id.merchant_id_details);
            CollectAmount = itemView.findViewById(R.id.merchant_name);
            CodCharge = itemView.findViewById(R.id.customer_name_details);
            DeliveryCharge = itemView.findViewById(R.id.address_details);
            WeightPacCharge = itemView.findViewById(R.id.phn_no_details);
            ReturnCharge = itemView.findViewById(R.id.district_name_details);
            PaidAmount = itemView.findViewById(R.id.upazila_name_details);
            Note = itemView.findViewById(R.id.percel_note_details);
            Status = itemView.findViewById(R.id.percel_status_details);
            CustomerName=itemView.findViewById(R.id.payment_percel);
            CustomerPhn = itemView.findViewById(R.id.payment_amt);
        }
    }
}
