package com.stitbd.courierathomemerchant.model.Payment;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentContainer {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("delivery_payment_lists")
    @Expose
    private List<Payment> paymentlists;

    public List<Payment> getPaymentlist() {
        return paymentlists;
    }

    public void setPaymentlist(List<Payment> paymentlist) {
        this.paymentlists = paymentlist;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public List<Payment> getPayment() {
        return paymentlists;
    }

}
