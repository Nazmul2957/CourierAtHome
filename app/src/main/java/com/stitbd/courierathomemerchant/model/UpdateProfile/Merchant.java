
package com.stitbd.courierathomemerchant.model.UpdateProfile;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Merchant {

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
    @SerializedName("store_password")
    @Expose
    private String storePassword;
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
    private String businessAddress;
    @SerializedName("fb_url")
    @Expose
    private String fbUrl;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("bank_name")
    @Expose
    private String bankName;
    @SerializedName("bank_account_no")
    @Expose
    private String bankAccountNo;
    @SerializedName("bank_account_name")
    @Expose
    private String bankAccountName;
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
    private String nagadNumber;
    @SerializedName("rocket_name")
    @Expose
    private String rocketName;
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
    private String otpToken;
    @SerializedName("otp_token_created")
    @Expose
    private String otpTokenCreated;
    @SerializedName("otp_token_status")
    @Expose
    private Integer otpTokenStatus;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_admin_id")
    @Expose
    private Object createdAdminId;
    @SerializedName("updated_admin_id")
    @Expose
    private Integer updatedAdminId;
    @SerializedName("email_verified_at")
    @Expose
    private String emailVerifiedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

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

    public String getStorePassword() {
        return storePassword;
    }

    public void setStorePassword(String storePassword) {
        this.storePassword = storePassword;
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

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getFbUrl() {
        return fbUrl;
    }

    public void setFbUrl(String fbUrl) {
        this.fbUrl = fbUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
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

    public String getNagadNumber() {
        return nagadNumber;
    }

    public void setNagadNumber(String nagadNumber) {
        this.nagadNumber = nagadNumber;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
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

    public String getOtpToken() {
        return otpToken;
    }

    public void setOtpToken(String otpToken) {
        this.otpToken = otpToken;
    }

    public String getOtpTokenCreated() {
        return otpTokenCreated;
    }

    public void setOtpTokenCreated(String otpTokenCreated) {
        this.otpTokenCreated = otpTokenCreated;
    }

    public Integer getOtpTokenStatus() {
        return otpTokenStatus;
    }

    public void setOtpTokenStatus(Integer otpTokenStatus) {
        this.otpTokenStatus = otpTokenStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getCreatedAdminId() {
        return createdAdminId;
    }

    public void setCreatedAdminId(Object createdAdminId) {
        this.createdAdminId = createdAdminId;
    }

    public Integer getUpdatedAdminId() {
        return updatedAdminId;
    }

    public void setUpdatedAdminId(Integer updatedAdminId) {
        this.updatedAdminId = updatedAdminId;
    }

    public String getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(String emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
