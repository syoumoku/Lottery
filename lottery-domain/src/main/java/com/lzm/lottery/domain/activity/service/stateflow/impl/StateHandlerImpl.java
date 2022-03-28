package com.lzm.lottery.domain.activity.service.stateflow.impl;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.common.Result;
import com.lzm.lottery.domain.activity.service.stateflow.IStateHandler;
import com.lzm.lottery.domain.activity.service.stateflow.StateConfig;
import org.springframework.stereotype.Service;

@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler {
    @Override
    public Result commit(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateMap.get(currentState).commit(activityId, currentState);
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateMap.get(currentState).checkPass(activityId, currentState);
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateMap.get(currentState).checkRefuse(activityId, currentState);
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateMap.get(currentState).checkRevoke(activityId, currentState);
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateMap.get(currentState).close(activityId, currentState);
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateMap.get(currentState).open(activityId, currentState);
    }

    @Override
    public Result undergo(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateMap.get(currentState).undergo(activityId, currentState);
    }
}
