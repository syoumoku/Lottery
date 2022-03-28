package com.lzm.lottery.interfaces;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.common.Result;
import com.lzm.lottery.infrastructure.dao.IActivityDao;
import com.lzm.lottery.infrastructure.po.Activity;
import com.lzm.lottery.rpc.IActivityBooth;
import com.lzm.lottery.rpc.dto.ActivityDto;
import com.lzm.lottery.rpc.req.ActivityReq;
import com.lzm.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;


@Service
public class ActivityBooth implements IActivityBooth {
    @Autowired
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {
        Activity activity = activityDao.queryActivityById(req.getActivityId());
        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);

    }
}
