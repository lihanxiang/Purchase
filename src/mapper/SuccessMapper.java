package mapper;

import org.apache.ibatis.annotations.Param;
import po.Success;

import java.util.List;

public interface SuccessMapper {
    void insertRecord(Success success);
    List<Success> queryByPurchaseID(@Param("ID") Long ID);
}
