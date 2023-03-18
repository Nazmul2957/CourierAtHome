package com.stitbd.courierathomemerchant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AreaContainer {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("areas")
    @Expose
    private List<Area> Arealist;

    public List<Area> getArealist() {
        return Arealist;
    }

    public void setArealist(List<Area> arealist) {
        Arealist = arealist;
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
