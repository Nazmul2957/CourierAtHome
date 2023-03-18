package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.Adaptar.DeliveryList.DeliveryAdaptar;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.DeliveryPercelList.DeliveryListContainer;
import com.stitbd.courierathomemerchant.model.PercelStatus;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Delivery_Parcel_list extends AppCompatActivity {


    Api api;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    TextView fromdate, todate;
    Spinner delivery_percelStatus;
    List<PercelStatus> percelStatusList = new ArrayList<>();
    DatePickerDialog datePickerDialog;

    private int mYear, mMonth, mDay;
    Calendar myCalendar;

    Button filter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_parcel_list);

        getSupportActionBar().setTitle("Delivery Parcel List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        long timerforprogressbar = (long) 5000;

        fromdate = findViewById(R.id.from_date);
        todate = findViewById(R.id.to_date_delivery);

        filter = findViewById(R.id.filtering_delivery);

//        delivery_percelStatus = findViewById(R.id.delivery_spinner);


        recyclerView = findViewById(R.id.percellist_show);
        api = RetrofitClient.get(getApplicationContext()).create(Api.class);
        progressDialog = new ProgressDialog(Delivery_Parcel_list.this);
        progressDialog.setMessage("Please wait....");
        progressDialog.setCancelable(false);
        progressDialog.show();


        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(fromdate.getText().toString())) {
                    if (!TextUtils.isEmpty(todate.getText().toString())) {
                        getdata();
                    } else {
                        Toast.makeText(Delivery_Parcel_list.this, "please select To Date", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Delivery_Parcel_list.this, "please select From Date", Toast.LENGTH_SHORT).show();
                }
//                getdata();
            }
        });
        api.getdeliveryWithoutId().enqueue(new Callback<DeliveryListContainer>() {
            @Override
            public void onResponse(Call<DeliveryListContainer> call, Response<DeliveryListContainer> response) {
                progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null) {
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));
                    DeliveryAdaptar dadaptar = new DeliveryAdaptar(response.body().getdelivery());
                    recyclerView.setAdapter(dadaptar);

//                    Log.e("eorrrr", response.toString());
                }
//                Log.e("eorrrr", response.toString());
            }

            @Override
            public void onFailure(Call<DeliveryListContainer> call, Throwable t) {
                progressDialog.dismiss();
//                Log.e("eorrrr", t.toString());

            }
        });

        fromdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                myCalendar = Calendar.getInstance();
                mYear = myCalendar.get(Calendar.YEAR);
                mMonth = myCalendar.get(Calendar.MONTH) ;
                mDay = myCalendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(Delivery_Parcel_list.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                int month=i1+1;
                                fromdate.setText(i + "-" + month + "-" + i2);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });

        todate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCalendar = Calendar.getInstance();
                mYear = myCalendar.get(Calendar.YEAR);
                mMonth = myCalendar.get(Calendar.MONTH) ;
                mDay = myCalendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(Delivery_Parcel_list.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                int month=i1+1;
                                todate.setText(i + "-" + month + "-" + i2);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
//        data();
//        data();
    }

//    public void data() {
//        percelStatusList.add(new PercelStatus(10, "Percel status"));
//        percelStatusList.add(new PercelStatus(0, "All Delivery Type"));
//        percelStatusList.add(new PercelStatus(1, "Complete Delivery"));
//        percelStatusList.add(new PercelStatus(2, "Partial Delivery"));
//        percelStatusList.add(new PercelStatus(3, "Return Parcel"));
//        percelStatusList.add(new PercelStatus(4, "Waiting For Pickup"));
//        percelStatusList.add(new PercelStatus(5, "Waiting For Delivery"));
//        percelStatusList.add(new PercelStatus(6, "Waiting For Return Parcel"));
//        PercelStatusSpinnerAdapter percelStatusSpinnerAdapter =
//                new PercelStatusSpinnerAdapter(percelStatusList, getApplicationContext());
//        delivery_percelStatus.setAdapter(percelStatusSpinnerAdapter);
//    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

//    public void getdata() {
//        progressDialog.show();
//        api.getdelivery(percelStatusList.get(delivery_percelStatus.getSelectedItemPosition()).getId()).enqueue(new Callback<DeliveryListContainer>() {
//            @Override
//            public void onResponse(Call<DeliveryListContainer> call, Response<DeliveryListContainer> response) {
//                progressDialog.dismiss();
//
//                if (response.isSuccessful() && response.body() != null) {
//                    recyclerView.setHasFixedSize(true);
//                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
//                            LinearLayoutManager.VERTICAL, false));
//                    DeliveryAdaptar dadaptar = new DeliveryAdaptar(response.body().getdelivery());
//                    recyclerView.setAdapter(dadaptar);
//                    Log.e("eorrrr", response.toString());
//                }
//                Log.e("eorrrr", response.toString());
//            }
//
//            @Override
//            public void onFailure(Call<DeliveryListContainer> call, Throwable t) {
//                progressDialog.dismiss();
////                Log.e("eorrrr", t.toString());
//
//            }
//        });
//
//    }
public void getdata() {
    progressDialog.show();
    api.getdeliverylistBydate(fromdate.getText().toString(),todate.getText().toString()).enqueue(new Callback<DeliveryListContainer>() {
        @Override
        public void onResponse(Call<DeliveryListContainer> call, Response<DeliveryListContainer> response) {
            progressDialog.dismiss();

            if (response.isSuccessful() && response.body() != null) {
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL, false));
                DeliveryAdaptar dadaptar = new DeliveryAdaptar(response.body().getdelivery());
                recyclerView.setAdapter(dadaptar);
                todate.setText("");
                fromdate.setText("");

            }
            Log.e("eorrrr", response.toString());
        }

        @Override
        public void onFailure(Call<DeliveryListContainer> call, Throwable t) {
            progressDialog.dismiss();
                Log.e("eorrrrrrr", t.toString());
            Toast.makeText(Delivery_Parcel_list.this, "Internet Error", Toast.LENGTH_SHORT).show();

        }
    });

}

}