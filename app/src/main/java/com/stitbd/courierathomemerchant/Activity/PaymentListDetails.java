package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.stitbd.courierathomemerchant.Adaptar.PaymentListDetails.PaymentDetailsAdaptar;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.PaymentListDetails.Example;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;
import com.stitbd.courierathomemerchant.util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentListDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    Api api;
    ProgressDialog progressDialog;
    TextView Invoice, TpaymentParcel, TpaymentAmount, ReceiveParcel, ReceiveAmount, Status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_list_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Product Details");

        progressDialog = new ProgressDialog(PaymentListDetails.this);
        progressDialog.setMessage("Please wait.....");




        Invoice = findViewById(R.id.merchant_payment_invoice);
        TpaymentParcel = findViewById(R.id.total_payment_parcel);
        TpaymentAmount = findViewById(R.id.total_payment_amount);
        ReceiveParcel = findViewById(R.id.total_payment_received_parce);
        ReceiveAmount = findViewById(R.id.total_payment_received_amount);
        Status = findViewById(R.id.status);

        recyclerView = findViewById(R.id.payment_details);






        api = RetrofitClient.get(getApplicationContext()).create(Api.class);
        int percel_id = getIntent().getIntExtra(Constant.PERCELID, 0);
        Log.e("tesst", String.valueOf(percel_id));

        if (percel_id != 0) {
            progressDialog.show();
            api.getpaymentsDetails(percel_id).enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    progressDialog.dismiss();
                    if (response.isSuccessful() && response.body() != null) {
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                                LinearLayoutManager.VERTICAL, false));
                        PaymentDetailsAdaptar adaptar = new PaymentDetailsAdaptar(response.body().
                                getDeliveryPaymentDetails(), getApplicationContext());
                        recyclerView.setAdapter(adaptar);

                        Invoice.setText(String.valueOf(response.body().getDeliveryPayment().getMerchantPaymentInvoice()));
                        TpaymentParcel.setText(String.valueOf(response.body().getDeliveryPayment().getTotalPaymentParcel()));
                        TpaymentAmount.setText(String.valueOf(response.body().getDeliveryPayment().getTotalPaymentAmount()));
                        ReceiveParcel.setText(String.valueOf(response.body().getDeliveryPayment().getTotalPaymentReceivedParcel()));
                        ReceiveAmount.setText(String.valueOf(response.body().getDeliveryPayment().getTotalPaymentReceivedAmount()));
                        Status.setText(String.valueOf(response.body().getDeliveryPayment().getStatus()));


                        // Log.e("aaaa",response.body().getDeliveryPaymentDetails().get(0).getCollectedAmount());

                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}