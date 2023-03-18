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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTP_Page extends AppCompatActivity {

    Button submit_otp;
    Api api;
    EditText otp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_page);
        submit_otp= findViewById(R.id.submit_otp_page);
        otp=findViewById(R.id.otp_number_input);

        api= RetrofitClient.noInterceptor().create(Api.class);
        String phn=getIntent().getStringExtra(Constant.PHONE);
        submit_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(otp.getText().toString())) {
                    api.otpCheck(phn,otp.getText().toString()).enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                            if (response.isSuccessful()&& response.body()!=null){
                                Toast.makeText(OTP_Page.this,"otp match",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(OTP_Page.this,Reset_Password_Page.class);
                                intent.putExtra(Constant.PHONE,phn);
                                intent.putExtra(Constant.OTPTOKEN,otp.getText().toString());
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(OTP_Page.this,"otp does not match",Toast.LENGTH_LONG).show();

                            }
                            Log.e("tesst",response.toString());
                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {
                            Toast.makeText(OTP_Page.this,"Something wrong.....",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else{
                    otp.setError("please enter otp code");
                    otp.requestFocus();
                }



            }
        });


    }
}