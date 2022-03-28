package com.lzm.lottery.domain.activity.service.deploy.impl;

import com.alibaba.fastjson.JSON;
import com.lzm.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.lzm.lottery.domain.activity.model.req.ActivityConfigReq;
import com.lzm.lottery.domain.activity.model.vo.ActivityVO;
import com.lzm.lottery.domain.activity.model.vo.AwardVO;
import com.lzm.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.lzm.lottery.domain.activity.model.vo.StrategyVO;
import com.lzm.lottery.domain.activity.repository.IActivityRepository;
import com.lzm.lottery.domain.activity.service.deploy.IActivityDeploy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ActivityDeployImpl implements IActivityDeploy {

    Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {
        logger.info("Creating Activity, activityID : {}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();

        try {
            //add activity config
            ActivityVO activity  = activityConfigRich.getActivity();
            activityRepository.addActivity(activity);

            //add award config
            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            //add strategy config
            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            //add strategy detail config
            List<StrategyDetailVO> strategyDetailVOList = activityConfigRich.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailVOList);

            logger.info("Creation of activity has completed, activity ID : {}", req.getActivityId());
        } catch (DuplicateKeyException e) {
            logger.error("Creation of activity has failed due to unique key error! activity :{}, reqJson :{}", req.getActivityId(), JSON.toJSONString(req));
            throw e;
        }

    }


    @Override
    public void updateActivity(ActivityConfigReq req) {
        //TODO
    }
}
