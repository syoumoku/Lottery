package com.lzm.lottery.rpc.res;

import com.lzm.lottery.common.Result;
import com.lzm.lottery.rpc.dto.ActivityDto;

import java.io.Serializable;

public class ActivityRes implements Serializable {

    private Result result;
    private ActivityDto activity;

    public ActivityRes() {
    }

    public ActivityRes(Result result, ActivityDto activity) {
        this.result = result;
        this.activity = activity;
    }

    public ActivityRes(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ActivityDto getActivity() {
        return activity;
    }

    public void setActivity(ActivityDto activity) {
        this.activity = activity;
    }
}
