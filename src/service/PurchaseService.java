package service;

import dto.Exposer;
import dto.PurchaseExecutor;
import exception.PurchaseException;
import po.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase queryByProductID(int productID);
    Purchase queryByPurchaseID(int purchaseID);
    List<Purchase> queryAll();
    Exposer exposeURL(int purchaseID);
    PurchaseExecutor executePurchase(int purchaseID, int userPhone)
            throws PurchaseException;
}
