package com.stitbd.courierathomemerchant.Adaptar.listener;

import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;

import com.stitbd.courierathomemerchant.Activity.Parcel_list_show;
import com.stitbd.courierathomemerchant.Activity.Track_Parcel;
import com.stitbd.courierathomemerchant.Adaptar.PercelListAdapter;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.HoldParcel.HoldParcelModel;
import com.stitbd.courierathomemerchant.model.Percel;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;
import com.stitbd.courierathomemerchant.util.Constant;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PercelMenuClickListener implements View.OnClickListener {
    PercelListAdapter percelListAdapter;
    PercelListAdapter.ViewHolders viewHolders;
    PercelListAdapter.OnItemClickListener listener;
    Percel percel;
    Api api;


    public PercelMenuClickListener(PercelListAdapter percelListAdapter, PercelListAdapter.ViewHolders viewHolders,PercelListAdapter.OnItemClickListener listener, Percel percel) {
        this.percelListAdapter = percelListAdapter;
        this.viewHolders = viewHolders;
        this.listener=listener;
        this.percel = percel;
        api = RetrofitClient.get(viewHolders.itemView.getContext()).create(Api.class);
    }

    @Override
    public void onClick(View view) {
        PopupMenu popupMenu = new PopupMenu(viewHolders.itemView.getContext(), viewHolders.getoption());
        popupMenu.getMenuInflater().inflate(R.menu.rc_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.track_parcel_menu:
                        Intent intent = new Intent(viewHolders.itemView.getContext(), Track_Parcel.class);
                        intent.putExtra(Constant.INVOICE_NO, percel.getParcelInvoice());

                        viewHolders.itemView.getContext().startActivity(intent);
                        Toast.makeText(viewHolders.itemView.getContext(), "track parcel", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.hold_percel_menu:
                        api.gethold(String.valueOf(percel.getId())).enqueue(new Callback<HoldParcelModel>() {
                            @Override
                            public void onResponse(Call<HoldParcelModel> call, Response<HoldParcelModel> response) {
                                if (response.isSuccessful() && response.body() != null) {
//                                    Intent intent = new Intent(viewHolders.itemView.getContext(), Parcel_list_show.class);
//                                    viewHolders.itemView.getContext().startActivity(intent);
                                    listener.onItemClick(0);

                                } else {
                                    try {
                                        Log.e("errrrrrroor",response.errorBody().string());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Toast.makeText(viewHolders.itemView.getContext(), "Hold Parcel", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<HoldParcelModel> call, Throwable t) {

                            }
                        });

                        return true;
                    case R.id.cancel_percel_menu:

                        api.getcancel(String.valueOf(percel.getId())).enqueue(new Callback<HoldParcelModel>() {
                            @Override
                            public void onResponse(Call<HoldParcelModel> call, Response<HoldParcelModel> response) {
                                if (response.isSuccessful() && response.body() != null) {
//                                    Intent intent = new Intent(viewHolders.itemView.getContext(), Parcel_list_show.class);
//                                    viewHolders.itemView.getContext().startActivity(intent);
                                    listener.onItemClick(0);
                                } else {
                                    Toast.makeText(viewHolders.itemView.getContext(), "Cancel Parcel", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<HoldParcelModel> call, Throwable t) {

                            }
                        });

                        return true;
                    case R.id.play_percel_menu:
                        api.getplay(String.valueOf(percel.getId())).enqueue(new Callback<HoldParcelModel>() {
                            @Override
                            public void onResponse(Call<HoldParcelModel> call, Response<HoldParcelModel> response) {
                                if (response.isSuccessful() && response.body() != null) {
//                                    Intent intent = new Intent(viewHolders.itemView.getContext(), Parcel_list_show.class);
//                                    viewHolders.itemView.getContext().startActivity(intent);
                                    listener.onItemClick(0);
                                } else {
                                    Toast.makeText(viewHolders.itemView.getContext(), "Parcel Start", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<HoldParcelModel> call, Throwable t) {

                            }
                        });

                    default:
                        return false;
                }

            }
        });
        popupMenu.show();
    }
}
