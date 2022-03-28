package com.lzm.lottery.rpc.dto;

import java.io.Serializable;
import java.util.Date;

public class ActivityDto implements Serializable {

    // Activity ID
    private Long activityId;

    // Activity Name
    private String activityName;

    // Activity Description
    private String activityDesc;

    // Begin Date
    private Date beginDateTime;

    // End Date
    private Date endDateTime;

    // Stock
    private Integer stockCount;

    //Available Num of chances for every one to draw
    private Integer takeCount;

    //Activity State：1.Edit 2. Commit 3. Withdraw 4.Pass.5.Run(Scan status after apply approved) 6.Reject 7.Close 8.Start
    private Integer state;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public Date getBeginDateTime() {
        return beginDateTime;
    }

    public void setBeginDateTime(Date beginDateTime) {
        this.beginDateTime = beginDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
