package com.lzm.lottery.domain.activity.service.stateflow.event;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.common.Result;
import com.lzm.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

@Component
public class CommitState extends AbstractState {
    @Override
    public Result commit(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "Already in commit state, do not duplicate commit");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.PASS);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "Commit has been passed"): Result.buildErrorResult("the alter of status has failed");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.REFUSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "Commit has been refused") : Result.buildErrorResult("the alter of status has failed");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.EDIT);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "commit was revoked and back to the edit status") : Result.buildErrorResult("the alter of status has failed");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "commit was closed") : Result.buildErrorResult("the alter of status has failed");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "only the close status of activity can be open");
    }

    @Override
    public Result undergo(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "the commit status cannot alter directly to undergo status");
    }
}
