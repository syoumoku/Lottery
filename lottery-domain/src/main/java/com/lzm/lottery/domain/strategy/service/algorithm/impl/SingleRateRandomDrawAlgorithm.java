package com.lzm.lottery.domain.strategy.service.algorithm.impl;

import com.lzm.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        //get the strategy tuple
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert  rateTuple != null;

        //random index
        int random = generateSecureRandomIntCode(100);
        int idx = super.hashIdx(random);

        String awardId = rateTuple[idx];

        if (excludeAwardIds.contains(awardId)) {
            return null;
        }

        return awardId;
    }
}
