package com.lzm.lottery.infrastructure.repository;


import com.lzm.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.lzm.lottery.domain.strategy.model.vo.AwardBriefVO;
import com.lzm.lottery.domain.strategy.model.vo.StrategyBriefVo;
import com.lzm.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import com.lzm.lottery.domain.strategy.repository.IStrategyRepository;
import com.lzm.lottery.infrastructure.dao.IAwardDao;
import com.lzm.lottery.infrastructure.dao.IStrategyDao;
import com.lzm.lottery.infrastructure.dao.IStrategyDetailDao;
import com.lzm.lottery.infrastructure.po.Award;
import com.lzm.lottery.infrastructure.po.Strategy;
import com.lzm.lottery.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class StrategyRepository implements IStrategyRepository {


    @Resource
    private IAwardDao awardDao;

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);

        StrategyBriefVo strategyBriefVO = new StrategyBriefVo();
        BeanUtils.copyProperties(strategy, strategyBriefVO);

        List<StrategyDetailBriefVO> strategyDetailBriefVOList = new ArrayList<>();
        for (StrategyDetail strategyDetail : strategyDetailList) {
            StrategyDetailBriefVO strategyDetailBriefVO = new StrategyDetailBriefVO();
            BeanUtils.copyProperties(strategyDetail, strategyDetailBriefVO);
            strategyDetailBriefVOList.add(strategyDetailBriefVO);
        }
        return new StrategyRich(strategyId, strategyBriefVO, strategyDetailBriefVOList);
    }

    @Override
    public AwardBriefVO queryAwardInfo(String awardId) {
        Award award = awardDao.queryAwardInfo(awardId);
        AwardBriefVO awardBriefVO = new AwardBriefVO();
        BeanUtils.copyProperties(award, awardBriefVO);
        return awardBriefVO;

    }

    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {
        return strategyDetailDao.queryNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail req = new StrategyDetail();
        req.setStrategyId(strategyId);
        req.setAwardId(awardId);
        int count = strategyDetailDao.deductStock(req);
        return count == 1;
    }
}
