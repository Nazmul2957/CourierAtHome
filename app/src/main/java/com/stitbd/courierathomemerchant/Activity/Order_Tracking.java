package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.Adaptar.PercelLogAdapter;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.databinding.ActivityOrderTrackingBinding;
import com.stitbd.courierathomemerchant.databinding.ActivityTrackParcelBinding;
import com.stitbd.courierathomemerchant.model.PercelLog.PercelContainerLog;
import com.stitbd.courierathomemerchant.model.PercelLog.PercelInformation;
import com.stitbd.courierathomemerchant.model.PercelLog.PercelLog;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Order_Tracking extends AppCompatActivity {
    ActivityOrderTrackingBinding binding;
    Api api;
    RecyclerView recyclerView;
    EditText mercentOder,invoice;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Parcel Track");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = ActivityOrderTrackingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        api= RetrofitClient.get(getApplicationContext()).create(Api.class);
        recyclerView=findViewById(R.id.rv_list);
        progressDialog = new ProgressDialog(Order_Tracking.this);
        progressDialog.setMessage("Please Wait......");
        progressDialog.setCancelable(false);


        binding.filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdatafromServer();
            }
        });

//        binding.etInvoiceNo.setOnEditorActionListener(new EditText.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId==EditorInfo.IME_ACTION_DONE){
//                    getdatafromServer();
//                    return true;
//
//                }
//                return false;
//            }
//        });

//        binding.etMerchantOrderNo.setOnEditorActionListener(new EditText.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                 //   if(!TextUtils.isEmpty(binding.etInvoiceNo.getText().toString())){
//                        getdatafromServer();
//                   // }
//                    return true;
//                }
//                return false;
//            }
//        });
    }
    private void getdatafromServer() {
        progressDialog.show();
        api.getpercellog(binding.etInvoiceNo.getText().toString(),binding.etMerchantOrderNo.getText().toString()).enqueue(new Callback<PercelContainerLog>() {
            @Override
            public void onResponse(Call<PercelContainerLog> call, Response<PercelContainerLog> response) {
                progressDialog.dismiss();

                if(response.isSuccessful()&&response.body()!=null){
                    binding.clInformation.setVisibility(View.VISIBLE);
                    PercelInformation percelInformation=response.body().getPercellogInformation();
                    List<PercelLog> percelLog=response.body().getPercelLog();
                    binding.tvCustomerName.setText("Name: "+response.body().getPercellogInformation().getCustomerName());
                    binding.tvCustomerAddress.setText("Address: "+response.body().getPercellogInformation().getCustomerAddress());
                    binding.tvCustomerPhone.setText("Phone: "+response.body().getPercellogInformation().getCustomerContactNumber());
                    binding.tvDate.setText("Date: "+response.body().getPercellogInformation().getDate());

                    binding.tvPackage.setText("Package: "+percelInformation.getWeight_package().getName());
                    binding.tvInvoice.setText("Inv: "+percelInformation.getParcelInvoice());
                    binding.tvOrderNo.setText("Order Id:"+percelInformation.getOrder_id());
                    binding.tvTotalCharge.setText("Total: "+String.valueOf(percelInformation.getTotalCharge()));
                    binding.tvDeliveryCharge.setText("Delivery: "+String.valueOf(percelInformation.getDeliveryCharge()));

                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));
                    PercelLogAdapter adapter = new PercelLogAdapter(response.body().getPercelLog());
                    recyclerView.setAdapter(adapter);
                    binding.etInvoiceNo.setText("");
                    binding.etMerchantOrderNo.setText("");



                }
                else {
                    Toast.makeText(Order_Tracking.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                }
                Log.e("tesst",response.toString());
            }

            @Override
            public void onFailure(Call<PercelContainerLog> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("tesst",t.toString());
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}