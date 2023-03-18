package com.stitbd.courierathomemerchant.model.DeliveryPercelList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryPercelList {

    @SerializedName("parcel_id")
    @Expose
    private Integer parcelId;
    @SerializedName("parcel_invoice")
    @Expose
    private String parcelInvoice;
    @SerializedName("total_collect_amount")
    @Expose
    private Integer totalCollectAmount;
    @SerializedName("cod_percent")
    @Expose
    private Integer codPercent;
    @SerializedName("cod_charge")
    @Expose
    private Double codCharge;
    @SerializedName("weight_package_charge")
    @Expose
    private Integer weightPackageCharge;
    @SerializedName("delivery_charge")
    @Expose
    private Integer deliveryCharge;
    @SerializedName("return_charge")
    @Expose
    private Integer returnCharge;
    @SerializedName("customer_collect_amount")
    @Expose
    private Integer customerCollectAmount;
    @SerializedName("total_charge")
    @Expose
    private Double totalCharge;
    @SerializedName("merchant_paid_amount")
    @Expose
    private Double merchantPaidAmount;

    public Integer getParcelId() {
        return parcelId;
    }

    public void setParcelId(Integer parcelId) {
        this.parcelId = parcelId;
    }

    public String getParcelInvoice() {
        return parcelInvoice;
    }

    public void setParcelInvoice(String parcelInvoice) {
        this.parcelInvoice = parcelInvoice;
    }

    public Integer getTotalCollectAmount() {
        return totalCollectAmount;
    }

    public void setTotalCollectAmount(Integer totalCollectAmount) {
        this.totalCollectAmount = totalCollectAmount;
    }

    public Integer getCodPercent() {
        return codPercent;
    }

    public void setCodPercent(Integer codPercent) {
        this.codPercent = codPercent;
    }

    public Double getCodCharge() {
        return codCharge;
    }

    public void setCodCharge(Double codCharge) {
        this.codCharge = codCharge;
    }

    public Integer getWeightPackageCharge() {
        return weightPackageCharge;
    }

    public void setWeightPackageCharge(Integer weightPackageCharge) {
        this.weightPackageCharge = weightPackageCharge;
    }

    public Integer getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Integer deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public Integer getReturnCharge() {
        return returnCharge;
    }

    public void setReturnCharge(Integer returnCharge) {
        this.returnCharge = returnCharge;
    }

    public Integer getCustomerCollectAmount() {
        return customerCollectAmount;
    }

    public void setCustomerCollectAmount(Integer customerCollectAmount) {
        this.customerCollectAmount = customerCollectAmount;
    }

    public Double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(Double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public Double getMerchantPaidAmount() {
        return merchantPaidAmount;
    }

    public void setMerchantPaidAmount(Double merchantPaidAmount) {
        this.merchantPaidAmount = merchantPaidAmount;
    }
}
