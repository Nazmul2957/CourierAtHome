package com.stitbd.courierathomemerchant.model.Profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfileContainer {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("merchant")
    @Expose
    private Profile profilelist;

    @SerializedName("cod_charge_percent")
    @Expose
    private String cod_charge_percent;

    public String getCod_charge_percent() {
        return cod_charge_percent;
    }

    public void setCod_charge_percent(String cod_charge_percent) {
        this.cod_charge_percent = cod_charge_percent;
    }

    @SerializedName("service_area_charges")
    @Expose
    private List<ServiceCharge> deliverycahrge;

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

    public Profile getProfilelist() {
        return profilelist;
    }

    public void setProfilelist(Profile profilelist) {
        this.profilelist = profilelist;
    }

    public List<ServiceCharge> getDeliverycahrge() {
        return deliverycahrge;
    }


}
