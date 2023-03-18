package com.stitbd.courierathomemerchant.model.DashBoardClick;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DashboardClickContainer {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("parcels")
    @Expose
    private List<DashBoardClick> dashclick;

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

    public List<DashBoardClick> getDashclick() {
        return dashclick;
    }

    public void setDashclick(List<DashBoardClick> dashclick) {
        this.dashclick = dashclick;
    }
}
