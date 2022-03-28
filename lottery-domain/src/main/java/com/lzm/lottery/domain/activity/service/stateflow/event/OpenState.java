package com.lzm.lottery.domain.activity.service.stateflow.event;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.common.Result;
import com.lzm.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

@Component
public class OpenState extends AbstractState {
    @Override
    public Result commit(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "cannot commit when the activity is open");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "cannot be passed when the activity is open");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "cannot be refused when the activity is open");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "cannot be revoked when the activity is open");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "the activity is closed") : Result.buildErrorResult("the alter of status has failed");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "The activity is already open");
    }

    @Override
    public Result undergo(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.UNDERGO);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "change status to undergo successfully") : Result.buildErrorResult("the alter of status has failed");
    }
}
