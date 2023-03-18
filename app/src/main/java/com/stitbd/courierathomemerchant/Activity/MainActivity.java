package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.databinding.ActivityMainBinding;
import com.stitbd.courierathomemerchant.model.Login.LoginContainer;
import com.stitbd.courierathomemerchant.model.Login.MerchantL;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;
import com.stitbd.courierathomemerchant.util.Constant;
import com.stitbd.courierathomemerchant.util.MySharedPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView registration_page;
    Button login_page;
    EditText loginMail, loginPassword;
    private ActivityMainBinding binding;
    Api api;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        String phn=getIntent().getStringExtra(Constant.PHONE);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String Token = MySharedPreference.getInstance(getApplicationContext()).getString(Constant.TOKEN, "not found");
        if (!Token.equals(new String("not found"))) {
            startActivity(new Intent(MainActivity.this, Dashboard.class));
            finish();
        }
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait......");
        progressDialog.setCancelable(false);


        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(binding.loginMail.getText().toString())) {
                    if (!TextUtils.isEmpty(binding.forgetPassword.getText().toString())) {
                        progressDialog.show();
                        api = RetrofitClient.noInterceptor().create(Api.class);
                        Call<LoginContainer> call = api.login(binding.loginMail.getText().toString(),
                                binding.loginPassword.getText().toString());
                        call.enqueue(new Callback<LoginContainer>() {
                            @Override
                            public void onResponse(Call<LoginContainer> call, Response<LoginContainer> response) {
                                  Log.e("tesstlog",response.toString());
                                progressDialog.dismiss();
                                if (response.isSuccessful() && response.body() != null) {
                                    String token = response.body().getToken();
                                    MerchantL merchant = response.body().getMerchant();
                                    Log.e("tesst", token);
//                                    String name = merchant.get("name").getAsString();
//                                    String phn = merchant.get("contact_number").getAsString();
//                                    String MercentId = merchant.get("id").getAsString();
//                                    String Baddress = null;
//                                    if (merchant.get("business_address")!=null){
//                                    Baddress = merchant.get("business_address").getAsString();}
//                                    String address = merchant.get("address").getAsString();


                                    MySharedPreference.getInstance(MainActivity.this).edit()
                                            .putString(Constant.TOKEN, response.body().getToken()).putString(Constant.NAME, response.body().getMerchant().getName()).putString(Constant.PHONE, response.body().getMerchant().getContactNumber())
                                            .putString(Constant.MERCENTID, response.body().getMerchant().getmId()).putString(Constant.BUSINESSADDRESS,response.body().getMerchant().getBusinessAddress()!=null?response.body().getMerchant().getBusinessAddress().toString():" ").
                                            putString(Constant.ADDRESS, response.body().getMerchant().getAddress()).apply();
                                    startActivity(new Intent(MainActivity.this, Dashboard.class));
                                    finish();

                                } else {
                                    progressDialog.dismiss();
                                    Toast.makeText(MainActivity.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<LoginContainer> call, Throwable t) {
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Network or Server Error", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        binding.loginPassword.setError("Please Input Valid email!!");
                        binding.loginPassword.requestFocus();
                    }
                } else {
                    binding.loginMail.setError("Please Input Valid password!!");
                    binding.loginMail.requestFocus();
                }
            }
        });
        binding.registerPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Registration_Page.class));

            }
        });

        binding.forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class));
            }
        });

    }


}