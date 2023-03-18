package com.stitbd.courierathomemerchant.model.GetChargeDelivery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChargeDeliveryParcelContainer {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("weightPackage")
    @Expose
    private String weightPackage;

    public String getWeightPackage() {
        return weightPackage;
    }

    public void setWeightPackage(String weightPackage) {
        this.weightPackage = weightPackage;
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


}
