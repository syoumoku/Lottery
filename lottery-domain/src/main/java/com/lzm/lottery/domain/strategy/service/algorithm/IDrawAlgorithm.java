package com.lzm.lottery.domain.strategy.service.algorithm;

import com.lzm.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

public interface IDrawAlgorithm {

    /**
     * SecureRandom tp generate the random number, to get the corresponding award and return the result
     *
     * @param strategyId
     * @param excludeAwardIds excludes the award ID that cannot been used anymore
     * @return the result of award
     */
    String randomDraw(Long strategyId, List<String> excludeAwardIds);

    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);

    boolean isExistRateTuple(Long strategyId);
}
