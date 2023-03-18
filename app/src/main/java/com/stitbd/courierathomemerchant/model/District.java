package com.stitbd.courierathomemerchant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class District {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("service_area_id")
    @Expose
    private Integer serviceAreaId;
    @SerializedName("home_delivery")
    @Expose
    private Integer homeDelivery;
    @SerializedName("lock_down_service")
    @Expose
    private Integer lockDownService;
    @SerializedName("status")
    @Expose
    private Integer status;

    public District(Integer id, String name) {
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

    public Integer getServiceAreaId() {
        return serviceAreaId;
    }

    public void setServiceAreaId(Integer serviceAreaId) {
        this.serviceAreaId = serviceAreaId;
    }

    public Integer getHomeDelivery() {
        return homeDelivery;
    }

    public void setHomeDelivery(Integer homeDelivery) {
        this.homeDelivery = homeDelivery;
    }

    public Integer getLockDownService() {
        return lockDownService;
    }

    public void setLockDownService(Integer lockDownService) {
        this.lockDownService = lockDownService;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
