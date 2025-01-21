package cn.itedus.lottery.domain.activity.repository;

import java.util.Date;

/**
 * @description:
 * @author：Luopc
 * @date: 2025/1/21
 */
public interface IUserTakeActivityRepository {

    //扣减个人活动参与次数
    int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date partakeDate);

    //领取活动
    void takeActivity(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId);

}
