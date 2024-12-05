package cn.itedus.lottery.domain.activity.service.deploy;

import cn.itedus.lottery.domain.activity.model.req.ActivityConfigReq;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author：Luopc
 * @date: 2024/11/28
 */
public interface IActivityDeploy {

    //创建活动信息
    void createActivity(ActivityConfigReq req);

    //修改活动信息
    void updateActivity(ActivityConfigReq req);


}
