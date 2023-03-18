
package com.stitbd.courierathomemerchant.model.PaymentListDetails;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryPaymentDetail {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("parcel_id")
    @Expose
    private Integer parcelId;
    @SerializedName("parcel_invoice")
    @Expose
    private String parcelInvoice;
    @SerializedName("merchant_order_id")
    @Expose
    private Object merchantOrderId;
    @SerializedName("collected_amount")
    @Expose
    private Double collectedAmount;
    @SerializedName("cod_charge")
    @Expose
    private Double codCharge;
    @SerializedName("delivery_charge")
    @Expose
    private Double deliveryCharge;
    @SerializedName("weight_package_charge")
    @Expose
    private Double weightPackageCharge;
    @SerializedName("return_charge")
    @Expose
    private Double returnCharge;
    @SerializedName("paid_amount")
    @Expose
    private Double paidAmount;
    @SerializedName("note")
    @Expose
    private Object note;
    @SerializedName("date_time")
    @Expose
    private String dateTime;

    @SerializedName("customer_name")
    @Expose
    private String customer_name;

    @SerializedName("customer_contact_number")
    @Expose
    private String customer_contact_number;

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_contact_number() {
        return customer_contact_number;
    }

    public void setCustomer_contact_number(String customer_contact_number) {
        this.customer_contact_number = customer_contact_number;
    }

    @SerializedName("status")
    @Expose
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Object getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(Object merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public Double getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(Double collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    public Double getCodCharge() {
        return codCharge;
    }

    public void setCodCharge(Double codCharge) {
        this.codCharge = codCharge;
    }

    public Double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public Double getWeightPackageCharge() {
        return weightPackageCharge;
    }

    public void setWeightPackageCharge(Double weightPackageCharge) {
        this.weightPackageCharge = weightPackageCharge;
    }

    public Double getReturnCharge() {
        return returnCharge;
    }

    public void setReturnCharge(Double returnCharge) {
        this.returnCharge = returnCharge;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
