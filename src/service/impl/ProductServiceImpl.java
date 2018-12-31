package service.impl;

import mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Product;
import service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Product queryByID(int productID) {
        return productMapper.queryByID(productID);
    }

    @Override
    public Product queryByPurchaseID(int purchaseID) {
        return productMapper.queryByPruchaseID(purchaseID);
    }
}
