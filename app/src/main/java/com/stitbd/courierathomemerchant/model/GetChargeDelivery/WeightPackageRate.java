package com.stitbd.courierathomemerchant.model.GetChargeDelivery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeightPackageRate {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rate")
    @Expose
    private Double rate;

    public WeightPackageRate(Integer id, String name) {
        this.id = id;
        this.name = name;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

}
