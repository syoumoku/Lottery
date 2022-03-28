package com.lzm.lottery.infrastructure.dao;

import com.lzm.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyDetailDao {

    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    int deductStock(StrategyDetail req);

    void insertList(List<StrategyDetail> req);
}
