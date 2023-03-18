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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.Adaptar.PercelListAdapter;
import com.stitbd.courierathomemerchant.Adaptar.PercelStatusSpinnerAdapter;
import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.PercelContainer;
import com.stitbd.courierathomemerchant.model.PercelStatus;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Parcel_list_show extends AppCompatActivity {
    Api api;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    Spinner percelStatus;
    TextView startdate, enddate;
    EditText invoiceEt, mercentEt;
    List<PercelStatus> percelStatusList = new ArrayList<>();
    Calendar myCalendar;
    DatePickerDialog datePickerDialog;
    Button search;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcel_list_show);
        search = findViewById(R.id.searchBtn);
        recyclerView = findViewById(R.id.percel);
        startdate = findViewById(R.id.starting_dateEt);
        enddate = findViewById(R.id.end_dateEt);
        invoiceEt = findViewById(R.id.invoiceEt);
        mercentEt = findViewById(R.id.mercent_odrEt);
        percelStatus = findViewById(R.id.percel_status_spiner);

        getSupportActionBar().setTitle("Parcel List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        api = RetrofitClient.get(getApplicationContext()).create(Api.class);

        startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // TODO Auto-generated method stub
                myCalendar = Calendar.getInstance();
                mYear = myCalendar.get(Calendar.YEAR);
                mMonth = myCalendar.get(Calendar.MONTH) ;
                mDay = myCalendar.get(Calendar.DAY_OF_MONTH);


                datePickerDialog = new DatePickerDialog(Parcel_list_show.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                int month=i1+1;
                                startdate.setText(i + "-" + month + "-" + i2);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
//                // TODO Auto-generated method stub
//                myCalendar = Calendar.getInstance();
//                mYear = myCalendar.get(Calendar.YEAR);
//                mMonth = myCalendar.get(Calendar.MONTH) +1;
//                mDay = myCalendar.get(Calendar.DAY_OF_MONTH);
//                datePickerDialog = new DatePickerDialog(Parcel_list_show.this,
//                        new DatePickerDialog.OnDateSetListener() {
//                            @Override
//                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//                                startdate.setText(mYear + "-" + mMonth + "-" + mDay);
//                                ;
//                            }
//                        }, mYear, mMonth, mDay);
//                datePickerDialog.show();
            }

        });

        enddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myCalendar = Calendar.getInstance();
                mYear = myCalendar.get(Calendar.YEAR);
                mMonth = myCalendar.get(Calendar.MONTH) ;
                mDay = myCalendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(Parcel_list_show.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                int month=i1+1;
                                enddate.setText(i + "-" + month + "-" + i2);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
//                myCalendar = Calendar.getInstance();
//                mYear = myCalendar.get(Calendar.YEAR);
//                mMonth = myCalendar.get(Calendar.MONTH) +1;
//                mDay = myCalendar.get(Calendar.DAY_OF_MONTH);
//                datePickerDialog = new DatePickerDialog(Parcel_list_show.this,
//                        new DatePickerDialog.OnDateSetListener() {
//                            @Override
//                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//                                enddate.setText(mYear + "-" + mMonth + "-" + mDay);
//                            }
//                        }, mYear, mMonth, mDay);
//                datePickerDialog.show();
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datavalidation();
            }
        });

        dataInitialize();

    }


    private void dataInitialize() {
        progressDialog = new ProgressDialog(Parcel_list_show.this);
        progressDialog.setMessage("Please Wait......");
        progressDialog.setCancelable(false);
        progressDialog.show();
        api.getpercellistdata().enqueue(new Callback<PercelContainer>() {
            @Override
            public void onResponse(Call<PercelContainer> call, Response<PercelContainer> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));

                    PercelListAdapter adapter = new PercelListAdapter(response.body().getPercels(),
                            getApplicationContext(), new PercelListAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            dataInitialize();
                        }
                    });
                    recyclerView.setAdapter(adapter);
                    Log.e("eorrrr", response.toString());
                } else {
                    try {
                        Toast.makeText(Parcel_list_show.this, "something wrong" + response.errorBody().string(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.e("eorrrr", response.toString());
                }
            }

            @Override
            public void onFailure(Call<PercelContainer> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(Parcel_list_show.this, "something wrong", Toast.LENGTH_SHORT).show();
            }
        });

        percelStatusList.add(new PercelStatus(10, "Parcel status"));
//        percelStatusList.add(new PercelStatus(0, "All Delivery Type"));
        percelStatusList.add(new PercelStatus(1, "Complete Delivery"));
        percelStatusList.add(new PercelStatus(2, "Delivery Pending"));
        percelStatusList.add(new PercelStatus(3, "Delivery Cancle"));
        percelStatusList.add(new PercelStatus(4, "Payment Done"));
        percelStatusList.add(new PercelStatus(5, "Payment Pending"));
        percelStatusList.add(new PercelStatus(6, "Return Complete"));
        percelStatusList.add(new PercelStatus(7, "Pickup Request"));
        PercelStatusSpinnerAdapter percelStatusSpinnerAdapter =
                new PercelStatusSpinnerAdapter(percelStatusList, getApplicationContext());
        percelStatus.setAdapter(percelStatusSpinnerAdapter);


    }

    private void datavalidation() {

        if (percelStatus.getSelectedItemPosition() > 0) {
//            if (!TextUtils.isEmpty(invoiceEt.getText().toString())) {
//                if (!TextUtils.isEmpty(mercentEt.getText().toString())) {
            if (!TextUtils.isEmpty(startdate.getText().toString())) {
                if (!TextUtils.isEmpty(enddate.getText().toString())) {

                    api.getpercellistByDate(String.valueOf(percelStatusList.get(percelStatus.getSelectedItemPosition())
                                    .getId()),
                            startdate.getText().toString(),
                            enddate.getText().toString(),invoiceEt.getText().toString(),mercentEt.getText().toString()
                    ).enqueue(new Callback<PercelContainer>() {
                        @Override
                        public void onResponse(Call<PercelContainer> call, Response<PercelContainer> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                progressDialog.dismiss();
                                if (response.isSuccessful() && response.body() != null) {
                                    recyclerView.setHasFixedSize(true);
                                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                                    PercelListAdapter adapter = new PercelListAdapter(response.body().getPercels(), Parcel_list_show.this, new PercelListAdapter.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(int position) {
                                            dataInitialize();
                                        }
                                    });
                                    recyclerView.setAdapter(adapter);
                                    startdate.setText("");
                                    enddate.setText("");
                                    invoiceEt.setText("");
                                    mercentEt.setText("");
//                                            Log.e("eorrrr", response.toString());
                                } else {

                                        Toast.makeText(Parcel_list_show.this, "something wrong", Toast.LENGTH_SHORT).show();


                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<PercelContainer> call, Throwable t) {
                            Toast.makeText(Parcel_list_show.this, "something wrong", Toast.LENGTH_SHORT).show();

                        }
                    });

                } else {
                    enddate.setError("Please Input End Date");
                    enddate.requestFocus();
                }
            } else {
                progressDialog.show();

                api.getpercellistByFiltering(String.valueOf(percelStatusList.get(percelStatus.getSelectedItemPosition()).getId()))
                        .enqueue(new Callback<PercelContainer>() {
                    @Override
                    public void onResponse(Call<PercelContainer> call, Response<PercelContainer> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            progressDialog.dismiss();
                            if (response.isSuccessful() && response.body() != null) {
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                                        LinearLayoutManager.VERTICAL, false));
                                PercelListAdapter adapter = new PercelListAdapter(response.body().getPercels(), Parcel_list_show.this, new PercelListAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(int position) {
                                        dataInitialize();
                                    }
                                });
                                recyclerView.setAdapter(adapter);
                            } else {
                                    Toast.makeText(Parcel_list_show.this, "something wrong" , Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<PercelContainer> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(Parcel_list_show.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                    }
                });

            }

        } else {


            if (!TextUtils.isEmpty(startdate.getText().toString())) {
                if (!TextUtils.isEmpty(enddate.getText().toString())) {
                    api.getpercellistByOnlyDate(startdate.getText().toString(),enddate.getText().toString()).enqueue(new Callback<PercelContainer>() {
                        @Override
                        public void onResponse(Call<PercelContainer> call, Response<PercelContainer> response) {
                            progressDialog.dismiss();
                            if (response.isSuccessful()&& response.body()!=null){
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                                PercelListAdapter adapter = new PercelListAdapter(response.body().getPercels(), Parcel_list_show.this, new PercelListAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(int position) {
                                        dataInitialize();
                                    }
                                });
                                recyclerView.setAdapter(adapter);
                                startdate.setText("");
                                enddate.setText("");
                                invoiceEt.setText("");
                                mercentEt.setText("");

                                Log.e("date1", response.toString());
                            }
                        }

                        @Override
                        public void onFailure(Call<PercelContainer> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(Parcel_list_show.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                        }
                    });{

                    }


                }
                else {
                    enddate.setError("Please Input End Date");
                    enddate.requestFocus();

                }
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}