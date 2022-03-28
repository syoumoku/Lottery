package com.lzm.lottery.domain.strategy.service.draw.impl;


import com.alibaba.fastjson.JSON;

import com.lzm.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.lzm.lottery.domain.strategy.service.draw.AbstractDrawBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("drawExec")
public class DrawExec extends AbstractDrawBase {

    private Logger logger = LoggerFactory.getLogger(DrawExec.class);

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        // execute drawing

        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);

        // judge the result
        if (null == awardId) {
            return null;
        }

        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);
        return isSuccess ? awardId : null;
    }

    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> awardList = strategyRepository.queryNoStockStrategyAwardList(strategyId);
        logger.info("Execute drawing strategy where strategyID: {}, excluded list that has no stock awardList:{}",
                strategyId, JSON.toJSONString(awardList));
        return awardList;
    }
}
