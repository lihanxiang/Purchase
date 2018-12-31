package service.impl;

import mapper.SuccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Success;
import service.SuccessService;

import java.util.List;

@Service
public class SuccessServiceImpl implements SuccessService {

    private final SuccessMapper successMapper;

    @Autowired
    public SuccessServiceImpl(SuccessMapper successMapper) {
        this.successMapper = successMapper;
    }

    @Override
    public void insertRecord(int purchaseID, int userPhone) {
        successMapper.insertRecord(purchaseID, userPhone);
    }

    @Override
    public Success queryByPurchaseID(int purchaseID, int userPhone) {
        return successMapper.queryByPurchaseID(purchaseID, userPhone);
    }
}
