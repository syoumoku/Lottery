package com.lzm.lottery.domain.activity.service.deploy;

import com.lzm.lottery.domain.activity.model.req.ActivityConfigReq;

public interface IActivityDeploy {

    /**
     * create activity info
     * @param req activity configuration info
     */
    void createActivity(ActivityConfigReq req);

    /**
     * update activity info
     * @param req activity configuration info
     */
    void updateActivity(ActivityConfigReq req);
}
