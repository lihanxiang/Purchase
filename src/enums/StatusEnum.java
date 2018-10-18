package enums;

public enum  StatusEnum {

    SUCCESS(1, "success"),
    END(0, "end"),
    REPEAT(-1, "repeat"),
    INNER_ERROR(-2, "inner error"),
    DATA_REWRITE(-3, "data rewrite");

    private int status;
    private String statusInfo;

    StatusEnum(int status, String statusInfo) {
        this.status = status;
        this.statusInfo = statusInfo;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public static StatusEnum statusOf(int index){
        for (StatusEnum status :
                values()) {
            if (status.getStatus() == index){
                return status;
            }
        }
        return null;
    }
}
