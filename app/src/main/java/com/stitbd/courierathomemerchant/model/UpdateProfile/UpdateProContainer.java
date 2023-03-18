
package com.stitbd.courierathomemerchant.model.UpdateProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateProContainer {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("merchant")
    @Expose
    private Merchant merchant;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("parcel_id")
    @Expose
    private Object parcelId;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getParcelId() {
        return parcelId;
    }

    public void setParcelId(Object parcelId) {
        this.parcelId = parcelId;
    }

}
