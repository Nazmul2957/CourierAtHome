package com.stitbd.courierathomemerchant.Adaptar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.PercelLog.PercelLog;

import java.util.ArrayList;
import java.util.List;

public class PercelLogAdapter extends RecyclerView.Adapter<PercelLogAdapter.ViewHolder> {
    List<PercelLog> percelLogList=new ArrayList<>();

    public PercelLogAdapter(List<PercelLog> percelLogList) {
        this.percelLogList = percelLogList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_design_percellog_rv, parent, false);

        return  new PercelLogAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
             PercelLog percelLog=percelLogList.get(position);
             holder.status.setText(percelLog.getStatus());
             holder.from.setText(percelLog.getFromUser());
             holder.touser.setText(percelLog.getToUser());
             holder.date.setText(percelLog.getDate());
    }

    @Override
    public int getItemCount() {
        return percelLogList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView touser,from,date,status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            touser=itemView.findViewById(R.id.tv_to_action);
            from=itemView.findViewById(R.id.tv_from_action);
            date=itemView.findViewById(R.id.tv_date);
            status=itemView.findViewById(R.id.tv_status);
        }
    }
}
