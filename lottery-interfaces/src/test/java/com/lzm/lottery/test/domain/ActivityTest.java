package com.lzm.lottery.test.domain;

import com.alibaba.fastjson.JSON;
import com.lzm.lottery.common.Constants;
import com.lzm.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.lzm.lottery.domain.activity.model.req.ActivityConfigReq;
import com.lzm.lottery.domain.activity.model.vo.ActivityVO;
import com.lzm.lottery.domain.activity.model.vo.AwardVO;
import com.lzm.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.lzm.lottery.domain.activity.model.vo.StrategyVO;
import com.lzm.lottery.domain.activity.service.deploy.IActivityDeploy;
import com.lzm.lottery.domain.activity.service.stateflow.IStateHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
public class ActivityTest {

    private Logger logger = LoggerFactory.getLogger(ActivityTest.class);

    @Resource
    private IActivityDeploy activityDeploy;

    @Resource
    private IStateHandler stateHandler;

    private ActivityConfigRich activityConfigRich;

    /**
     * TODO：ID generating strategy
     */
    private Long activityId = 120981321L;



    @BeforeEach
    public void init() {
        ActivityVO activity = new ActivityVO();
        activity.setActivityId(activityId);
        activity.setActivityName("test activity");
        activity.setActivityDesc("test activity desc");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(Constants.ActivityState.EDIT.getCode());
        activity.setCreator("zhaomu");

        StrategyVO strategy = new StrategyVO();
        strategy.setStrategyId(10002L);
        strategy.setStrategyDesc("drawing strategy");
        strategy.setStrategyMode(Constants.StrategyMode.SINGLE.getCode());
        strategy.setGrantType(1);
        strategy.setGrantDate(new Date());
        strategy.setExtInfo("");

        StrategyDetailVO strategyDetail_01 = new StrategyDetailVO();
        strategyDetail_01.setStrategyId(strategy.getStrategyId());
        strategyDetail_01.setAwardId("101");
        strategyDetail_01.setAwardName("First Prize");
        strategyDetail_01.setAwardCount(10);
        strategyDetail_01.setAwardSurplusCount(10);
        strategyDetail_01.setAwardRate(new BigDecimal("0.05"));

        StrategyDetailVO strategyDetail_02 = new StrategyDetailVO();
        strategyDetail_02.setStrategyId(strategy.getStrategyId());
        strategyDetail_02.setAwardId("102");
        strategyDetail_02.setAwardName("Second Prize");
        strategyDetail_02.setAwardCount(20);
        strategyDetail_02.setAwardSurplusCount(20);
        strategyDetail_02.setAwardRate(new BigDecimal("0.15"));

        StrategyDetailVO strategyDetail_03 = new StrategyDetailVO();
        strategyDetail_03.setStrategyId(strategy.getStrategyId());
        strategyDetail_03.setAwardId("103");
        strategyDetail_03.setAwardName("Third Prize");
        strategyDetail_03.setAwardCount(50);
        strategyDetail_03.setAwardSurplusCount(50);
        strategyDetail_03.setAwardRate(new BigDecimal("0.20"));

        StrategyDetailVO strategyDetail_04 = new StrategyDetailVO();
        strategyDetail_04.setStrategyId(strategy.getStrategyId());
        strategyDetail_04.setAwardId("104");
        strategyDetail_04.setAwardName("Forth Prize");
        strategyDetail_04.setAwardCount(100);
        strategyDetail_04.setAwardSurplusCount(100);
        strategyDetail_04.setAwardRate(new BigDecimal("0.25"));

        StrategyDetailVO strategyDetail_05 = new StrategyDetailVO();
        strategyDetail_05.setStrategyId(strategy.getStrategyId());
        strategyDetail_05.setAwardId("104");
        strategyDetail_05.setAwardName("Fifth Prize");
        strategyDetail_05.setAwardCount(500);
        strategyDetail_05.setAwardSurplusCount(500);
        strategyDetail_05.setAwardRate(new BigDecimal("0.35"));

        List<StrategyDetailVO> strategyDetailList = new ArrayList<>();
        strategyDetailList.add(strategyDetail_01);
        strategyDetailList.add(strategyDetail_02);
        strategyDetailList.add(strategyDetail_03);
        strategyDetailList.add(strategyDetail_04);
        strategyDetailList.add(strategyDetail_05);

        strategy.setStrategyDetailList(strategyDetailList);

        AwardVO award_01 = new AwardVO();
        award_01.setAwardId("101");
        award_01.setAwardType(Constants.AwardType.DESC.getCode());
        award_01.setAwardName("computer");
        award_01.setAwardContent("please contact dd");

        AwardVO award_02 = new AwardVO();
        award_02.setAwardId("102");
        award_02.setAwardType(Constants.AwardType.DESC.getCode());
        award_02.setAwardName("tele");
        award_02.setAwardContent("please contact dd");

        AwardVO award_03 = new AwardVO();
        award_03.setAwardId("103");
        award_03.setAwardType(Constants.AwardType.DESC.getCode());
        award_03.setAwardName("macbook");
        award_03.setAwardContent("please contact dd");

        AwardVO award_04 = new AwardVO();
        award_04.setAwardId("104");
        award_04.setAwardType(Constants.AwardType.DESC.getCode());
        award_04.setAwardName("earphone");
        award_04.setAwardContent("please contact dd");

        AwardVO award_05 = new AwardVO();
        award_05.setAwardId("105");
        award_05.setAwardType(Constants.AwardType.DESC.getCode());
        award_05.setAwardName("data cable");
        award_05.setAwardContent("please contact dd");

        List<AwardVO> awardList = new ArrayList<>();
        awardList.add(award_01);
        awardList.add(award_02);
        awardList.add(award_03);
        awardList.add(award_04);
        awardList.add(award_05);

        activityConfigRich = new ActivityConfigRich(activity, strategy, awardList);

    }


    @Test
    public void test_createActivity() {
        activityDeploy.createActivity(new ActivityConfigReq(activityId, activityConfigRich));
    }

    @Test
    public void test_alterState() {
        logger.info("commit the activity，test：{}", JSON.toJSONString(stateHandler.commit(100001L, Constants.ActivityState.EDIT)));
        logger.info("pass the commit，test：{}", JSON.toJSONString(stateHandler.checkPass(100001L, Constants.ActivityState.Commit)));
        logger.info("undergo the activity，test：{}", JSON.toJSONString(stateHandler.undergo(100001L, Constants.ActivityState.PASS)));
        logger.info("second commit，test：{}", JSON.toJSONString(stateHandler.checkPass(100001L, Constants.ActivityState.EDIT)));
    }

}
