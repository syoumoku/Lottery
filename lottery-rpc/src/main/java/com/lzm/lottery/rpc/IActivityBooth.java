package com.lzm.lottery.rpc;

import com.lzm.lottery.rpc.req.ActivityReq;
import com.lzm.lottery.rpc.res.ActivityRes;

public interface IActivityBooth {

    ActivityRes queryActivityById(ActivityReq req);
}
