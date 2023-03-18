
package com.stitbd.courierathomemerchant.model.PaymentListDetails;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryPayment {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("merchant_payment_invoice")
    @Expose
    private String merchantPaymentInvoice;
    @SerializedName("admin_id")
    @Expose
    private Integer adminId;
    @SerializedName("total_payment_parcel")
    @Expose
    private Integer totalPaymentParcel;
    @SerializedName("total_payment_received_parcel")
    @Expose
    private Integer totalPaymentReceivedParcel;
    @SerializedName("total_payment_amount")
    @Expose
    private String totalPaymentAmount;
    @SerializedName("total_payment_received_amount")
    @Expose
    private String totalPaymentReceivedAmount;
    @SerializedName("note")
    @Expose
    private Object note;
    @SerializedName("date_time")
    @Expose
    private String dateTime;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("admin_name")
    @Expose
    private String adminName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerchantPaymentInvoice() {
        return merchantPaymentInvoice;
    }

    public void setMerchantPaymentInvoice(String merchantPaymentInvoice) {
        this.merchantPaymentInvoice = merchantPaymentInvoice;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getTotalPaymentParcel() {
        return totalPaymentParcel;
    }

    public void setTotalPaymentParcel(Integer totalPaymentParcel) {
        this.totalPaymentParcel = totalPaymentParcel;
    }

    public Integer getTotalPaymentReceivedParcel() {
        return totalPaymentReceivedParcel;
    }

    public void setTotalPaymentReceivedParcel(Integer totalPaymentReceivedParcel) {
        this.totalPaymentReceivedParcel = totalPaymentReceivedParcel;
    }

    public String getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(String totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public String getTotalPaymentReceivedAmount() {
        return totalPaymentReceivedAmount;
    }

    public void setTotalPaymentReceivedAmount(String totalPaymentReceivedAmount) {
        this.totalPaymentReceivedAmount = totalPaymentReceivedAmount;
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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

}
