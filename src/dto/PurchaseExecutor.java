package dto;

import enums.StatusEnum;
import po.Success;

public class PurchaseExecutor {

    private Long purchaseID;
    private int status;
    private String statusInfo;
    private Success success;

    //success
    public PurchaseExecutor(Long purchaseID, StatusEnum statusEnum, Success success) {
        this.purchaseID = purchaseID;
        this.status = statusEnum.getStatus();
        this.statusInfo = statusEnum.getStatusInfo();
        this.success = success;
    }

    //fail
    public PurchaseExecutor(Long purchaseID, StatusEnum statusEnum) {
        this.purchaseID = purchaseID;
        this.status = statusEnum.getStatus();
        this.statusInfo = statusEnum.getStatusInfo();
    }

    public Long getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(Long purchaseID) {
        this.purchaseID = purchaseID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }
}
