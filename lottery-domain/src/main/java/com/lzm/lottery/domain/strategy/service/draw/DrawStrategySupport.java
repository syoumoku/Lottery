package com.lzm.lottery.domain.strategy.service.draw;

import com.lzm.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.lzm.lottery.domain.strategy.model.vo.AwardBriefVO;
import com.lzm.lottery.domain.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;

public class DrawStrategySupport extends DrawConfig{

    @Resource
    protected IStrategyRepository strategyRepository;

    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    protected AwardBriefVO queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }
}
