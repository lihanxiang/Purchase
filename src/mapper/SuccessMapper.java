package mapper;

import org.apache.ibatis.annotations.Param;
import po.Success;

import java.util.List;

public interface SuccessMapper {
    int insertRecord(@Param("purchaseID")int purchaseID, @Param("phone")int phone);

    Success isRepeat(Success success);
    Success queryByPurchaseID(@Param("purchaseID")int purchaseID, @Param("phone")int phone);
}
