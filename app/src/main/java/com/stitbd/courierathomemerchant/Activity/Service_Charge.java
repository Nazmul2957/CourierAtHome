package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.stitbd.courierathomemerchant.Adaptar.ServiceCharge.Service_Charge_Adaptar;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.WeightPackageContainer;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Service_Charge extends AppCompatActivity {
    Api api;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_charge);

        recyclerView = findViewById(R.id.service_charge_page);

        getSupportActionBar().setTitle("Service Charge");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        api = RetrofitClient.difBaseUrle().create(Api.class);
        progressDialog = new ProgressDialog(Service_Charge.this);
        progressDialog.setMessage("Please wait....");
//        progressDialog.setCancelable(false);
//        progressDialog.show();

        api.getWeightPackages().enqueue(new Callback<WeightPackageContainer>() {
            @Override
            public void onResponse(Call<WeightPackageContainer> call, Response<WeightPackageContainer> response) {
                if (response.isSuccessful() && response.body()!=null){
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));
                    Service_Charge_Adaptar adaptar= new Service_Charge_Adaptar(response.body().getWeightPackageList());
                    recyclerView.setAdapter(adaptar);

                    Log.e("eorrrr", response.toString());
                }
            }

            @Override
            public void onFailure(Call<WeightPackageContainer> call, Throwable t) {
                progressDialog.dismiss();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}