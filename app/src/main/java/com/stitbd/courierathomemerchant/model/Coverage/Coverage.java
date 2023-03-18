package com.stitbd.courierathomemerchant.model.Coverage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coverage {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("coverage_area")
    @Expose
    private String coverageArea;
    @SerializedName("post_code")
    @Expose
    private String postCode;
    @SerializedName("upazila_name")
    @Expose
    private String upazilaName;
    @SerializedName("district_name")
    @Expose
    private String districtName;
    @SerializedName("service_area_name")
    @Expose
    private String serviceAreaName;
    @SerializedName("cod_charge")
    @Expose
    private String codCharge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoverageArea() {
        return coverageArea;
    }

    public void setCoverageArea(String coverageArea) {
        this.coverageArea = coverageArea;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getUpazilaName() {
        return upazilaName;
    }

    public void setUpazilaName(String upazilaName) {
        this.upazilaName = upazilaName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getServiceAreaName() {
        return serviceAreaName;
    }

    public void setServiceAreaName(String serviceAreaName) {
        this.serviceAreaName = serviceAreaName;
    }

    public String getCodCharge() {
        return codCharge;
    }

    public void setCodCharge(String codCharge) {
        this.codCharge = codCharge;
    }
}
