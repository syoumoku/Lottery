package com.lzm.lottery.domain.award.model.req;

import com.lzm.lottery.domain.award.model.vo.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GoodsReq {

    /** User ID */
    private String uId;

    /** Order ID */
    private String orderId;

    /** Award ID */
    private String awardId;

    /**
     * Award Name
     */
    private String awardName;

    /**
     * award content「description、award code、sku」
     */
    private String awardContent;

    /** shipping Address（only physical prize need） */
    private ShippingAddress shippingAddress;

    /** extension information */
    private String extInfo;


}
