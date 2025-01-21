package cn.itedus.lottery.domain.activity.service.partake;

import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.PartakeResult;

/**
 * @description:
 * @author：Luopc
 * @date: 2024/11/28
 */
public interface IActivityPartake {

    /**
     * 参与活动
     * @param   req 入参
     * @return    领取结果
     */
    PartakeResult doPartake(PartakeReq req);

}
