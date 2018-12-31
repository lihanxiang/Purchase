package mapper;

import org.apache.ibatis.annotations.Param;
import po.Purchase;

import java.util.Date;
import java.util.List;

public interface PurchaseMapper {
    int reduceInventory(@Param("purchaseID")int purchaseID, @Param("purchaseTime")Date purchaseTime);
    Purchase queryByProductID(@Param("productID")int productID);
    Purchase queryByPurchaseID(@Param("purchaseID")int purchaseID);
    List<Purchase> queryAll();
}
