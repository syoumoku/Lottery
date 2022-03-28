package com.lzm.lottery.domain.strategy.service.draw;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.lzm.lottery.domain.strategy.model.req.DrawReq;
import com.lzm.lottery.domain.strategy.model.res.DrawResult;
import com.lzm.lottery.domain.strategy.model.vo.*;
import com.lzm.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec {

    private Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        // 1. get the draw strategy

        StrategyRich strategyRich = super.queryStrategyRich(req.getStrategyId());
        StrategyBriefVo strategy = strategyRich.getStrategy();

        // 2. check and init rate data
        this.checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyRich.getStrategyDetailList());
        // 3. get the excludeAwardIds
        List<String> excludeAwardIds = this.queryExcludeAwardIds(req.getStrategyId());
        // 4. execute the draw algorithm
        String awardId = this.drawAlgorithm(req.getStrategyId(), drawAlgorithmMap.get(strategy.getStrategyMode()), excludeAwardIds);
        // 5. wrap the result
        return buildDrawResult(req.getUId(), req.getStrategyId(), awardId);
    }

    private DrawResult buildDrawResult(String uId, Long strategyId, String awardId) {
        if (awardId == null) {
            logger.info("The execution of drawing was completed [No reward], user: {}, strategyId: {}", uId, strategyId);
            return new DrawResult(uId, strategyId, Constants.DrawState.FAIL.getCode());
        }

        AwardBriefVO award = super.queryAwardInfoByAwardId(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo(award.getAwardId(), award.getAwardType(), award.getAwardName(), award.getAwardContent());
        logger.info("The execution of drawing was completed [win the reward], " +
                "user: {}, strategyId: {}, awardId:{}, awardName: {}", uId, strategyId, awardId, drawAwardInfo.getAwardName());

        return new DrawResult(uId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);

    }

    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm iDrawAlgorithm, List<String> excludeAwardIds);


    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    private void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetailBriefVO> strategyDetailList) {

        // if not single mode, there is no need to init the tuple rate
       /* if (!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)) {
            return;
        }*/
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);
        if (drawAlgorithm.isExistRateTuple(strategyId)) {
            return;
        }
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetailBriefVO detail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(detail.getAwardId(), detail.getAwardRate()));
        }
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }
}
