package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.stitbd.courierathomemerchant.Adaptar.CoverageArea.CoverageAdaptar;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.Coverage.CoverageContainer;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Coverage_Area extends AppCompatActivity {
    Api api;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverage_area);

        getSupportActionBar().setTitle("Coverage Area");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.coverage_area_name_recycle);

        api = RetrofitClient.get(getApplicationContext()).create(Api.class);
        progressDialog = new ProgressDialog(Coverage_Area.this);
        progressDialog.setMessage("Please wait....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        api.getcoverarea().enqueue(new Callback<CoverageContainer>() {
            @Override
            public void onResponse(Call<CoverageContainer> call, Response<CoverageContainer> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));
                    CoverageAdaptar adaptar = new CoverageAdaptar(response.body().getCoverarea());
                    recyclerView.setAdapter(adaptar);

//                    Log.e("eorrrr", response.toString());

                }
            }

            @Override
            public void onFailure(Call<CoverageContainer> call, Throwable t) {
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