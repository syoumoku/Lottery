package com.lzm.lottery.domain.award.service.goods;

import com.lzm.lottery.domain.award.repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class DistributionBase {

    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState, String awardStateInfo) {
        //TODO update the award state in user table
        logger.info("TODO");
    }




}
