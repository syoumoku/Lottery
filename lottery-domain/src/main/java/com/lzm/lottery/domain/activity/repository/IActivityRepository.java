package com.lzm.lottery.domain.activity.repository;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.domain.activity.model.vo.ActivityVO;
import com.lzm.lottery.domain.activity.model.vo.AwardVO;
import com.lzm.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.lzm.lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;

public interface IActivityRepository {
    /**
     * add activity
     * @param activity activity config
     */
    void addActivity(ActivityVO activity);

    /**
     * add collections of award
     *
     * @param awardList award collections
     */
    void addAward(List<AwardVO> awardList);

    /**
     * add strategy
     *
     * @param strategy strategy config
     */
    void addStrategy(StrategyVO strategy);

    /**
     * add strategy detail
     *
     * @param strategyDetailList add list of strategyDetail
     */
    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);

    /**
     * alter status of activity
     *
     * @param activityId    activity ID
     * @param beforeState   before status
     * @param afterState    after status
     * @return              altered results
     */
    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState);
}
