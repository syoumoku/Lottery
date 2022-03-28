package com.lzm.lottery.domain.award.service.goods;

import com.lzm.lottery.domain.award.model.req.GoodsReq;
import com.lzm.lottery.domain.award.model.res.DistributionRes;

public interface IDistributionGoods {

    /**
     * Award Distribution API Award type (1: DESC, 2: RedeemCode, 3: Coupon, 4: Physical Goods)
     * @param req Goods Info
     * @return  result of distribution
     */
    DistributionRes doDistribution(GoodsReq req);

    Integer getDistributionGoodsName();
}
