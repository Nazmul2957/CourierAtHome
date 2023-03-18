package com.stitbd.courierathomemerchant.Adaptar;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.courierathomemerchant.Activity.Percel_Details;
import com.stitbd.courierathomemerchant.Adaptar.listener.PercelMenuClickListener;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.Percel;
import com.stitbd.courierathomemerchant.util.Constant;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PercelListAdapter extends RecyclerView.Adapter<PercelListAdapter.ViewHolders> {
    List<Percel> percelList = new ArrayList<>();
    Context mctx;
    public PercelListAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public PercelListAdapter(List<Percel> percelList, Context mctx,OnItemClickListener listener) {
        this.percelList = percelList;
        this.mctx = mctx;
        this.listener=  listener;
        Log.e("eroor", "adaptar");
    }


    @NotNull
    @Override
    public ViewHolders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.parcel_list_sample_page, parent, false);

        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolders holder, int position) {


        holder.percer_invoice.setText(String.valueOf(percelList.get(position).getParcelInvoice()));
        holder.customer_name.setText(String.valueOf(percelList.get(position).getCustomerName()));
        holder.phn_no.setText(String.valueOf(percelList.get(position).getCustomerContactNumber()));
        holder.address.setText(String.valueOf(percelList.get(position).getCustomerAddress()));
        holder.total_charge.setText(String.format("%1$,.2f", percelList.get(position).getTotalCharge()));
        holder.percel_status.setText(String.valueOf(percelList.get(position).getParcelStatus()));
        holder.Percel_brief.setText(String.valueOf(percelList.get(position).getProduct_details()));
        holder.Total_Collection_Amonunt.setText(String.valueOf(percelList.get(position).getCollectable_amount()));
        holder.optionMenu.setOnClickListener(new PercelMenuClickListener(this,
                holder,listener ,percelList.get(position)));


        /////item click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mctx.getApplicationContext(), Percel_Details.class);
                Log.e("tesst", String.valueOf(percelList.get(position).getId()));
                intent.putExtra(Constant.PERCELID, percelList.get(position).getId());

                holder.itemView.getContext().startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return percelList.size();
    }

    public class ViewHolders extends RecyclerView.ViewHolder {
        TextView percer_invoice, customer_name, phn_no, address, total_charge,
                percel_status, Total_Collection_Amonunt, Percel_brief;
        ImageView optionMenu;

        public ViewHolders(@NonNull @NotNull View itemView) {
            super(itemView);

            percer_invoice = itemView.findViewById(R.id.no);
            customer_name = itemView.findViewById(R.id.name_customer);
            phn_no = itemView.findViewById(R.id.phn_no_show);
            address = itemView.findViewById(R.id.area_name_show);
            total_charge = itemView.findViewById(R.id.total);
            percel_status = itemView.findViewById(R.id.delivery_status);
            optionMenu = itemView.findViewById(R.id.option_menu);
            Total_Collection_Amonunt = itemView.findViewById(R.id.total_collection_amount);
            Percel_brief = itemView.findViewById(R.id.percel_brief);


        }

        public ImageView getoption() {
            return this.optionMenu;
        }

    }
//
//    public void passdata(int id) {
//
//        Intent intent = new Intent(mctx, Percel_Details.class);
//        intent.putExtra("id", "" + id);
//        mctx.startActivity(intent);
//    }

}
