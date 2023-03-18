package com.stitbd.courierathomemerchant.model.Profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceCharge {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod_charge")
    @Expose
    private Integer codCharge;
    @SerializedName("weight_type")
    @Expose
    private Integer weightType;
    @SerializedName("charge")
    @Expose
    private Integer charge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCodCharge() {
        return codCharge;
    }

    public void setCodCharge(Integer codCharge) {
        this.codCharge = codCharge;
    }

    public Integer getWeightType() {
        return weightType;
    }

    public void setWeightType(Integer weightType) {
        this.weightType = weightType;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

}
