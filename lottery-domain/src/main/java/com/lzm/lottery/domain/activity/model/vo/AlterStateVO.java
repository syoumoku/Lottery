package com.lzm.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlterStateVO {
    /** activity ID */
    private Long activityId;

    /** before state*/
    private Integer beforeState;

    /** after state */
    private Integer afterState;

}
