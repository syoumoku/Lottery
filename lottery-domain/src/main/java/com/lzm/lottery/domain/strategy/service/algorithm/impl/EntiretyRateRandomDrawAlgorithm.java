package com.lzm.lottery.domain.strategy.service.algorithm.impl;


import com.lzm.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.lzm.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component("entiretyRateRandomDrawAlgorithm")
public class EntiretyRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        BigDecimal differenceDenominator = BigDecimal.ZERO;

        //exclude the award that is not in the collection
        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();
        List<AwardRateInfo> awardRateIntervalList = awardRateInfoMap.get(strategyId);

        for (AwardRateInfo awardInfo : awardRateIntervalList) {
            String awardId = awardInfo.getAwardId();
            if (excludeAwardIds.contains(awardId)) {
                continue;
            }
            differenceAwardRateList.add(awardInfo);
            differenceDenominator = differenceDenominator.add(awardInfo.getAwardRate());
        }

        // list size == 0 return null
        if (differenceAwardRateList.size() == 0) return null;
        // list size == 0 return directly
        if (differenceAwardRateList.size() == 1) return differenceAwardRateList.get(0).getAwardId();

        int randomVal = this.generateSecureRandomIntCode(100);

        String awardId = null;
        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo : differenceAwardRateList) {
            int rateVal = awardRateInfo.getAwardRate().divide(differenceDenominator,2, BigDecimal.ROUND_UP)
                    .multiply(new BigDecimal(100)).intValue();
            if (randomVal <= (cursorVal + rateVal)) {
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += rateVal;

        }

        return awardId;
    }
}
