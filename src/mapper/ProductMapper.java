package mapper;

import org.apache.ibatis.annotations.Param;
import po.Product;

public interface ProductMapper {
    Product queryByID(@Param("productID")int productID);
    Product queryByPruchaseID(@Param("purchaseID")int purchaseID);
}
