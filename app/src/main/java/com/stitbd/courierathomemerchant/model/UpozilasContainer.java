package com.stitbd.courierathomemerchant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UpozilasContainer {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("upazilas")
    @Expose
    private List<Upozila> upozilaList;

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

    public List<Upozila> getUpozilaList() {
        return upozilaList;
    }

    public void setUpozilaList(List<Upozila> upozilaList) {
        this.upozilaList = upozilaList;
    }
}
