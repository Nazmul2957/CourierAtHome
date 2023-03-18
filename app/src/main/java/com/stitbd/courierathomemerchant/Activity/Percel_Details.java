package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.PercelDetails.Percel_Details_Container;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;
import com.stitbd.courierathomemerchant.util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Percel_Details extends AppCompatActivity {

    Api api;
    ProgressDialog progressDialog;

    TextView Percel_invoice, Merchant_id, Merchant_Name,
            Customer_Name, Customer_Address, Phone_No, District_Name, Upazila_Name, Weight_Pckg_Charge,
            Collect_Amount, Cod_Charge, Delivery_Charge, Total_Charge, Percel_Note, Percel_Status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percel_details);


        progressDialog = new ProgressDialog(Percel_Details.this);
        progressDialog.setMessage("Please wait.....");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Product Details");

        api = RetrofitClient.get(getApplicationContext()).create(Api.class);
        int percel_id = getIntent().getIntExtra(Constant.PERCELID, 0);
        Log.e("tesst",String.valueOf(percel_id));

        if (percel_id != 0) {
            progressDialog.show();
            api.getperceldetails(percel_id).enqueue(new Callback<Percel_Details_Container>() {
                @Override
                public void onResponse(Call<Percel_Details_Container> call, Response<Percel_Details_Container> response) {
                    progressDialog.dismiss();
                    try {
                        if (response.isSuccessful() && response.body() != null) {
                            Percel_invoice = findViewById(R.id.percel_invoce_details);
                            Merchant_id = findViewById(R.id.merchant_id_details);
                            Merchant_Name = findViewById(R.id.merchant_name);
                            Customer_Name = findViewById(R.id.customer_name_details);
                            Customer_Address = findViewById(R.id.address_details);
                            Phone_No = findViewById(R.id.phn_no_details);
                            District_Name = findViewById(R.id.district_name_details);
                            Upazila_Name = findViewById(R.id.upazila_name_details);
                            Weight_Pckg_Charge = findViewById(R.id.pckg_charge_details);
                            Collect_Amount = findViewById(R.id.collect_amount_details);
                            Cod_Charge = findViewById(R.id.cod_charge_details);
                            Delivery_Charge = findViewById(R.id.delivery_charge_details);
                            Total_Charge = findViewById(R.id.total_charge_details);
                            Percel_Note = findViewById(R.id.percel_note_details);
                            Percel_Status = findViewById(R.id.percel_status_details);


                            Percel_invoice.setText(response.body().getDetails().getParcel_invoice());
                            Merchant_Name.setText(response.body().getDetails().getMerchant_name());
                            Customer_Name.setText(response.body().getDetails().getCustomer_name());
                            Customer_Address.setText(response.body().getDetails().getCustomer_address());
                            Phone_No.setText(response.body().getDetails().getCustomer_contact_number());
                            District_Name.setText(response.body().getDetails().getDistrict_name());
                            Upazila_Name.setText(response.body().getDetails().getUpazila_name());
                            Weight_Pckg_Charge.setText(response.body().getDetails().getWeight_package_charge());
                            Collect_Amount.setText(response.body().getDetails().getCollectable_amount());
                            Cod_Charge.setText(response.body().getDetails().getCod_charge());
                            Delivery_Charge.setText(response.body().getDetails().getDelivery_charge());
                            Total_Charge.setText(response.body().getDetails().getTotal_charge());
                            Percel_Note.setText(response.body().getDetails().getParcel_note());
                            Percel_Status.setText(response.body().getDetails().getParcel_status());
                            Merchant_id.setText(response.body().getDetails().getMerchant_order_id());


//                            Log.e("percelDetails", response.toString());

                        }


                    } catch (Exception e) {
//                        Log.e("tesst", e.toString());
                        Toast.makeText(Percel_Details.this, "Something Wrong...", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Percel_Details_Container> call, Throwable t) {
                    Log.e("tesst", t.toString());
                    progressDialog.dismiss();
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