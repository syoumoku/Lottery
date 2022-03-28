package com.lzm.lottery.domain.activity.service.stateflow.event;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.common.Result;
import com.lzm.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

@Component
public class CloseState extends AbstractState {

    @Override
    public Result commit(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "the activity is closed");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "the activity is closed");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "the activity is closed");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "the activity is closed");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "the activity is already closed");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.OPEN);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "the activity has been reopened") : Result.buildErrorResult("the alter of status has failed");
    }

    @Override
    public Result undergo(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "the activity is closed");
    }
}
