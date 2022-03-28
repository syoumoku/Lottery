package com.lzm.lottery.domain.strategy.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class StrategyBriefVo {

    /**
     * strategy ID
     */
    private Long strategyId;

    /**
     * strategy desc
     */
    private String strategyDesc;

    /**
     * strategy mode「1:single、2:entirety」
     */
    private Integer strategyMode;

    /**
     * grant method「1:instant、2:on time[e.g. after activity]、3:manual」
     */
    private Integer grantType;

    /**
     * grantDate
     */
    private Date grantDate;

    /**
     * extension info
     */
    private String extInfo;

}
