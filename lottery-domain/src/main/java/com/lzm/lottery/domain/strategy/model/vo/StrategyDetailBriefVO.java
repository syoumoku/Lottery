package com.lzm.lottery.domain.strategy.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StrategyDetailBriefVO {

    /**
     * strategy ID
     */
    private Long strategyId;

    /**
     * award ID
     */
    private String awardId;

    /**
     * award Name
     */
    private String awardName;

    /**
     * award count
     */
    private Integer awardCount;

    /**
     * award Surplus Count
     */
    private Integer awardSurplusCount;

    /**
     * award rate
     */
    private BigDecimal awardRate;

}
