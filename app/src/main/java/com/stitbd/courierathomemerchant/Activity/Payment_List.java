package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.Adaptar.Payment.PaymentAdaptar;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.Payment.PaymentContainer;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Payment_List extends AppCompatActivity {

    Api api;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_list);

        getSupportActionBar().setTitle("Payment List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.paymentdone);
        api = RetrofitClient.get(getApplicationContext()).create(Api.class);

        progressDialog = new ProgressDialog(Payment_List.this);
        progressDialog.setMessage("Please wait....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        api.getpaymentlist().enqueue(new Callback<PaymentContainer>() {
            @Override
            public void onResponse(Call<PaymentContainer> call, Response<PaymentContainer> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));
                    PaymentAdaptar adaptar = new PaymentAdaptar(response.body().getPaymentlist(),getApplicationContext());
                    recyclerView.setAdapter(adaptar);

                    Log.e("payment",response.body().toString());

                }
//                try {
////                    Log.e("payment",response.errorBody().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
 //               }
                if (response.body() == null) {
                    Log.e("payment",response.body().toString());
                    Toast.makeText(Payment_List.this, "data not found", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<PaymentContainer> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("payment",t.toString());
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}