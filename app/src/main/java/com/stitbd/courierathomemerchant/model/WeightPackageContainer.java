package com.stitbd.courierathomemerchant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeightPackageContainer {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("weightPackages")
    @Expose
    private List<WeightPackage> weightPackageList;

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

    public List<WeightPackage> getWeightPackageList() {
        return weightPackageList;
    }

    public void setWeightPackageList(List<WeightPackage> weightPackageList) {
        this.weightPackageList = weightPackageList;
    }
}
