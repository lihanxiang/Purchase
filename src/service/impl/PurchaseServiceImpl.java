package service.impl;

import mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Purchase;
import service.PurchaseService;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    private final PurchaseMapper purchaseMapper;

    @Autowired
    public PurchaseServiceImpl(PurchaseMapper purchaseMapper) {
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public void reduceInventory(Purchase purchase) {
        purchaseMapper.reduceInventory(purchase);
    }

    @Override
    public Purchase queryByID(Long ID) {
        return purchaseMapper.queryByID(ID);
    }

    @Override
    public List<Purchase> queryAll() {
        return purchaseMapper.queryAll();
    }
}
