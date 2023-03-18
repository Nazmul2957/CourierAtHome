package com.stitbd.courierathomemerchant.network;

import com.stitbd.courierathomemerchant.model.AreaContainer;
import com.stitbd.courierathomemerchant.model.Coverage.CoverageContainer;
import com.stitbd.courierathomemerchant.model.DashBoardClick.DashboardClickContainer;
import com.stitbd.courierathomemerchant.model.DashBordDataContainer;
import com.stitbd.courierathomemerchant.model.DeliveryPercelList.DeliveryListContainer;
import com.stitbd.courierathomemerchant.model.DistrictsContainer;
import com.stitbd.courierathomemerchant.model.ExtraClass.GetdistrictPackageRate;
import com.stitbd.courierathomemerchant.model.ForgotPassword.ForgetPasswordContainer;
import com.stitbd.courierathomemerchant.model.GetChargeDelivery.ChargeDeliveryAddPercel;
import com.stitbd.courierathomemerchant.model.HoldParcel.HoldParcelModel;
import com.stitbd.courierathomemerchant.model.Login.LoginContainer;
import com.stitbd.courierathomemerchant.model.Payment.PaymentContainer;

import com.stitbd.courierathomemerchant.model.PaymentListDetails.Example;
import com.stitbd.courierathomemerchant.model.PercelContainer;
import com.stitbd.courierathomemerchant.model.PercelDetails.Percel_Details_Container;
import com.stitbd.courierathomemerchant.model.PercelLog.PercelContainerLog;
import com.stitbd.courierathomemerchant.model.Profile.ProfileContainer;
import com.stitbd.courierathomemerchant.model.RegisterResponse;
import com.stitbd.courierathomemerchant.model.UpdateProfile.UpdateProContainer;
import com.stitbd.courierathomemerchant.model.UpdateProfile.UserInfoResponse;
import com.stitbd.courierathomemerchant.model.UpozilasContainer;
import com.stitbd.courierathomemerchant.model.WeightPackageContainer;
import com.google.gson.JsonObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @FormUrlEncoded
    @POST("api/merchant/login")
    Call<LoginContainer> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("api/merchant/forgotPassword")
    Call<ForgetPasswordContainer> forgetPassword(@Field("contact_number") String contact_number);

    @FormUrlEncoded
    @POST("api/merchant/confirmContactNumber")
    Call<JsonObject> otpCheck(@Field("contact_number") String contact_number, @Field("otp_token") String otp_token);

    @FormUrlEncoded
    @POST("api/merchant/confirmForgotPassword")
    Call<JsonObject> confirmPassword(@Field("contact_number") String contact_number, @Field("password") String password);

    ///profile
    @POST("api/merchant")
    Call<ProfileContainer> getprofile();

    @POST("api/merchant/logout")
    Call<JsonObject> logout();

    @POST("api/merchant/dashboard")
    Call<DashBordDataContainer> getDashboarddata();


    @GET("api/getMerchantUpazilaWeightPackageCODAndCharge")
    Call<ChargeDeliveryAddPercel> getcharge(@Query("district_id") int id, @Query("merchant_id") String mid);

    /////weightpackage
    @GET("api/getWeightPackage")
    Call<GetdistrictPackageRate> getcahrges(@Query("weight_package_id") int id, @Query("district_id") int nid);


    @POST("api/merchant/getParcelList")
    Call<PercelContainer> getpercellistdata();


    @FormUrlEncoded
    @POST("api/merchant/filterParcelList")
    Call<DashboardClickContainer> getfilter(@Field("filter_action") String filter_action);

    ////hold parcel
    @FormUrlEncoded
    @POST("api/merchant/parcelHold")
    Call<HoldParcelModel> gethold(@Field("parcel_id") String parcel_id);

    ////hold cancle
    @FormUrlEncoded
    @POST("api/merchant/parcelCancel")
    Call<HoldParcelModel> getcancel(@Field("parcel_id") String parcel_id);

    @FormUrlEncoded
    @POST("api/merchant/parcelStart")
    Call<HoldParcelModel> getplay(@Field("parcel_id") String parcel_id);


///percel list filtering

    @FormUrlEncoded
    @POST("api/merchant/getParcelList")
    Call<PercelContainer> getpercellistByOnlyDate(@Field("from_date") String from_date,
                                                  @Field("to_date") String to_date
    );


    @FormUrlEncoded
    @POST("api/merchant/getParcelList")
    Call<PercelContainer> getpercellistByFiltering(@Field("parcel_status") String parcel_status);

    @FormUrlEncoded
    @POST("software/api/merchant/getParcelList")
    Call<PercelContainer> getpercellistByDate(@Field("parcel_status") String parcel_status, @Field("from_date") String from_date,
                                              @Field("to_date") String to_date, @Field("parcel_invoice") String parcel_invoice,
                                              @Field("merchant_order_id") String merchant_order_id);


    @FormUrlEncoded
    @POST("api/merchant/addParcel")
    Call<JsonObject> addpercel(@Field("merchant_order_id") String merchant_order_id
            , @Field("cod_percent") String cod_percent
            , @Field("cod_charge") String cod_charge
            , @Field("delivery_charge") String delivery_charge
            , @Field("weight_package_charge") String weight_package_charge
            , @Field("merchant_service_area_charge") String merchant_service_area_charge
            , @Field("total_charge") String total_charge
            , @Field("weight_package_id") String weight_package_id
            , @Field("delivery_option_id") String delivery_option_id
            , @Field("product_details") String product_details
            , @Field("total_collect_amount") String total_collect_amount
            , @Field("customer_name") String customer_name
            , @Field("customer_contact_number") String customer_contact_number
            , @Field("customer_address") String customer_address
            , @Field("district_id") String district_id
            , @Field("upazila_id") String upazila_id
            , @Field("area_id") String area_id,
                               @Field("parcel_note") String parcel_note,
                               @Field("pickup_address")String pickup_address);


    @POST("api/merchant/registration")
    Call<RegisterResponse> registration(@Body RequestBody params);



    //common apis
    @GET("api/getDistricts")
    Call<DistrictsContainer> getDistricts();

    @GET("api/getUpazilas")
    Call<UpozilasContainer> getUpazilas(@Query("district_id") int id);

    @GET("api/getAreas")
    Call<AreaContainer> getAreas(@Query("upazila_id") int id);

    @GET("api/getWeightPackages")
    Call<WeightPackageContainer> getWeightPackages();

//    @GET("software/api/getMerchantUpazilaWeightPackageCODAndCharge")
//    Call<WeightPackageContainer> getWeightPackages();

    @GET("api/getMerchantUpazilaWeightPackageCODAndCharge")
    Call<ChargeDeliveryAddPercel> getweight();

    @GET("api/getServiceAreas")
    Call<CoverageContainer> getcoverarea();


    @POST("api/merchant/getDeliveryPaymentList")
    Call<PaymentContainer> getpaymentlist();

    @FormUrlEncoded
    @POST("api/merchant/getParcelPaymentList")
    Call<DeliveryListContainer> getdelivery(@Field("parcel_status") int parcel_status);

    @POST("api/merchant/getParcelPaymentList")
    Call<DeliveryListContainer> getdeliveryWithoutId();

    @FormUrlEncoded
    @POST("api/merchant/getOrderTrackingResult")
    Call<PercelContainerLog> getpercellog(@Field("parcel_invoice") String parcel_invoice,
                                          @Field("merchant_order_id") String merchant_order_id);

    @FormUrlEncoded
    @POST("api/merchant/viewParcel")
    Call<Percel_Details_Container> getperceldetails(@Field("parcel_id") Integer parcel_id);

    @FormUrlEncoded
    @POST("api/merchant/getDeliveryPayment")
    Call<Example> getpaymentsDetails(@Field("id") Integer id);

    @FormUrlEncoded
    @POST("api/merchant/getParcelPaymentList")
    Call<DeliveryListContainer> getdeliverylistBydate(@Field("from_date") String fdate, @Field("to_date") String ldate);

  /*  @FormUrlEncoded
    @POST("software/api/merchant/profileUpdate")
    Call<UpdateProContainer> getproupdate(@Field("company_name")  String company_name,@Field("name") String name,
                                          @Field("email") String email,@Field("image") String image,
                                          @Field("contact_number") String contact_number,
                                          @Field("address") String address,
                                          @Field("business_address") String business_address);*/


    @POST("software/api/merchant/profileUpdate")
    Call<JsonObject> getproupdate(@Body RequestBody params);

    @FormUrlEncoded
    @POST("software/api/merchant/updatePassword")
    Call<UpdateProContainer> getupdatepassword(@Field("current_password") String current_password,
                                               @Field("password") String password);



    @POST("software/api/merchant")
    Call<UserInfoResponse> getUserInfo();

}
