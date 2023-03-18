package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.Adaptar.PercelListAdapter;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.databinding.ActivityMainBinding;
import com.stitbd.courierathomemerchant.model.PercelContainer;
import com.stitbd.courierathomemerchant.model.PercelStatus;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard_Click_Total_Parcel extends AppCompatActivity {

    Api api;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    List<PercelStatus> percelStatusList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_click_total_parcel);

        recyclerView = findViewById(R.id.total_percel_show);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Total Parcel");

        api = RetrofitClient.get(getApplicationContext()).create(Api.class);

        progressDialog = new ProgressDialog(Dashboard_Click_Total_Parcel.this);
        progressDialog.setMessage("Please wait....");

        api.getpercellistdata().enqueue(new Callback<PercelContainer>() {
            @Override
            public void onResponse(Call<PercelContainer> call, Response<PercelContainer> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                                LinearLayoutManager.VERTICAL, false));
                        PercelListAdapter adapter = new PercelListAdapter(response.body().getPercels(), getApplicationContext(), new PercelListAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                dataInitialize();
                            }
                        });
                        recyclerView.setAdapter(adapter);

                        Log.e("eorrrr", response.toString());
                    }

                } catch (Exception e) {
                    Toast.makeText(Dashboard_Click_Total_Parcel.this, "Something wrong......", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PercelContainer> call, Throwable t) {
                progressDialog.dismiss();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        dataInitialize();

    }

    public void dataInitialize() {
        progressDialog = new ProgressDialog(Dashboard_Click_Total_Parcel.this);
        progressDialog.setMessage("Please wait....");
        progressDialog.show();

        api.getpercellistdata().enqueue(new Callback<PercelContainer>() {
            @Override
            public void onResponse(Call<PercelContainer> call, Response<PercelContainer> response) {
                progressDialog.dismiss();
                try {
                    if (response.isSuccessful() && response.body() != null) {
//                        progressDialog.dismiss();
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                                LinearLayoutManager.VERTICAL, false));
                        PercelListAdapter adapter = new PercelListAdapter(response.body().getPercels(), getApplicationContext(), new PercelListAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                dataInitialize();
                            }
                        });
                        recyclerView.setAdapter(adapter);

                        Log.e("eorrrr", response.toString());
                    }

                } catch (Exception e) {
                    Toast.makeText(Dashboard_Click_Total_Parcel.this, "Something wrong......", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PercelContainer> call, Throwable t) {
                progressDialog.dismiss();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
//        moveTaskToBack(true);
        return true;
    }


}