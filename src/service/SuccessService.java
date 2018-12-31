package service;

import org.apache.ibatis.annotations.Param;
import po.Success;

import java.util.List;

public interface SuccessService {
    void insertRecord(int purchaseID, int userPhone);
    Success queryByPurchaseID(int purchaseID, int userPhone);
}
