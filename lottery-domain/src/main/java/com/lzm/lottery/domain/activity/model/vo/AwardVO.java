package com.lzm.lottery.domain.activity.model.vo;

import lombok.Data;

@Data
public class AwardVO {

    /** Award ID */
    private String awardId;

    /** Award Type（1:desc、2:redeem code、3:coupon、4:physical good） */
    private Integer awardType;

    /** Award Name */
    private String awardName;

    /** Award Content「desc、code、sku」 */
    private String awardContent;

    @Override
    public String toString() {
        return "AwardVO{" +
                "awardId='" + awardId + '\'' +
                ", awardType=" + awardType +
                ", awardName='" + awardName + '\'' +
                ", awardContent='" + awardContent + '\'' +
                '}';
    }
}
