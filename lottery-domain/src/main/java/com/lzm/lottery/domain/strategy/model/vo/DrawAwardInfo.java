package com.lzm.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrawAwardInfo {

    private String awardId;

    private Integer awardType;

    private String awardName;

    /**
     * Description, Award Code, sku
     */
    private String awardContent;


}
