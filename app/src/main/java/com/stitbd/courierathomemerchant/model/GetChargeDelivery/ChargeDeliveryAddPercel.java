package com.stitbd.courierathomemerchant.model.GetChargeDelivery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChargeDeliveryAddPercel {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("weightPackages")
    @Expose
    private List<WeightPackageRate> weightlist;

    public List<WeightPackageRate> getWeightlist() {
        return weightlist;
    }

    @SerializedName("charge")
    @Expose
    private String charge;

    public void setWeightlist(List<WeightPackageRate> weightlist) {
        this.weightlist = weightlist;
    }

    @SerializedName("return_charge")
    @Expose
    private String returnCharge;
    @SerializedName("cod_charge_percent")
    @Expose
    private Integer codChargePercent;

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

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getReturnCharge() {
        return returnCharge;
    }

    public void setReturnCharge(String returnCharge) {
        this.returnCharge = returnCharge;
    }

    public Integer getCodChargePercent() {
        return codChargePercent;
    }

    public void setCodChargePercent(Integer codChargePercent) {
        this.codChargePercent = codChargePercent;
    }

}
