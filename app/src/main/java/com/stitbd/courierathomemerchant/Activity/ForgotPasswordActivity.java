package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.model.ForgotPassword.ForgetPasswordContainer;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;
import com.stitbd.courierathomemerchant.util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {

//    private ActivityMainBinding binding;

    EditText Phn;
    Button sendOtp;
    Api api;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        sendOtp = findViewById(R.id.send_otp);
        Phn = findViewById(R.id.phn_no);

        api = RetrofitClient.get(getApplicationContext()).create(Api.class);

        progressDialog = new ProgressDialog(ForgotPasswordActivity.this);
        progressDialog.setMessage("Please wait.....");
        progressDialog.setCancelable(false);

        sendOtp.setOnClickListener(v -> {
            if (!TextUtils.isEmpty(Phn.getText().toString()) && Phn.getText().length() == 11) {
                Log.d("isMethodCalling", "method calling");
                api = RetrofitClient.get(getApplicationContext()).create(Api.class);
                Call<ForgetPasswordContainer> call = api.forgetPassword(Phn.getText().toString());

                call.enqueue(new Callback<ForgetPasswordContainer>() {
                    @Override
                    public void onResponse(Call<ForgetPasswordContainer> call, Response<ForgetPasswordContainer> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Log.d("forgotresponse", response.body().getSuccess() + "");
                            Intent intent = new Intent(ForgotPasswordActivity.this, OTP_Page.class);
                            intent.putExtra(Constant.PHONE, Phn.getText().toString());
                            startActivity(intent);
                            finish();
                        } else
                            Toast.makeText(ForgotPasswordActivity.this, "Failed to send OTP", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ForgetPasswordContainer> call, Throwable t) {
                        Log.d("errorResponse", "response is: " + t.getMessage());
                        Toast.makeText(ForgotPasswordActivity.this, "something wrong......", Toast.LENGTH_SHORT).show();
                    }

                });
            } else {
                Phn.setError("please enter your valid phone no");
                Phn.requestFocus();
            }
        });

    }
}