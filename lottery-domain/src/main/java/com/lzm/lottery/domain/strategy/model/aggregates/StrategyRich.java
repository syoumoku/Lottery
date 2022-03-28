package com.lzm.lottery.domain.strategy.model.aggregates;

import com.lzm.lottery.domain.strategy.model.vo.StrategyBriefVo;
import com.lzm.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StrategyRich {

    private Long strategyId;
    private StrategyBriefVo strategy;
    private List<StrategyDetailBriefVO> strategyDetailList;


}
