package com.lzm.lottery.test;

import com.alibaba.fastjson.JSON;
import com.lzm.lottery.common.Constants;
import com.lzm.lottery.domain.award.model.req.GoodsReq;
import com.lzm.lottery.domain.award.model.res.DistributionRes;
import com.lzm.lottery.domain.award.service.factory.DistributionGoodsFactory;
import com.lzm.lottery.domain.award.service.goods.IDistributionGoods;
import com.lzm.lottery.domain.strategy.model.req.DrawReq;
import com.lzm.lottery.domain.strategy.model.res.DrawResult;
import com.lzm.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.lzm.lottery.domain.strategy.service.draw.IDrawExec;
import com.lzm.lottery.infrastructure.dao.IAwardDao;
import com.lzm.lottery.infrastructure.po.Award;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class SpringRunnerTest {

    private Logger logger = LoggerFactory.getLogger(SpringRunnerTest.class);


    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @Resource
    private IDrawExec drawExec;

    @Resource
    private IAwardDao awardDao;

    @Test
    public void test_awardinfo() {
       Award award = awardDao.queryAwardInfo("1");
        System.out.println(award.getAwardName());
    }


    @Test
    public void test_drawExec() {

       // drawExec.doDrawExec(new DrawReq("小傅哥", 10001L));
       // drawExec.doDrawExec(new DrawReq("小佳佳", 10001L));
       // drawExec.doDrawExec(new DrawReq("小蜗牛", 10001L));
       // drawExec.doDrawExec(new DrawReq("八杯水", 10001L));
//        drawExec.doDrawExec(new DrawReq("niu", 10001L));
//        drawExec.doDrawExec(new DrawReq("boolan", 10001L));
//        drawExec.doDrawExec(new DrawReq("couco", 10001L));
//        drawExec.doDrawExec(new DrawReq("sieki", 10001L));
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("niu", 10001L));
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();
        System.out.println(drawAwardInfo.getAwardName());
    }

    @Test
    public void test_award() {
        // draw
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("niu", 10001L));

        // the state of draw
        Integer drawState = drawResult.getDrawState();
        if (Constants.DrawState.FAIL.getCode().equals(drawState)) {
            logger.info("failure drawing DrawAwardInfo is null");
            return;
        }

        // award order id ，orderId：2109313442431 is a mock here, which should be generated when user finish a draw
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();
        GoodsReq goodsReq = new GoodsReq(drawResult.getUId(), "2109313442431", drawAwardInfo.getAwardId(), drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent(), null, null);

        // according to awardType, and get the corresponding service
        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getIDistributionGoodsService(drawAwardInfo.getAwardType());
        DistributionRes distributionRes = distributionGoodsService.doDistribution(goodsReq);

        logger.info("Test Result：{}", JSON.toJSONString(distributionRes));
    }



}