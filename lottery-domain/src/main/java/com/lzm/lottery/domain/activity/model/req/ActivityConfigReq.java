package com.lzm.lottery.domain.activity.model.req;

import com.lzm.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityConfigReq {
    /** activity ID */
    private Long activityId;

    /** activity Config */
    private ActivityConfigRich activityConfigRich;

}
