package com.stitbd.courierathomemerchant.model.PercelLog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PercelContainerLog {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("parcel")
    @Expose
    private PercelInformation percellogInformation;

    @SerializedName("parcelLogs")
    @Expose
    private List<PercelLog> percelLog;

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

    public PercelInformation getPercellogInformation() {
        return percellogInformation;
    }

    public void setPercellogInformation(PercelInformation percellogInformation) {
        this.percellogInformation = percellogInformation;
    }

    public List<PercelLog> getPercelLog() {
        return percelLog;
    }

    public void setPercelLog(List<PercelLog> percelLog) {
        this.percelLog = percelLog;
    }
}
