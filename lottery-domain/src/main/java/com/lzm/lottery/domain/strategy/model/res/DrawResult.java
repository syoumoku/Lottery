package com.lzm.lottery.domain.strategy.model.res;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.domain.strategy.model.vo.DrawAwardInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrawResult {

    private String uId;

    private Long strategyId;

    private Integer drawState = Constants.DrawState.FAIL.getCode();

    private DrawAwardInfo drawAwardInfo;

    public DrawResult(String uId, Long strategyId, Integer code) {
    }
}
