package com.lzm.lottery.infrastructure.dao;

import com.lzm.lottery.domain.activity.model.vo.AlterStateVO;
import com.lzm.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IActivityDao {

    void insert(Activity req);

    Activity queryActivityById(Long activityId);

    int alterState(AlterStateVO alterStateVO);
}
