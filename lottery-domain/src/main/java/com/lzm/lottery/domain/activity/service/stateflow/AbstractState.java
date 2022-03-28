package com.lzm.lottery.domain.activity.service.stateflow;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.common.Result;
import com.lzm.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

public abstract class AbstractState {

    @Resource
    protected IActivityRepository activityRepository;

    public abstract Result commit(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result close(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result open(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result undergo(Long activityId, Enum<Constants.ActivityState> currentState);


}
