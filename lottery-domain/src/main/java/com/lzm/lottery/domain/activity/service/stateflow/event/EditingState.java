package com.lzm.lottery.domain.activity.service.stateflow.event;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.common.Result;
import com.lzm.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

@Component
public class EditingState extends AbstractState {
    @Override
    public Result commit(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.Commit);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "the activity has been committed") : Result.buildErrorResult("the alter of status has failed");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {

        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "cannot be passed when editing");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {

        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "cannot be refused when editing");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {

        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "cannot be revoked when editing");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "activity has been closed") : Result.buildErrorResult("the alter of status has failed");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "only the close status of activity can be open");
    }

    @Override
    public Result undergo(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "the activity cannot be undergo when editing");
    }
}
