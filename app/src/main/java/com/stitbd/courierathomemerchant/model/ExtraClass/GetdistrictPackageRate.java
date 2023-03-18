package com.stitbd.courierathomemerchant.model.ExtraClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetdistrictPackageRate {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("rate")
    @Expose
    private Integer rate;

    public GetdistrictPackageRate(Integer success, String message, Integer rate) {
        this.success = success;
        this.message = message;
        this.rate = rate;
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

}
