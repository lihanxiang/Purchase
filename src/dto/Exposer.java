package dto;

public class Exposer {

    private boolean exposed;
    private String md5;
    private int purchaseID;
    private Long startTime;
    private Long endTime;
    private Long now;

    //already open
    public Exposer(boolean exposed, String md5, int purchaseID) {
        this.exposed = exposed;
        this.md5 = md5;
        this.purchaseID = purchaseID;
    }

    //don't open yet
    public Exposer(boolean exposed, int purchaseID, Long startTime, Long endTime, Long now) {
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

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
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
