package com.lzm.lottery.infrastructure.po;

import java.math.BigDecimal;

public class StrategyDetail {
    // Auto ID
    private String id;

    // Strategy ID
    private Long strategyId;

    // Award ID
    private String awardId;

    // Award count
    private String awardCount;

    // Award rate
    private BigDecimal awardRate;

    // Create time
    private String createTime;

    // Update time
    private String updateTime;

    private Integer awardSurplusCount;

    private String awardName;

    public Integer getAwardSurplusCount() {
        return awardSurplusCount;
    }

    public void setAwardSurplusCount(Integer awardSurplusCount) {
        this.awardSurplusCount = awardSurplusCount;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardCount() {
        return awardCount;
    }

    public void setAwardCount(String awardCount) {
        this.awardCount = awardCount;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
