package com.lzm.lottery.domain.award.service.goods.impl;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.domain.award.model.req.GoodsReq;
import com.lzm.lottery.domain.award.model.res.DistributionRes;
import com.lzm.lottery.domain.award.service.goods.DistributionBase;
import com.lzm.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

@Component
public class RedeemCodeGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        // mock call of distribution API
        logger.info("mock call of distribution Redeem Code API userID : {}, award content : {}", req.getUId(), req.getAwardContent());

        // update UserAwardState
        super.updateUserAwardState(req.getUId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getUId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.RedeemCodeGoods.getCode();
    }
}
