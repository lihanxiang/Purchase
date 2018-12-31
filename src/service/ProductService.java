package service;

import po.Product;

public interface ProductService {
    Product queryByID(int productID);
    Product queryByPurchaseID(int purchaseID);
}
