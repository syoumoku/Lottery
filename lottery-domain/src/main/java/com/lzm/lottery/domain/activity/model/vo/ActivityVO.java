package com.lzm.lottery.domain.activity.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityVO {
    /** Activity ID */
    private Long activityId;

    /** Activity Name */
    private String activityName;

    /** Activity Description */
    private String activityDesc;

    /** Begin Date */
    private Date beginDateTime;

    /** End Date */
    private Date endDateTime;

    /** Stock */
    private Integer stockCount;

    /** Available Num of chances for every one to draw */
    private Integer takeCount;

    /****Activity State：1.Edit 2. Commit 3. Revoke 4.Pass.5.Undergo(Scan status after apply approved) 6.Refuse 7.Close 8.Open  */
    private Integer state;

    /**
     * creator
     */
    private String creator;

    @Override
    public String toString() {
        return "ActivityVO{" +
                "activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", activityDesc='" + activityDesc + '\'' +
                ", beginDateTime=" + beginDateTime +
                ", endDateTime=" + endDateTime +
                ", stockCount=" + stockCount +
                ", takeCount=" + takeCount +
                ", state=" + state +
                ", creator='" + creator + '\'' +
                '}';
    }

}
