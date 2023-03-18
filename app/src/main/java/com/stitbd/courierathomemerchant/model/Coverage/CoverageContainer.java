package com.stitbd.courierathomemerchant.model.Coverage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoverageContainer {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("coverage_areas")
    @Expose
    private List<Coverage> coverarea;

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

    public List<Coverage> getCoverarea() {
        return coverarea;
    }

    public void setCoverarea(List<Coverage> coverarea) {
        this.coverarea = coverarea;
    }


}
