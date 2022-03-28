package com.lzm.lottery.domain.activity.service.stateflow;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.common.Result;

public interface IStateHandler {

    Result commit(Long activityId, Enum<Constants.ActivityState> currentState);

    Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState);

    Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState);

    Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState);

    Result close(Long activityId, Enum<Constants.ActivityState> currentState);

    Result open(Long activityId, Enum<Constants.ActivityState> currentState);

    Result undergo(Long activityId, Enum<Constants.ActivityState> currentState);
}
