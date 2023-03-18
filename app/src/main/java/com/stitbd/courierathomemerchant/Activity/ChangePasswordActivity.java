package com.stitbd.courierathomemerchant.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.R;
import com.stitbd.courierathomemerchant.databinding.ActivityChangePasswordBinding;
import com.stitbd.courierathomemerchant.model.UpdateProfile.UpdateProContainer;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;
import com.stitbd.courierathomemerchant.util.MySharedPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {


    Api api;
    ProgressDialog progressDialog;
    EditText Cpass, Npass, COpass;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Update Password");
        progressDialog = new ProgressDialog(ChangePasswordActivity.this);
        progressDialog.setMessage("Please wait.....");

        Cpass = findViewById(R.id.currentPassword);
        Npass = findViewById(R.id.newPassword);
        COpass = findViewById(R.id.confirmPassword);
        save = findViewById(R.id.UpdatePassword);

        api = RetrofitClient.get(getApplicationContext()).create(Api.class);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangePasswordActivity.this, MainActivity.class);
                // startActivity(intent);
                datainitialize();
            }
        });

    }

    public void datainitialize() {
        progressDialog.show();
        if (!TextUtils.isEmpty(Cpass.getText().toString())) {
            if (!TextUtils.isEmpty(Npass.getText().toString())) {
                if (!TextUtils.isEmpty(COpass.getText().toString())) {
                    api.getupdatepassword(Cpass.getText().toString(), Npass.getText().toString()).enqueue(new Callback<UpdateProContainer>() {
                        @Override
                        public void onResponse(Call<UpdateProContainer> call, Response<UpdateProContainer> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                progressDialog.dismiss();
                                MySharedPreference.editor(getApplicationContext()).clear().commit();
                                Intent intent = new Intent(ChangePasswordActivity.this, MainActivity.class);
                                startActivity(intent);

                                Toast.makeText(ChangePasswordActivity.this, "Update Successfully Password", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<UpdateProContainer> call, Throwable t) {

                        }
                    });

                } else {
                    COpass.setError("Please Enter Confirm Password");
                    COpass.requestFocus();
                }
            } else {
                Npass.setError("Please Enter Your New Password");
                Npass.requestFocus();

            }
        } else {
            Cpass.setError("Enter Your Current Password");
            Cpass.requestFocus();


        }

    }

}