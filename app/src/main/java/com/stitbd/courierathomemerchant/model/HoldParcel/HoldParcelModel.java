package com.stitbd.courierathomemerchant.model.HoldParcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HoldParcelModel {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("parcel_id")
    @Expose
    private String parcelId;

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

    public String getParcelId() {
        return parcelId;
    }

    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }
}
