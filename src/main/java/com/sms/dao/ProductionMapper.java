package com.sms.dao;

import com.sms.pojo.Production;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductionMapper {
    //获取全部生产
    List<Production> getAllProduction();
    //添加生产
    int addProduction(Production production);
    //修改生产
    int updateProduction(Production production);
    //根据id查询生产
    Production getProductionById(@Param("productionId") int productionId);
    //根据userName查询生产
    Production getProductionByUserName(@Param("userName") String userName);
    //根据userId查询生产
    Production getProductionByUserId(@Param("userId") int userId);
    //删除生产
    int deleteProduction(@Param("productionId") int productionId);
    //根据产品名称查询
    Production getProductionByName(@Param("productionName") String productionName);
}
