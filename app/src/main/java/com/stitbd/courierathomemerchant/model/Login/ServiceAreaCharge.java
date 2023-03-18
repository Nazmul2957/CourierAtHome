
package com.stitbd.courierathomemerchant.model.Login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ServiceAreaCharge {

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
    private String charge;

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

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

}
