package com.lzm.lottery.domain.award.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class DistributionRes {

    /** User ID */
    private String uId;

    /** Code */
    private Integer code;
    /** Desc */
    private String info;

    /** Receipt ID，eg：coupon id、deliver id，for receipt query */
    private String statementId;

    public DistributionRes(String uId, Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;
    }
}
