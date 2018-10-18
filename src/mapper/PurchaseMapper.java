package mapper;

import org.apache.ibatis.annotations.Param;
import po.Purchase;

import java.util.List;

public interface PurchaseMapper {
    void reduceInventory(Purchase purchase);
    Purchase queryByID(@Param("ID") Long ID);
    List<Purchase> queryAll();
}
