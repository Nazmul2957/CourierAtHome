
package com.stitbd.courierathomemerchant.model.Login;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginContainer{

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("merchant")
    @Expose
    private MerchantL merchant;
    @SerializedName("cod_charge_percent")
    @Expose
    private Integer codChargePercent;
    @SerializedName("service_area_charges")
    @Expose
    private List<ServiceAreaCharge> serviceAreaCharges = null;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MerchantL getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantL merchant) {
        this.merchant = merchant;
    }

    public Integer getCodChargePercent() {
        return codChargePercent;
    }

    public void setCodChargePercent(Integer codChargePercent) {
        this.codChargePercent = codChargePercent;
    }

    public List<ServiceAreaCharge> getServiceAreaCharges() {
        return serviceAreaCharges;
    }

    public void setServiceAreaCharges(List<ServiceAreaCharge> serviceAreaCharges) {
        this.serviceAreaCharges = serviceAreaCharges;
    }

}
