package com.stitbd.courierathomemerchant.model.PercelDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Percel_Details_Container {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("parcels")
    @Expose
    private Percel_Details detailslist;

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

    public Percel_Details getDetails() {
        return detailslist;
    }

    public void setDetails(Percel_Details details) {
        this.detailslist = details;
    }
}
