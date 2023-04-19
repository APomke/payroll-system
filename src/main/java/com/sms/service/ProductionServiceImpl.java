package com.sms.service;

import com.sms.dao.ProductionMapper;
import com.sms.pojo.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService{
    @Autowired
    private ProductionMapper productionMapper;

    @Override
    public List<Production> getAllProduction() {
        return productionMapper.getAllProduction();
    }

    @Override
    public int addProduction(Production production) {
        return productionMapper.addProduction(production);
    }

    @Override
    public int updateProduction(Production production) {
        return productionMapper.updateProduction(production);
    }

    @Override
    public Production getProductionById(int productionId) {
        return productionMapper.getProductionById(productionId);
    }

    @Override
    public Production getProductionByUserName(String userName) {
        return productionMapper.getProductionByUserName(userName);
    }

    @Override
    public Production getProductionByUserId(int userId) {
        return productionMapper.getProductionByUserId(userId);
    }

    @Override
    public int deleteProduction(int productionId) {
        return productionMapper.deleteProduction(productionId);
    }

    @Override
    public Production getProductionByName(String productionName) {
        return productionMapper.getProductionByName(productionName);
    }
}