package com.stitbd.courierathomemerchant.model.DashBoardClick;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashBoardClick {

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
    private String productDetails;
    @SerializedName("weight_package_name")
    @Expose
    private String weightPackageName;
    @SerializedName("weight_package_charge")
    @Expose
    private Integer weightPackageCharge;
    @SerializedName("cod_percent")
    @Expose
    private Integer codPercent;
    @SerializedName("collectable_amount")
    @Expose
    private Integer collectableAmount;
    @SerializedName("collected_amount")
    @Expose
    private Integer collectedAmount;
    @SerializedName("cod_charge")
    @Expose
    private String codCharge;
    @SerializedName("delivery_charge")
    @Expose
    private Integer deliveryCharge;
    @SerializedName("total_charge")
    @Expose
    private String totalCharge;
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

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getWeightPackageName() {
        return weightPackageName;
    }

    public void setWeightPackageName(String weightPackageName) {
        this.weightPackageName = weightPackageName;
    }

    public Integer getWeightPackageCharge() {
        return weightPackageCharge;
    }

    public void setWeightPackageCharge(Integer weightPackageCharge) {
        this.weightPackageCharge = weightPackageCharge;
    }

    public Integer getCodPercent() {
        return codPercent;
    }

    public void setCodPercent(Integer codPercent) {
        this.codPercent = codPercent;
    }

    public Integer getCollectableAmount() {
        return collectableAmount;
    }

    public void setCollectableAmount(Integer collectableAmount) {
        this.collectableAmount = collectableAmount;
    }

    public Integer getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(Integer collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    public String  getCodCharge() {
        return codCharge;
    }

    public void setCodCharge(String codCharge) {
        this.codCharge = codCharge;
    }

    public Integer getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Integer deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(String totalCharge) {
        this.totalCharge = totalCharge;
    }

    public String getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(String parcelStatus) {
        this.parcelStatus = parcelStatus;
    }
}
