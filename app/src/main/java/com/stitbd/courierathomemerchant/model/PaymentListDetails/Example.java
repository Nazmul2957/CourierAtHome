
package com.stitbd.courierathomemerchant.model.PaymentListDetails;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("delivery_payment")
    @Expose
    private DeliveryPayment deliveryPayment;
    @SerializedName("delivery_payment_details")
    @Expose
    private List<DeliveryPaymentDetail> deliveryPaymentDetails = null;

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

    public DeliveryPayment getDeliveryPayment() {
        return deliveryPayment;
    }

    public void setDeliveryPayment(DeliveryPayment deliveryPayment) {
        this.deliveryPayment = deliveryPayment;
    }

    public List<DeliveryPaymentDetail> getDeliveryPaymentDetails() {
        return deliveryPaymentDetails;
    }

    public void setDeliveryPaymentDetails(List<DeliveryPaymentDetail> deliveryPaymentDetails) {
        this.deliveryPaymentDetails = deliveryPaymentDetails;
    }

}
