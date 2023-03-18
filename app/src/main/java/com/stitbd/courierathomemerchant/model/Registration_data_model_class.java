package com.stitbd.courierathomemerchant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Registration_data_model_class {

    @SerializedName("company_name")
    @Expose
    private String company_name;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("image")
    @Expose
    private String image;

    public Registration_data_model_class(String company_name,
                                         String name, String email, String image,
                                         String password, String address, String contract_number,
                                         String district_id, String upazila_id, String area_id,
                                         String business_address, String fb_url, String web_url,
                                         String bank_account_name, String bank_account_no, String bank_name,
                                         String bkash_number, String nogod_number, String rocket_name,
                                         String nid_no, String nid_card, String trade_license,
                                         String tin_certificate) {

        this.company_name = company_name;
        this.name = name;
        this.email = email;
        this.image = image;
        this.password = password;
        this.address = address;
        this.contract_number = contract_number;
        this.district_id = district_id;
        this.upazila_id = upazila_id;
        this.area_id = area_id;
        this.business_address = business_address;
        this.fb_url = fb_url;
        this.web_url = web_url;
        this.bank_account_name = bank_account_name;
        this.bank_account_no = bank_account_no;
        this.bank_name = bank_name;
        this.bkash_number = bkash_number;
        this.nogod_number = nogod_number;
        this.rocket_name = rocket_name;
        this.nid_no = nid_no;
        this.nid_card = nid_card;
        this.trade_license = trade_license;
        this.tin_certificate = tin_certificate;
    }
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("contract_number")
    @Expose
    private String contract_number;
    @SerializedName("district_id")
    @Expose
    private String district_id;
    @SerializedName("upazila_id")
    @Expose
    private String upazila_id;
    @SerializedName("area_id")
    @Expose
    private String area_id;
    @SerializedName("business_address")
    @Expose
    private String business_address;
    @SerializedName("fb_url")
    @Expose
    private String fb_url;
    @SerializedName("web_url")
    @Expose
    private String web_url;
    @SerializedName("bank_account_name")
    @Expose
    private String bank_account_name;
    @SerializedName("bank_account_no")
    @Expose
    private String bank_account_no;
    @SerializedName("bank_name")
    @Expose
    private String bank_name;
    @SerializedName("bkash_number")
    @Expose
    private String bkash_number;
    @SerializedName("nogod_number")
    @Expose
    private String nogod_number;
    @SerializedName("rocket_name")
    @Expose
    private String rocket_name;
    @SerializedName("nid_no")
    @Expose
    private String nid_no;
    @SerializedName("nid_card")
    @Expose
    private String nid_card;
    @SerializedName("trade_license")
    @Expose
    private String trade_license;
    @SerializedName("tin_certificate")
    @Expose
    private String tin_certificate;


    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public String getUpazila_id() {
        return upazila_id;
    }

    public void setUpazila_id(String upazila_id) {
        this.upazila_id = upazila_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getBusiness_address() {
        return business_address;
    }

    public void setBusiness_address(String business_address) {
        this.business_address = business_address;
    }

    public String getFb_url() {
        return fb_url;
    }

    public void setFb_url(String fb_url) {
        this.fb_url = fb_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getBank_account_name() {
        return bank_account_name;
    }

    public void setBank_account_name(String bank_account_name) {
        this.bank_account_name = bank_account_name;
    }

    public String getBank_account_no() {
        return bank_account_no;
    }

    public void setBank_account_no(String bank_account_no) {
        this.bank_account_no = bank_account_no;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBkash_number() {
        return bkash_number;
    }

    public void setBkash_number(String bkash_number) {
        this.bkash_number = bkash_number;
    }

    public String getNogod_number() {
        return nogod_number;
    }

    public void setNogod_number(String nogod_number) {
        this.nogod_number = nogod_number;
    }

    public String getRocket_name() {
        return rocket_name;
    }

    public void setRocket_name(String rocket_name) {
        this.rocket_name = rocket_name;
    }

    public String getNid_no() {
        return nid_no;
    }

    public void setNid_no(String nid_no) {
        this.nid_no = nid_no;
    }

    public String getNid_card() {
        return nid_card;
    }

    public void setNid_card(String nid_card) {
        this.nid_card = nid_card;
    }

    public String getTrade_license() {
        return trade_license;
    }

    public void setTrade_license(String trade_license) {
        this.trade_license = trade_license;
    }

    public String getTin_certificate() {
        return tin_certificate;
    }

    public void setTin_certificate(String tin_certificate) {
        this.tin_certificate = tin_certificate;
    }


}
