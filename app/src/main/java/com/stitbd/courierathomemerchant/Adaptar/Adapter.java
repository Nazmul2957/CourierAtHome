package com.stitbd.courierathomemerchant.Adaptar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.courierathomemerchant.Activity.Dashboard_Click_Total_Parcel;
import com.stitbd.courierathomemerchant.Activity.Total_Cancle_Percel;
import com.stitbd.courierathomemerchant.Activity.Total_Delivery_Complete_Percel;
import com.stitbd.courierathomemerchant.Activity.Total_Delivery_Percel;
import com.stitbd.courierathomemerchant.Activity.Total_Return_Complete_percel;
import com.stitbd.courierathomemerchant.Activity.Total_Return_Percel;
import com.stitbd.courierathomemerchant.Activity.Total_WaitingPercel;
import com.stitbd.courierathomemerchant.Activity.Waiting_Delivery_Percel;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.DashBoardHelperModel;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolders> {

    List<DashBoardHelperModel> dashBoardData = new ArrayList<>();
    Context context;


    public Adapter(List<DashBoardHelperModel> dashBoardData, Context context) {
        this.dashBoardData = dashBoardData;
        this.context = context;

    }

    @NonNull
    @Override
    public Adapter.ViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_listview_sample_design, parent, false);
        return new Adapter.ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolders holder, int position) {

        holder.title.setText(dashBoardData.get(position).getTitle());
        holder.value.setText(String.format("%1$,.0f",dashBoardData.get(position).getValue()));

//        if (position == 0) {
//            holder.parentLayout.setBackgroundResource(R.drawable.dashboard_layout_sample_shape_cyan);
//        } else if (position == 1) {
//            holder.parentLayout.setBackgroundResource(R.drawable.dashboard_layout_sample_shape_cyan);
//        } else if (position == 2) {
//            holder.parentLayout.setBackgroundResource(R.drawable.dashboard_layout_sample_shape_cyan);
//        } else if (position == 3) {
          //  holder.parentLayout.setBackgroundResource(R.drawable.dashboard_layout_sample_shape_cyan);
//        } else if (position == 4) {
//            holder.parentLayout.setBackgroundResource(R.drawable.dashboard_layout_sample_shape_cyan);
//        } else if (position == 5) {
//            holder.parentLayout.setBackgroundResource(R.drawable.dashboard_layout_sample_shape_cyan);
//        } else if (position == 6) {
//            holder.parentLayout.setBackgroundResource(R.drawable.dashboard_layout_sample_shape_cyan);
//        } else if (position == 7) {
//            holder.parentLayout.setBackgroundResource(R.drawable.dashboard_layout_sample_shape_cyan);
//        } else if (position == 8) {
//            holder.parentLayout.setBackgroundResource(R.drawable.dashboard_layout_sample_shape_cyan);
//        } else if (position == 9) {
//            holder.parentLayout.setBackgroundResource(R.drawable.dashboard_layout_sample_shape_cyan);
//        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.getAdapterPosition() == 0) {
                    holder.itemView.getContext().startActivity(new Intent(context, Dashboard_Click_Total_Parcel.class));
                } else if (holder.getAdapterPosition()==1){
                    holder.itemView.getContext().startActivity(new Intent(context, Total_Cancle_Percel.class));
                }else if(holder.getAdapterPosition()==2){
                    holder.itemView.getContext().startActivity(new Intent(context, Total_WaitingPercel.class));
                }else if (holder.getAdapterPosition()==3){
                    holder.itemView.getContext().startActivity(new Intent(context, Waiting_Delivery_Percel.class));
                }else if (holder.getAdapterPosition()==4){
                    holder.itemView.getContext().startActivity(new Intent(context, Total_Delivery_Percel.class));
                }else if (holder.getAdapterPosition()==5){
                    holder.itemView.getContext().startActivity(new Intent(context, Total_Delivery_Complete_Percel.class));
                }else if (holder.getAdapterPosition()==6){
                    holder.itemView.getContext().startActivity(new Intent(context, Total_Return_Percel.class));
                }else if (holder.getAdapterPosition()==7){
                    holder.itemView.getContext().startActivity(new Intent(context, Total_Return_Complete_percel.class));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return dashBoardData.size();
    }

    public static class ViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView value, title;
        LinearLayout parentLayout;

        public ViewHolders(@NonNull View itemView) {
            super(itemView);


            parentLayout = itemView.findViewById(R.id.parenlayout);
            value = itemView.findViewById(R.id.value);
            title = itemView.findViewById(R.id.title);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


        }
    }


}
