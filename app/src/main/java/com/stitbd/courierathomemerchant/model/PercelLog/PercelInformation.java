package com.stitbd.courierathomemerchant.model.PercelLog;

import com.stitbd.courierathomemerchant.model.WeightPackage;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PercelInformation {
    @SerializedName("parcel_invoice")
    @Expose
    private String parcelInvoice;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("merchant_order_id")
    @Expose
    private String order_id;

    @SerializedName("delivery_date")
    @Expose
    private Object deliveryDate;
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
    private Double totalCharge;
    @SerializedName("merchant_paid_amount")
    @Expose
    private Integer merchantPaidAmount;
    @SerializedName("parcel_date")
    @Expose
    private String parcelDate;
    @SerializedName("delivery_type")
    @Expose
    private String deliveryType;

    @SerializedName("delivery_charge")
    @Expose
    private String deliveryCharge;




    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("weight_package")
    @Expose
    private WeightPackage weight_package;

    public WeightPackage getWeight_package() {
        return weight_package;
    }

    public void setWeight_package(WeightPackage weight_package) {
        this.weight_package = weight_package;
    }

    public String getParcelInvoice() {
        return parcelInvoice;
    }

    public void setParcelInvoice(String parcelInvoice) {
        this.parcelInvoice = parcelInvoice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Object deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public Double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(Double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public Integer getMerchantPaidAmount() {
        return merchantPaidAmount;
    }

    public void setMerchantPaidAmount(Integer merchantPaidAmount) {
        this.merchantPaidAmount = merchantPaidAmount;
    }

    public String getParcelDate() {
        return parcelDate;
    }

    public void setParcelDate(String parcelDate) {
        this.parcelDate = parcelDate;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(String deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
}
