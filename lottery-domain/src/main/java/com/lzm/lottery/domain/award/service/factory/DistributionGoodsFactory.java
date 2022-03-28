package com.lzm.lottery.domain.award.service.factory;

import com.lzm.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

@Service
public class DistributionGoodsFactory extends GoodsConfig{

    public IDistributionGoods getIDistributionGoodsService(Integer awardType) {
        return goodsMap.get(awardType);
    }
}
