package dto;

public class Exposer {

    private boolean exposed;
    private String md5;
    private Long purchaseID;
    private Long startTime;
    private Long endTime;
    private Long now;

    public Exposer(boolean exposed, String md5, Long purchaseID) {
        this.exposed = exposed;
        this.md5 = md5;
        this.purchaseID = purchaseID;
    }

    public Exposer(boolean exposed, Long purchaseID, Long startTime, Long endTime, Long now) {
        this.exposed = exposed;
        this.purchaseID = purchaseID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.now = now;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(Long purchaseID) {
        this.purchaseID = purchaseID;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }
}
