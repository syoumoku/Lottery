package com.lzm.lottery.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrawReq {
    //user Id
    private String uId;

    //strategy ID
    private Long strategyId;

}
