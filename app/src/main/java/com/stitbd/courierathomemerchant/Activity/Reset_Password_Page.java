package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;
import com.stitbd.courierathomemerchant.util.Constant;
import com.google.gson.JsonObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Reset_Password_Page extends AppCompatActivity {

    EditText new_Password;
    EditText confirm_Password;
    Button submit_Reset_Password;
    Api api;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_page);

        new_Password=findViewById(R.id.new_password);
        confirm_Password=findViewById(R.id.confirm_password);
        submit_Reset_Password=findViewById(R.id.submit_reset_password);
        
        api= RetrofitClient.noInterceptor().create(Api.class);
        String phn=getIntent().getStringExtra(Constant.PHONE);
//        String otp=getIntent().getStringExtra(Constant.OTPTOKEN);
        


        submit_Reset_Password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (!TextUtils.isEmpty(new_Password.getText().toString())){
                  if (!TextUtils.isEmpty(confirm_Password.getText().toString())){
                      if (new_Password.getText().toString().equals(confirm_Password.getText().toString())){
                          api.confirmPassword(phn,confirm_Password.getText().toString()).enqueue(new Callback<JsonObject>() {
                              @Override
                              public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                  if (response.isSuccessful()&& response.body()!=null){
                                      Toast.makeText(Reset_Password_Page.this, "Successfully password change", Toast.LENGTH_SHORT).show();
                                      startActivity(new Intent(Reset_Password_Page.this,MainActivity.class));
                                      finish();
                                  }
                                  else {
                                      try {
                                          Log.d("tesst",response.errorBody().string());
                                      } catch (IOException e) {
                                          e.printStackTrace();
                                      }
                                      Toast.makeText(Reset_Password_Page.this, "Password dost not match in", Toast.LENGTH_LONG).show();
                                  }
                                  Log.e("tesst",response.toString());
                              }

                              @Override
                              public void onFailure(Call<JsonObject> call, Throwable t) {
                                  Toast.makeText(Reset_Password_Page.this, "Something wrong....", Toast.LENGTH_LONG).show();
                              }
                          });
                      }
                      else {
                          Toast.makeText(Reset_Password_Page.this, "Password Does not match out", Toast.LENGTH_SHORT).show();
                      }
                  }else 
                  {
                      confirm_Password.setError("enter your confirm password");
                      confirm_Password.requestFocus();
                  }
              }
              else
              {
                  new_Password.setError("enter your new password");
                  new_Password.requestFocus();
              }
            }
        });


    }
}