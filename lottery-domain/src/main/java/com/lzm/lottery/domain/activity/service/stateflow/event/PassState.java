package com.lzm.lottery.domain.activity.service.stateflow.event;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.common.Result;
import com.lzm.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

@Component
public class PassState extends AbstractState {
    @Override
    public Result commit(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "already committed");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "already committed");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.REFUSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "the committed has been confused") : Result.buildErrorResult("the alter of status has failed");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "already committed cannot be revoked(you can firstly refuse this commit)");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "the commit has been closed") : Result.buildErrorResult("the alter of status has failed");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "Only closed activity can be opened");
    }

    @Override
    public Result undergo(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.UNDERGO);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "change to the undergo status successfully") : Result.buildErrorResult("the alter of status has failed");
    }
}
