package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.Adaptar.CanclePercel.CancleParcelAdapter;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.DashBoardClick.DashboardClickContainer;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Total_Pending_Collect_Amonut extends AppCompatActivity {

    Api api;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_pending_collect_amonut);

        recyclerView=findViewById(R.id.PendingParcel);


        progressDialog = new ProgressDialog(Total_Pending_Collect_Amonut.this);
        progressDialog.setMessage("please Wait");

        api = RetrofitClient.get(getApplicationContext()).create(Api.class);

        api.getfilter("cancel").enqueue(new Callback<DashboardClickContainer>() {
            @Override
            public void onResponse(Call<DashboardClickContainer> call, Response<DashboardClickContainer> response) {
                if (response.isSuccessful()&& response.body()!=null){
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));

                    CancleParcelAdapter adapter=new CancleParcelAdapter(response.body().getDashclick()
                            ,getApplicationContext());
                    recyclerView.setAdapter(adapter);
                    Log.e("eorrrr", response.toString());
                }
            }

            @Override
            public void onFailure(Call<DashboardClickContainer> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(Total_Pending_Collect_Amonut.this, "something wrong" + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}