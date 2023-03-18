package com.stitbd.courierathomemerchant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Percel {

//    @SerializedName("success")
//    @Expose
//    private Integer success;
//    @SerializedName("message")
//    @Expose
//    private String message;
//    @SerializedName("parcels")
//    @Expose
//    private List<Percel> percels;
//
//
//    public Integer getSuccess() {
//        return success;
//    }
//
//    public void setSuccess(Integer success) {
//        this.success = success;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public List<Percel> getPercels() {
//        return percels;
//    }
//
//    public void setPercels(List<Percel> percels) {
//        this.percels = percels;
//    }


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("parcel_invoice")
    @Expose
    private String parcelInvoice;
    @SerializedName("customer_name")
    @Expose
    private String customerName;
    @SerializedName("customer_address")
    @Expose
    private String customerAddress;
    @SerializedName("customer_contact_number")
    @Expose
    private String customerContactNumber;

    @SerializedName("total_charge")
    @Expose
    private double totalCharge;

    @SerializedName("district_name")
    @Expose
    private String districtName;
    @SerializedName("upazila_name")
    @Expose
    private String upazilaName;
    @SerializedName("area_name")
    @Expose
    private String areaName;

    @SerializedName("product_details")
    @Expose
    private String product_details;

    @SerializedName("collectable_amount")
    @Expose
    private String collectable_amount;

    @SerializedName("weight_package_name")
    @Expose
    private String weightPackageName;
    @SerializedName("parcel_status")
    @Expose
    private String parcelStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParcelInvoice() {
        return parcelInvoice;
    }

    public void setParcelInvoice(String parcelInvoice) {
        this.parcelInvoice = parcelInvoice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(Double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getUpazilaName() {
        return upazilaName;
    }

    public void setUpazilaName(String upazilaName) {
        this.upazilaName = upazilaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getWeightPackageName() {
        return weightPackageName;
    }

    public void setWeightPackageName(String weightPackageName) {
        this.weightPackageName = weightPackageName;
    }

    public String getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(String parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public String getProduct_details() {
        return product_details;
    }

    public void setProduct_details(String product_details) {
        this.product_details = product_details;
    }

    public String getCollectable_amount() {
        return collectable_amount;
    }

    public void setCollectable_amount(String collectable_amount) {
        this.collectable_amount = collectable_amount;
    }
}
