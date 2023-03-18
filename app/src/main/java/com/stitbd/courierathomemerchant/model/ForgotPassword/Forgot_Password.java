package com.stitbd.courierathomemerchant.model.ForgotPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forgot_Password {
    @SerializedName("contact_number")
    @Expose
    private String contact_number;

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }
}
