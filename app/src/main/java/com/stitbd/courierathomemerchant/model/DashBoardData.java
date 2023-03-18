package com.stitbd.courierathomemerchant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DashBoardData {
    @SerializedName("total_parcel")
    @Expose
    private Integer totalParcel;
    @SerializedName("total_cancel_parcel")
    @Expose
    private Integer totalCancelParcel;
    @SerializedName("total_waiting_pickup_parcel")
    @Expose
    private Integer totalWaitingPickupParcel;
    @SerializedName("total_waiting_delivery_parcel")
    @Expose
    private Integer totalWaitingDeliveryParcel;
    @SerializedName("total_delivery_parcel")
    @Expose
    private Integer totalDeliveryParcel;
    @SerializedName("total_delivery_complete_parcel")
    @Expose
    private Integer totalDeliveryCompleteParcel;
    @SerializedName("total_return_parcel")
    @Expose
    private Integer totalReturnParcel;
    @SerializedName("total_return_complete_parcel")
    @Expose
    private Double totalReturnCompleteParcel;
    @SerializedName("total_pending_collect_amount")
    @Expose
    private Double totalPendingCollectAmount;
    @SerializedName("total_collect_amount")
    @Expose
    private Double totalCollectAmount;

    public Integer getTotalParcel() {
        return totalParcel;
    }

    public void setTotalParcel(Integer totalParcel) {
        this.totalParcel = totalParcel;
    }

    public Integer getTotalCancelParcel() {
        return totalCancelParcel;
    }

    public void setTotalCancelParcel(Integer totalCancelParcel) {
        this.totalCancelParcel = totalCancelParcel;
    }

    public Integer getTotalWaitingPickupParcel() {
        return totalWaitingPickupParcel;
    }

    public void setTotalWaitingPickupParcel(Integer totalWaitingPickupParcel) {
        this.totalWaitingPickupParcel = totalWaitingPickupParcel;
    }

    public Integer getTotalWaitingDeliveryParcel() {
        return totalWaitingDeliveryParcel;
    }

    public void setTotalWaitingDeliveryParcel(Integer totalWaitingDeliveryParcel) {
        this.totalWaitingDeliveryParcel = totalWaitingDeliveryParcel;
    }

    public Integer getTotalDeliveryParcel() {
        return totalDeliveryParcel;
    }

    public void setTotalDeliveryParcel(Integer totalDeliveryParcel) {
        this.totalDeliveryParcel = totalDeliveryParcel;
    }

    public Integer getTotalDeliveryCompleteParcel() {
        return totalDeliveryCompleteParcel;
    }

    public void setTotalDeliveryCompleteParcel(Integer totalDeliveryCompleteParcel) {
        this.totalDeliveryCompleteParcel = totalDeliveryCompleteParcel;
    }

    public Integer getTotalReturnParcel() {
        return totalReturnParcel;
    }

    public void setTotalReturnParcel(Integer totalReturnParcel) {
        this.totalReturnParcel = totalReturnParcel;
    }

    public Double getTotalReturnCompleteParcel() {
        return totalReturnCompleteParcel;
    }

    public void setTotalReturnCompleteParcel(Double totalReturnCompleteParcel) {
        this.totalReturnCompleteParcel = totalReturnCompleteParcel;
    }

    public Double getTotalPendingCollectAmount() {
        return totalPendingCollectAmount;
    }

    public void setTotalPendingCollectAmount(Double totalPendingCollectAmount) {
        this.totalPendingCollectAmount = totalPendingCollectAmount;
    }

    public Double getTotalCollectAmount() {
        return totalCollectAmount;
    }

    public void setTotalCollectAmount(Double totalCollectAmount) {
        this.totalCollectAmount = totalCollectAmount;
    }
    public List<DashBoardHelperModel> getlist(){
        List<DashBoardHelperModel> helper=new ArrayList<>();
        helper.add(new DashBoardHelperModel("Total Parcel",Double.valueOf(totalParcel)));
        helper.add(new DashBoardHelperModel("Total Cancel Parcel",Double.valueOf(totalCancelParcel)));
        helper.add(new DashBoardHelperModel("Total Waiting PickupParcel",Double.valueOf(totalWaitingPickupParcel)));
        helper.add(new DashBoardHelperModel("Total Waiting Delivery Parcel",Double.valueOf(totalWaitingDeliveryParcel)));
        helper.add(new DashBoardHelperModel("Total Delivery Parcel",Double.valueOf(totalDeliveryParcel)));
        helper.add(new DashBoardHelperModel("Total Delivery CompleteParcel",Double.valueOf(totalDeliveryCompleteParcel)));
        helper.add(new DashBoardHelperModel("Total Return Parcel",Double.valueOf(totalReturnParcel)));
        helper.add(new DashBoardHelperModel("Total Return Complete Parcel",Double.valueOf(totalReturnCompleteParcel)));
        helper.add(new DashBoardHelperModel("Total Pending Collect Amount",Double.valueOf(totalPendingCollectAmount)));
        helper.add(new DashBoardHelperModel("Total Collect Amount",totalCollectAmount));
        return helper;
    }
}
