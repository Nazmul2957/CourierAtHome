
package com.stitbd.courierathomemerchant.model.Login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MerchantL {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("m_id")
    @Expose
    private String mId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("business_address")
    @Expose
    private Object businessAddress;
    @SerializedName("fb_url")
    @Expose
    private Object fbUrl;
    @SerializedName("web_url")
    @Expose
    private Object webUrl;
    @SerializedName("bank_name")
    @Expose
    private Object bankName;
    @SerializedName("bank_account_no")
    @Expose
    private Object bankAccountNo;
    @SerializedName("bank_account_name")
    @Expose
    private Object bankAccountName;
    @SerializedName("nid_no")
    @Expose
    private Object nidNo;
    @SerializedName("nid_card")
    @Expose
    private Object nidCard;
    @SerializedName("trade_license")
    @Expose
    private Object tradeLicense;
    @SerializedName("tin_certificate")
    @Expose
    private Object tinCertificate;
    @SerializedName("bkash_number")
    @Expose
    private String bkashNumber;
    @SerializedName("nagad_number")
    @Expose
    private Object nagadNumber;
    @SerializedName("rocket_name")
    @Expose
    private Object rocketName;
    @SerializedName("contact_number")
    @Expose
    private String contactNumber;
    @SerializedName("district_id")
    @Expose
    private Integer districtId;
    @SerializedName("upazila_id")
    @Expose
    private Integer upazilaId;
    @SerializedName("area_id")
    @Expose
    private Integer areaId;
    @SerializedName("branch_id")
    @Expose
    private Integer branchId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("cod_charge")
    @Expose
    private Object codCharge;
    @SerializedName("otp_token")
    @Expose
    private Object otpToken;
    @SerializedName("otp_token_created")
    @Expose
    private Object otpTokenCreated;
    @SerializedName("otp_token_status")
    @Expose
    private Object otpTokenStatus;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("email_verified_at")
    @Expose
    private Object emailVerifiedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(Object businessAddress) {
        this.businessAddress = businessAddress;
    }

    public Object getFbUrl() {
        return fbUrl;
    }

    public void setFbUrl(Object fbUrl) {
        this.fbUrl = fbUrl;
    }

    public Object getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(Object webUrl) {
        this.webUrl = webUrl;
    }

    public Object getBankName() {
        return bankName;
    }

    public void setBankName(Object bankName) {
        this.bankName = bankName;
    }

    public Object getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(Object bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public Object getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(Object bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public Object getNidNo() {
        return nidNo;
    }

    public void setNidNo(Object nidNo) {
        this.nidNo = nidNo;
    }

    public Object getNidCard() {
        return nidCard;
    }

    public void setNidCard(Object nidCard) {
        this.nidCard = nidCard;
    }

    public Object getTradeLicense() {
        return tradeLicense;
    }

    public void setTradeLicense(Object tradeLicense) {
        this.tradeLicense = tradeLicense;
    }

    public Object getTinCertificate() {
        return tinCertificate;
    }

    public void setTinCertificate(Object tinCertificate) {
        this.tinCertificate = tinCertificate;
    }

    public String getBkashNumber() {
        return bkashNumber;
    }

    public void setBkashNumber(String bkashNumber) {
        this.bkashNumber = bkashNumber;
    }

    public Object getNagadNumber() {
        return nagadNumber;
    }

    public void setNagadNumber(Object nagadNumber) {
        this.nagadNumber = nagadNumber;
    }

    public Object getRocketName() {
        return rocketName;
    }

    public void setRocketName(Object rocketName) {
        this.rocketName = rocketName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getUpazilaId() {
        return upazilaId;
    }

    public void setUpazilaId(Integer upazilaId) {
        this.upazilaId = upazilaId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object getCodCharge() {
        return codCharge;
    }

    public void setCodCharge(Object codCharge) {
        this.codCharge = codCharge;
    }

    public Object getOtpToken() {
        return otpToken;
    }

    public void setOtpToken(Object otpToken) {
        this.otpToken = otpToken;
    }

    public Object getOtpTokenCreated() {
        return otpTokenCreated;
    }

    public void setOtpTokenCreated(Object otpTokenCreated) {
        this.otpTokenCreated = otpTokenCreated;
    }

    public Object getOtpTokenStatus() {
        return otpTokenStatus;
    }

    public void setOtpTokenStatus(Object otpTokenStatus) {
        this.otpTokenStatus = otpTokenStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Object emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

}
