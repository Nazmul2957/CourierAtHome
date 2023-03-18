package com.stitbd.courierathomemerchant.model.PercelDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Percel_Details {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("parcel_invoice")
    @Expose
    private String parcel_invoice;
    @SerializedName("merchant_name")
    @Expose
    private String merchant_name;

    @SerializedName("merchant_contact_number")
    @Expose
    private String merchant_contact_number;

    @SerializedName("merchant_address")
    @Expose
    private String merchant_address;

    @SerializedName("merchant_order_id")
    @Expose
    private String merchant_order_id;

    public String getMerchant_order_id() {
        return merchant_order_id;
    }

    public void setMerchant_order_id(String merchant_order_id) {
        this.merchant_order_id = merchant_order_id;
    }

    @SerializedName("customer_name")
    @Expose
    private String customer_name;

    @SerializedName("customer_address")
    @Expose
    private String customer_address;

    @SerializedName("customer_contact_number")
    @Expose
    private String customer_contact_number;

    @SerializedName("district_name")
    @Expose
    private String district_name;

    @SerializedName("upazila_name")
    @Expose
    private String upazila_name;

    @SerializedName("area_name")
    @Expose
    private String area_name;

    @SerializedName("weight_package_name")
    @Expose
    private String weight_package_name;

    @SerializedName("weight_package_charge")
    @Expose
    private String weight_package_charge;

    @SerializedName("cod_percent")
    @Expose
    private String cod_percent;

    @SerializedName("collectable_amount")
    @Expose
    private String collectable_amount;

    @SerializedName("cod_charge")
    @Expose
    private String cod_charge;

    @SerializedName("delivery_charge")
    @Expose String delivery_charge;

    @SerializedName("total_charge")
    @Expose
    private String total_charge;

    @SerializedName("parcel_note")
    @Expose
    private String parcel_note;

    @SerializedName("parcel_status")
    @Expose
    private String parcel_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParcel_invoice() {
        return parcel_invoice;
    }

    public void setParcel_invoice(String parcel_invoice) {
        this.parcel_invoice = parcel_invoice;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public String getMerchant_contact_number() {
        return merchant_contact_number;
    }

    public void setMerchant_contact_number(String merchant_contact_number) {
        this.merchant_contact_number = merchant_contact_number;
    }

    public String getMerchant_address() {
        return merchant_address;
    }

    public void setMerchant_address(String merchant_address) {
        this.merchant_address = merchant_address;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_contact_number() {
        return customer_contact_number;
    }

    public void setCustomer_contact_number(String customer_contact_number) {
        this.customer_contact_number = customer_contact_number;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getUpazila_name() {
        return upazila_name;
    }

    public void setUpazila_name(String upazila_name) {
        this.upazila_name = upazila_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getWeight_package_name() {
        return weight_package_name;
    }

    public void setWeight_package_name(String weight_package_name) {
        this.weight_package_name = weight_package_name;
    }

    public String getWeight_package_charge() {
        return weight_package_charge;
    }

    public void setWeight_package_charge(String weight_package_charge) {
        this.weight_package_charge = weight_package_charge;
    }

    public String getCod_percent() {
        return cod_percent;
    }

    public void setCod_percent(String cod_percent) {
        this.cod_percent = cod_percent;
    }

    public String getCollectable_amount() {
        return collectable_amount;
    }

    public void setCollectable_amount(String collectable_amount) {
        this.collectable_amount = collectable_amount;
    }

    public String getCod_charge() {
        return cod_charge;
    }

    public void setCod_charge(String cod_charge) {
        this.cod_charge = cod_charge;
    }

    public String getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(String delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getTotal_charge() {
        return total_charge;
    }

    public void setTotal_charge(String total_charge) {
        this.total_charge = total_charge;
    }

    public String getParcel_note() {
        return parcel_note;
    }

    public void setParcel_note(String parcel_note) {
        this.parcel_note = parcel_note;
    }

    public String getParcel_status() {
        return parcel_status;
    }

    public void setParcel_status(String parcel_status) {
        this.parcel_status = parcel_status;
    }
}
