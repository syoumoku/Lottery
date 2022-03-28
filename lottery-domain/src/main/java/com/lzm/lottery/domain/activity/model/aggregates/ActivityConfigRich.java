package com.lzm.lottery.domain.activity.model.aggregates;

import com.lzm.lottery.domain.activity.model.vo.ActivityVO;
import com.lzm.lottery.domain.activity.model.vo.AwardVO;
import com.lzm.lottery.domain.activity.model.vo.StrategyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActivityConfigRich {
    /** Activity Config */
    private ActivityVO activity;

    /** Strategy Config(includes strategy detail) */
    private StrategyVO strategy;

    /** Award Config */
    private List<AwardVO> awardList;

}
