package com.lzm.lottery.domain.strategy.service.draw;

import com.lzm.lottery.domain.strategy.model.req.DrawReq;
import com.lzm.lottery.domain.strategy.model.res.DrawResult;

public interface IDrawExec {

    /**
     * Draw Interface
     *
     * @param req draw parameters: user Id , strategy Id
     * @return Draw Result
     */
    DrawResult doDrawExec(DrawReq req);
}
