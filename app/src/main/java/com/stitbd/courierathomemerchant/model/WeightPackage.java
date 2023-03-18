package com.stitbd.courierathomemerchant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeightPackage {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("weight_type")
    @Expose
    private Double weightType;
    @SerializedName("details")
    @Expose
    private Object details;
    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("status")
    @Expose
    private Integer status;


    public WeightPackage(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.weightType = weightType;
        this.details = details;
        this.rate = rate;
        this.status = status;
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

    public Double getWeightType() {
        return weightType;
    }

    public void setWeightType(Double weightType) {
        this.weightType = weightType;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
