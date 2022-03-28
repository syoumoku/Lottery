package com.lzm.lottery.domain.activity.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StrategyDetailVO {

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

    @Override
    public String toString() {
        return "StrategyDetailVO{" +
                "strategyId=" + strategyId +
                ", awardId='" + awardId + '\'' +
                ", awardName='" + awardName + '\'' +
                ", awardCount=" + awardCount +
                ", awardSurplusCount=" + awardSurplusCount +
                ", awardRate=" + awardRate +
                '}';
    }
}
