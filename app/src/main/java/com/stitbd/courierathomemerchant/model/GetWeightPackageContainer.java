package com.stitbd.courierathomemerchant.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetWeightPackageContainer {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("weightPackages")
    @Expose
    private List<GetWeightPackage> weightpackage;

    public Integer getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<GetWeightPackage> getWeightpackage() {
        return weightpackage;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setWeightpackage(List<GetWeightPackage> weightpackage) {
        this.weightpackage = weightpackage;
    }
}
