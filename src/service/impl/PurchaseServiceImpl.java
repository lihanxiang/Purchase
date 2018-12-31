package service.impl;

import dto.Exposer;
import dto.PurchaseExecutor;
import enums.StatusEnum;
import exception.PurchaseException;
import mapper.PurchaseMapper;
import mapper.SuccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import po.Purchase;
import po.Success;
import service.PurchaseService;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    private final String salt = "123asfs09suxcv@#*&*$@&%";
    private final PurchaseMapper purchaseMapper;
    private final SuccessMapper successMapper;

    @Autowired
    public PurchaseServiceImpl(PurchaseMapper purchaseMapper, SuccessMapper successMapper) {
        this.purchaseMapper = purchaseMapper;
        this.successMapper = successMapper;
    }

    @Override
    public Purchase queryByProductID(int productID) {
        return purchaseMapper.queryByProductID(productID);
    }

    @Override
    public Purchase queryByPurchaseID(int purchaseID) {
        return purchaseMapper.queryByPurchaseID(purchaseID);
    }

    @Override
    public List<Purchase> queryAll() {
        return purchaseMapper.queryAll();
    }

    private String getMD5(int purchaseID){
        String base = purchaseID + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    @Override
    public Exposer exposeURL(int purchaseID) {
        Purchase purchase = purchaseMapper.queryByPurchaseID(purchaseID);
        Date now = new Date();
        Date startTime = purchase.getStartTime();
        Date endTime = purchase.getEndTime();
        if (now.getTime() < startTime.getTime() || now.getTime() > endTime.getTime()){
            return new Exposer(false, purchaseID, startTime.getTime(),
                    endTime.getTime(), now.getTime());
        }
        return new Exposer(true, getMD5(purchaseID), purchaseID);
    }

    @Override
    public PurchaseExecutor executePurchase(int purchaseID, int phone)
            throws PurchaseException{
        Date now = new Date();
        try {
            int updateCount = purchaseMapper.reduceInventory(purchaseID, now);
            if (updateCount <= 0){
                throw new PurchaseException("Closed");
            }
            else {
                int insertCount = successMapper.insertRecord(purchaseID, phone);
                if (insertCount <= 0){
                    throw new PurchaseException("Repeat");
                }
                else {
                    Success success = successMapper.queryByPurchaseID(purchaseID,phone);
                    return new PurchaseExecutor(purchaseID, StatusEnum.SUCCESS, success);
                }
            }
        } catch (Exception e){
            throw new PurchaseException("Inner error : " + e.getMessage());
        }
    }
}
