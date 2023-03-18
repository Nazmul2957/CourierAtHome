package com.stitbd.courierathomemerchant.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.stitbd.courierathomemerchant.databinding.ActivityAddParcelBinding;
import com.stitbd.courierathomemerchant.databinding.ActivityUpdateProfileBinding;
import com.stitbd.courierathomemerchant.model.UpdateProfile.Merchant;
import com.stitbd.courierathomemerchant.model.UpdateProfile.UserInfoResponse;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;
import com.stitbd.courierathomemerchant.util.Constant;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateProfileActivity extends AppCompatActivity {

    Api api;
    ProgressDialog progressDialog;
    ActivityUpdateProfileBinding binding;
    Bitmap bitmap;
    boolean isNid1 = false;
    Uri imageUriNid = null;
    File f1nid;
    Uri uri;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Update Profile");
        progressDialog = new ProgressDialog(UpdateProfileActivity.this);
        progressDialog.setMessage("Please wait.....");
        api = RetrofitClient.get(getApplicationContext()).create(Api.class);

        datainitilize();


        binding.takeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                permison(Constant.PICK_PHOTO_ONE);
            }
        });


        binding.profileSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataValidation();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 201);
        }

    }


    public void datainitilize() {
        progressDialog.show();
        api.getUserInfo().enqueue(new Callback<UserInfoResponse>() {
            @Override
            public void onResponse(Call<UserInfoResponse> call, Response<UserInfoResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    Merchant merchant = response.body().getMerchant();

                    binding.takeAddress.setText(merchant.getAddress());
                    binding.takeCName.setText(merchant.getCompanyName());
                    binding.takeEmail.setText(merchant.getEmail());
                    binding.takeBaddress.setText(merchant.getBusinessAddress());
                    binding.takeName.setText(merchant.getName());
                    binding.takePhn.setText(merchant.getContactNumber());
                } else {
                    Toast.makeText(UpdateProfileActivity.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserInfoResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(UpdateProfileActivity.this, "Something Wrong" + t.toString(), Toast.LENGTH_SHORT).show();

            }
        });


    }


    private void dataValidation() {
        if (!TextUtils.isEmpty(binding.takeName.getText().toString())) {
            if (!TextUtils.isEmpty(binding.takeEmail.getText().toString())) {
                if (!TextUtils.isEmpty(binding.takePhn.getText().toString())) {
                    if (!TextUtils.isEmpty(binding.takeCName.getText().toString())) {
                        if (!TextUtils.isEmpty(binding.takeAddress.getText().toString())) {
                            if (!TextUtils.isEmpty(binding.takeBaddress.getText().toString())) {
                                Upadate();
                            } else {
                                binding.takeBaddress.setError("Please Inpute your address");
                                binding.takeBaddress.requestFocus();
                            }
                        } else {
                            binding.takeAddress.setError("Please Inpute your address");
                            binding.takeAddress.requestFocus();
                        }
                    } else {
                        binding.takeCName.setError("Please Enter your Name");
                        binding.takeCName.requestFocus();
                    }
                } else {
                    binding.takePhn.setError("Please Enter your Name");
                    binding.takePhn.requestFocus();
                }

            } else {
                binding.takeEmail.setError("Please Enter your Name");
                binding.takeEmail.requestFocus();
            }

        } else {
            binding.takeName.setError("Please Enter your Name");
            binding.takeName.requestFocus();
        }
    }

    private void Upadate() {

        progressDialog.show();
        RequestBody requestBody;

        String nidpicName = "";
        RequestBody requestNid1 = null;
        RequestBody attachmentEmpty = RequestBody.create(MediaType.parse("text/plain"), "");
        if (imageUriNid != null) {
            File nidfile = new File(imageUriNid.getLastPathSegment().toString());
            nidpicName = nidfile.getName();

            requestNid1 =
                    RequestBody.create(MediaType.parse("multipart/form-data"), f1nid);
        }

        requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("company_name", binding.takeCName.getText().toString())
                .addFormDataPart("contact_number", binding.takePhn.getText().toString())
                .addFormDataPart("name", binding.takeName.getText().toString())
                .addFormDataPart("business_address", binding.takeBaddress.getText().toString())
                .addFormDataPart("address", binding.takeAddress.getText().toString())
                .addFormDataPart("email", binding.takeEmail.getText().toString())
                .addFormDataPart("image", nidpicName, requestNid1 != null ? requestNid1 : attachmentEmpty)
                .build();


        api.getproupdate(requestBody).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {

                    Toast.makeText(UpdateProfileActivity.this, "Update successfully", Toast.LENGTH_SHORT).show();

                    finish();
                } else {
//                    try {
//                        Log.e("tesst", response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(UpdateProfileActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    void permison(int requestcode) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 201);

        } else {
            Log.e("REQ", "Inside");
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            /*Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);*/
            //intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
            startActivityForResult(intent, requestcode);
        }
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap b;
        if (resultCode == RESULT_OK && requestCode == Constant.PICK_PHOTO_ONE && data != null) {

            imageUriNid = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUriNid);

                f1nid = new File(getCacheDir(), "Image1");
                bitmap = getResizedBitmap(bitmap, 800);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos);
                // bitmap.compress(Bitmap.CompressFormat.JPEG, 0 /*ignored for PNG*/, bos);
                byte[] bitmapdata = bos.toByteArray();


                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(f1nid);

                } catch (FileNotFoundException e) {
                    Log.e("REQ", e.toString());
                }
                try {
                    fos.write(bitmapdata);
                    fos.flush();
                    fos.close();
                    isNid1 = true;
                } catch (IOException e) {
                    Log.e("REQ", e.toString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (bitmap != null) {
                //binding.nidPic.setVisibility(View.VISIBLE);
                binding.profilePic.setImageBitmap(bitmap);
            } else {
                Log.e("REQ", "Bitmap null");
            }


        }


    }
}
