package com.stitbd.courierathomemerchant.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.widget.AdapterView;
import android.widget.Toast;

import com.stitbd.courierathomemerchant.Adaptar.AreaSpinnerAdapter;
import com.stitbd.courierathomemerchant.Adaptar.DistrictSpinnerAdaptar;
import com.stitbd.courierathomemerchant.Adaptar.UpozilaSpinnerAdaptar;
import com.stitbd.courierathomemerchant.databinding.ActivityMainBinding;
import com.stitbd.courierathomemerchant.databinding.ActivityRegistrationPageBinding;
import com.stitbd.courierathomemerchant.model.Area;
import com.stitbd.courierathomemerchant.model.AreaContainer;
import com.stitbd.courierathomemerchant.model.District;
import com.stitbd.courierathomemerchant.model.DistrictsContainer;
import com.stitbd.courierathomemerchant.model.RegisterResponse;
import com.stitbd.courierathomemerchant.model.Upozila;
import com.stitbd.courierathomemerchant.model.UpozilasContainer;
import com.stitbd.courierathomemerchant.network.Api;
import com.stitbd.courierathomemerchant.network.RetrofitClient;
import com.stitbd.courierathomemerchant.util.Constant;
import com.stitbd.courierathomemerchant.util.MySharedPreference;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration_Page extends AppCompatActivity {
    ActivityRegistrationPageBinding binding;
    File f1nid, f3trade, f4tin;
    boolean isNid1 = false, isTrade = false, isTin = false;
    Bitmap bitmap;
    Uri imageUriNid = null, imageUriTrade = null, imageUriTin = null;
    Api api;
    ProgressDialog progressDialog;
    List<District> districts;
    List<Upozila> upozilaList;
    List<Area> areas;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private static final int SELECT_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(Registration_Page.this);
        progressDialog.setMessage("Please Wait......");
        progressDialog.setCancelable(false);
        districts = new ArrayList<>();
        upozilaList = new ArrayList<>();
        areas = new ArrayList<>();


        binding.nidSideOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permison(Constant.PICK_PHOTO_ONE);
            }
        });


        binding.tradeLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                permison(Constant.PICK_PHOTO_THREE);
            }
        });

        binding.tinNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permison(Constant.PICK_PHOTO_FOUR);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 201);
        }

        api = RetrofitClient.difBaseUrle().create(Api.class);

        getDistrict();

        //==========Spinner Listener======================
        binding.districtSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("tesst", String.valueOf(binding.districtSp.getSelectedItemId()));
                if (binding.districtSp.getSelectedItemId() != 0) {
                    getUpozila(districts.get(i).getId());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.upozilaSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("tesst", upozilaList.get(i).getName());
                if (binding.upozilaSp.getSelectedItemId() != 0) {
                    getAreas(upozilaList.get(i).getId());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


//===========Buttons===========================
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataValidation();
            }
        });


        binding.backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }


//========setup Spinner==========================

    private void getDistrict() {
        progressDialog.show();

        api.getDistricts().enqueue(new Callback<DistrictsContainer>() {

            @Override
            public void onResponse(Call<DistrictsContainer> call, Response<DistrictsContainer> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {

                    districts = response.body().getDistricts();
                    districts.add(0, new District(0, "District"));

                    DistrictSpinnerAdaptar customeAdapterForSpinner = new DistrictSpinnerAdaptar(districts, getApplicationContext());
                    binding.districtSp.setAdapter(customeAdapterForSpinner);


                }
            }

            @Override
            public void onFailure(Call<DistrictsContainer> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }

    private void getUpozila(Integer id) {
        progressDialog.show();
        api.getUpazilas(id).enqueue(new Callback<UpozilasContainer>() {
            @Override
            public void onResponse(Call<UpozilasContainer> call, Response<UpozilasContainer> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {

                    upozilaList = response.body().getUpozilaList();
                    upozilaList.add(0, new Upozila(0, "Upazila"));
                    UpozilaSpinnerAdaptar customeAdapterForSpinner = new UpozilaSpinnerAdaptar(upozilaList, getApplicationContext());
                    binding.upozilaSp.setAdapter(customeAdapterForSpinner);

                }
            }

            @Override
            public void onFailure(Call<UpozilasContainer> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }

    private void getAreas(Integer id) {

        progressDialog.show();
        api.getAreas(id).enqueue(new Callback<AreaContainer>() {
            @Override
            public void onResponse(Call<AreaContainer> call, Response<AreaContainer> response) {

                progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null) {

                    areas = response.body().getArealist();
                    areas.add(0, new Area(0, "Area"));
                    AreaSpinnerAdapter areaSpinnerAdapter = new AreaSpinnerAdapter(areas, getApplicationContext());
                    binding.areaSp.setAdapter(areaSpinnerAdapter);
                    areas = response.body().getArealist();
                }

            }

            @Override
            public void onFailure(Call<AreaContainer> call, Throwable t) {

                progressDialog.dismiss();
            }
        });

    }


    //================dataValidation======================
    private void dataValidation() {
        Log.e("toos", "dfjkdj");
        if (!TextUtils.isEmpty(binding.companyName.getText().toString())) {
            if (!TextUtils.isEmpty(binding.merchantName.getText().toString())) {
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (!TextUtils.isEmpty(binding.mailAddress.getText().toString()) && binding.mailAddress.getText().toString().matches(emailPattern)) {
                    if (!TextUtils.isEmpty(binding.phnNumber.getText().toString())) {
                        if (binding.districtSp.getSelectedItemPosition() > 0) {
                            if (binding.upozilaSp.getSelectedItemPosition() > 0) {
                                if (binding.areaSp.getSelectedItemPosition() > 0) {

                                    if (!TextUtils.isEmpty(binding.mailAddress.getText().toString())) {
//                                        Log.e("toos", "from vitre");
                                        if (!TextUtils.isEmpty(binding.enterBusinessArea.getText().toString())) {
                                            if (!TextUtils.isEmpty(binding.facebookLink.getText().toString())) {

                                                if (!TextUtils.isEmpty(binding.enterPassword.getText().toString())) {
//                                                    Log.e("toos", "from vitre");
                                                    register();

                                                } else {
                                                    binding.enterPassword.setError("Please Input a valid Email Address");
                                                    binding.enterPassword.requestFocus();
                                                }
//nid

                                            } else {
                                                binding.facebookLink.setError("Please Input a valid Email Address");
                                                binding.facebookLink.requestFocus();
                                            }

                                        } else {
                                            binding.enterBusinessArea.setError("Please Input a valid Email Address");
                                            binding.enterBusinessArea.requestFocus();
                                        }

                                    } else {
                                        binding.enterAddress.setError("Please Input a valid Email Address");
                                        binding.enterAddress.requestFocus();
                                    }

                                } else {
                                    Toast.makeText(getApplicationContext(), "Please Select Area", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Please Select Upazila", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Please Select a district", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        binding.phnNumber.setError("Please Input a valid Email Address");
                        binding.phnNumber.requestFocus();
                    }
                } else {
                    binding.mailAddress.setError("Please Input a valid Email Address");
                    binding.mailAddress.requestFocus();
                }
            } else {
                binding.merchantName.setError("Please Input a Merchant name");
                binding.merchantName.requestFocus();
            }
        } else {
            binding.companyName.setError("Please Input a Company name");
            binding.companyName.requestFocus();
        }


    }


    private void register() {
        progressDialog.show();
        RequestBody requestBody;
        String tinpicname = "";
        String nidpicName = "";
        RequestBody requestNid1 = null;
        RequestBody requesttin = null;
        RequestBody attachmentEmpty = RequestBody.create(MediaType.parse("text/plain"), "");

        if (imageUriNid != null) {
            File nidfile = new File(imageUriNid.getLastPathSegment().toString());
            nidpicName = nidfile.getName();
            requestNid1 = RequestBody.create(MediaType.parse("multipart/form-data"), f1nid);
        }

        requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("company_name", binding.companyName.getText().toString())
                .addFormDataPart("name", binding.merchantName.getText().toString())
                .addFormDataPart("email", binding.mailAddress.getText().toString())
                .addFormDataPart("contact_number", binding.phnNumber.getText().toString())
                .addFormDataPart("district_id", String.valueOf(districts.get(binding.districtSp.getSelectedItemPosition()).getId()))
                .addFormDataPart("upazila_id", String.valueOf(upozilaList.get(binding.upozilaSp.getSelectedItemPosition()).getId()))
                .addFormDataPart("area_id", String.valueOf(areas.get(binding.areaSp.getSelectedItemPosition()).getId()))
                .addFormDataPart("password", binding.enterPassword.getText().toString())
                .addFormDataPart("address", binding.enterAddress.getText().toString())
                .addFormDataPart("business_address", binding.enterBusinessArea.getText().toString())
                .addFormDataPart("fb_url", binding.facebookLink.getText().toString())
                .addFormDataPart("web_url", binding.websitLink.getText().toString())
                .addFormDataPart("bank_account_name", binding.accountName.getText().toString())
                .addFormDataPart("bank_name", binding.bankName.getText().toString())
                .addFormDataPart("bank_account_no", binding.accountNumber.getText().toString())
                .addFormDataPart("bkash_number", binding.bkashNumber.getText().toString())
                .addFormDataPart("nagad_number", binding.nagadNumber.getText().toString())
                .addFormDataPart("rocket_name", binding.rocketNumber.getText().toString())
                .addFormDataPart("nid_no", binding.nidNo.getText().toString())
                .addFormDataPart("nid_card", nidpicName, requestNid1 != null ? requestNid1 : attachmentEmpty)
//                .addFormDataPart("trade_license", tradpicname, requesttrade != null ? requesttrade : attachmentEmpty)
                .addFormDataPart("tin_certificate", tinpicname, requesttin != null ? requesttin : attachmentEmpty)
                .build();
        Log.d("tesst", "form if");


        api = RetrofitClient.noInterceptor().create(Api.class);

        api.registration(requestBody).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                progressDialog.dismiss();
                // Log.e("toos", "from  register " + response.toString());
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(Registration_Page.this, "", Toast.LENGTH_LONG).show();
                    MySharedPreference.getInstance(Registration_Page.this).edit()
                            .putString(Constant.TOKEN, response.body().getToken())
                            .putString(Constant.NAME, binding.merchantName.getText().toString()).
                            putString(Constant.PHONE, binding.phnNumber.getText().toString()).apply();
                    Intent intent = new Intent(Registration_Page.this, OtpRegistrationConfirm.class);
                    intent.putExtra(Constant.PHONE, binding.phnNumber.getText().toString());
                    startActivity(new Intent(Registration_Page.this, OtpRegistrationConfirm.class));
                    startActivity(intent);
                    finish();
                } else {
                    try {
                        Log.d("tesst", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(Registration_Page.this, "Registration failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override

            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                progressDialog.dismiss();
                Log.d("tesst", t.toString());
                Toast.makeText(Registration_Page.this, "Registration failed" + t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
                binding.nidPic.setVisibility(View.VISIBLE);
                binding.nidoneLicensePic.setImageBitmap(bitmap);
            } else {
                Log.e("REQ", "Bitmap null");
            }


        } else if (resultCode == RESULT_OK && requestCode == Constant.PICK_PHOTO_THREE && data != null) {
            imageUriTrade = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUriTrade);
                f3trade = new File(getCacheDir(), "Image3");
                bitmap = getResizedBitmap(bitmap, 800);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos);
                // bitmap.compress(Bitmap.CompressFormat.JPEG, 0 /*ignored for PNG*/, bos);
                byte[] bitmapdata = bos.toByteArray();
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(f3trade);

                } catch (FileNotFoundException e) {
                    Log.e("REQ", e.toString());
                }
                try {
                    fos.write(bitmapdata);
                    fos.flush();
                    fos.close();
                    isTrade = true;
                } catch (IOException e) {
                    Log.e("REQ", e.toString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (bitmap != null) {
                binding.tradeLicensePic.setImageBitmap(bitmap);
                binding.tradePic.setVisibility(View.VISIBLE);
            } else {
                Log.e("REQ", "Bitmap null");
            }

        } else if (resultCode == RESULT_OK && requestCode == Constant.PICK_PHOTO_FOUR && data != null) {
            imageUriTin = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUriTin);
                f4tin = new File(getCacheDir(), "Image4");
                bitmap = getResizedBitmap(bitmap, 800);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos);
                // bitmap.compress(Bitmap.CompressFormat.JPEG, 0 /*ignored for PNG*/, bos);
                byte[] bitmapdata = bos.toByteArray();


                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(f4tin);

                } catch (FileNotFoundException e) {
                    Log.e("REQ", e.toString());
                }
                try {
                    fos.write(bitmapdata);
                    fos.flush();
                    fos.close();
                    isTin = true;
                } catch (IOException e) {
                    Log.e("REQ", e.toString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (bitmap != null) {
                binding.tinLicensePic.setImageBitmap(bitmap);
                binding.tinPic.setVisibility(View.VISIBLE);
            } else {
                Log.e("REQ", "Bitmap null");
            }

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

    void permison(int requestcode) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 201);

        } else {
           // Log.e("REQ", "Inside");
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            /*Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);*/
            //intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
            startActivityForResult(intent, requestcode);
        }
    }
}